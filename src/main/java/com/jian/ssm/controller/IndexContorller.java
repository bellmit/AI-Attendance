package com.jian.ssm.controller;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jian.ssm.entity.Department;
import com.jian.ssm.entity.Employee;
import com.jian.ssm.entity.UserRole;
import com.jian.ssm.entity.Version;
import com.jian.ssm.service.DepartmentService;
import com.jian.ssm.service.EmployeeService;
import com.jian.ssm.service.VersionService;
import com.jian.ssm.util.ReadICcardThread;

/**
 * 
 * @ClassName: IndexContorller
 * @Description:TODO
 * @author: jianlinwei
 * @date: 2018��4��26�� ����5:07:57
 *
 */
@SuppressWarnings(value = { "resource" })  
@Controller
@RequestMapping("/index")
public class IndexContorller {
	@Autowired
	DepartmentService dps;
	@Autowired
	VersionService vs;
	@Autowired
	EmployeeService es;

	/**
	 * 
	 * @Title: department @Description: 部门 @param: @return @author:
	 * jianlinwei @return: String @throws
	 */
	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public String department(HttpServletRequest request) {
		UserRole  ur = (UserRole) request.getSession().getAttribute("UserRole");
		List<Department> ld = dps.selectDepens(ur.getBelongid());
		if (ld != null) {
			request.setAttribute("ld", ld);
		}

		return "visitorJsp/department";
	}

	@RequestMapping(value = "/insertDepartment", method = RequestMethod.POST)
	public String insertDepartment(HttpServletRequest request, Model model) {
		UserRole ur = (UserRole) request.getSession().getAttribute("UserRole");
		String departmentName = request.getParameter("departmentName");
		Department department = dps.selectDepen(departmentName,ur.getBelongid());
		if (department == null) {
			int x = dps.insertDepartment(departmentName,ur.getBelongid());
			if (x == 1) {
				Version version = vs.selectVerson("department",ur.getBelongid());
				long version_time = System.currentTimeMillis();
				if (version == null) {
					vs.insertVersion("department", version_time ,ur.getBelongid());
				} else {
					vs.updateVersion("department", version_time,ur.getBelongid());
				}
			}
		} else {
			model.addAttribute("msg", "已存在该部门");
		}
		return "visitorJsp/department";
	}

	@RequestMapping(value = "/deleteDepartment", method = RequestMethod.POST)
	public String deleteDepartment(HttpServletRequest request) {
		UserRole  ur = (UserRole) request.getSession().getAttribute("UserRole");
		String departmentId = request.getParameter("departmentId");
		int departmentid = Integer.valueOf(departmentId);
		try {
			int x = dps.deleteDepen(departmentid,ur.getBelongid());
			if (x == 1) {
				vs.updateVersion("department", System.currentTimeMillis(),ur.getBelongid());
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "visitorJsp/department";
	}

	/**
	 * 
	 * @Title: employee @Description: 员工 @param: @param
	 * request @param: @return @author: jianlinwei @return: String @throws
	 */
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String employee(HttpServletRequest request) {
		return "visitorJsp/employee";
	}

	@RequestMapping(value = "insertEmp", method = RequestMethod.GET)
	public String insertEmp(HttpServletRequest request, Model model) {
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		try {
			List<Department> ld = dps.selectDepens(ur.getBelongid());
			request.setAttribute("ld", ld);
		} catch (Exception e) {
			model.addAttribute("msg", "数据库异常");
		}
		return "visitorJsp/insertEmp";
	}

	@RequestMapping(value = "insertEmp", method = RequestMethod.POST)
	public String insertEmp(HttpServletRequest request, HttpServletResponse response, Model model) {
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String id  = request.getParameter("id");
		String ICcard = request.getParameter("ICcard");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String departmentId = request.getParameter("departmentId");
		String sex = request.getParameter("sex");
		String canvas = request.getParameter("canvas");
		int departmentid = Integer.valueOf(departmentId);
		String photo_base = canvas.substring(canvas.indexOf(",")+1);
		List<Employee>  le = es.selectEmpByWorkId(id, ur.getBelongid());
		Employee  e  = es.selectEmpByICcard(ICcard);
		if(e==null){
		if(le.size()==0){
		String msg = es.insertEmp(id ,departmentid, name,  phone, email, photo_base, sex, ur.getBelongid(), request,ICcard);
		model.addAttribute("msg", msg);
		List<Department> ld = dps.selectDepens(ur.getBelongid());
		request.setAttribute("ld", ld);
		}else{
			model.addAttribute("msg", "已存在该工号的人");
		}
		}else{
			model.addAttribute("msg", "已存在使用该IC卡的人");
		}
		return "visitorJsp/insertEmp";
	}

	// 数据列表
	@RequestMapping(value = "seleteEmp", method = RequestMethod.GET)
	@ResponseBody
	public String seleteEmp(HttpServletRequest request) {
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		List<Employee> le = es.seleteLemp(befor, after,ur.getBelongid());
		Base64.Encoder  en  = Base64.getEncoder();
		for (int i = 0; i < le.size(); i++) {
			int departmentid = le.get(i).getDepartmentid();
			String departmentName = dps.seleteDepenName(departmentid,ur.getBelongid());
			le.get(i).setDepartmentname(departmentName);
			if(le.get(i).getPhoto()!=null){
			le.get(i).setPhoto_base(en.encodeToString(le.get(i).getPhoto()));
			}
			le.get(i).setPhoto(null);
			le.get(i).setPhotofeature(null);
		}
		int count = es.seleteEmpCount(ur.getBelongid());
		Map<String, List<Employee>> me = new HashMap<String, List<Employee>>();
		me.put("data", le);
		JSONObject json = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", count);
		json.put("data", me.get("data"));

		return json.toString();
	}
	@RequestMapping(value="selectEmpPhoto" , method= RequestMethod.GET)
	@ResponseBody
	public  String selectEmpPhoto(HttpServletRequest request){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String  id = request.getParameter("id");
		
          byte[] photo = es.selectEmpById(id, ur.getBelongid()).getPhoto();
          JSONObject  json  = new JSONObject();
          StringBuffer sb = new StringBuffer();
          if(photo!=null){
          Base64.Encoder  en  = Base64.getEncoder();
		
		sb.append("<img width=\"320\" height=\"240\"  src= \" " +  "data:image/png;base64," + en.encodeToString(photo) + "\">");
       
          }else{
        	  sb.append("无照片");
          }
          json.put("data", sb.toString());
		return json.toString() ;
	}
	
	/*
	 * 员工数据重载
	 */
	@RequestMapping(value="/selectEmpByName" ,method = RequestMethod.GET)
	@ResponseBody
	public  String  selectEmpByName(HttpServletRequest request){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String  name  = request.getParameter("name");
		/*try {
			if(StringUtils.isNotEmpty(name)){
			name = new String(name.getBytes("ISO-8859-1"),"utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		Base64.Encoder  en  = Base64.getEncoder();
        List<Employee>  le =		es.selectEmpByName(name ,ur.getBelongid());
        for (int i = 0; i < le.size(); i++) {
			int departmentid = le.get(i).getDepartmentid();
			String departmentName = dps.seleteDepenName(departmentid,ur.getBelongid());
			le.get(i).setDepartmentname(departmentName);
			if(le.get(i).getPhoto()!=null){
			le.get(i).setPhoto_base(en.encodeToString(le.get(i).getPhoto()));
			}
			le.get(i).setPhoto(null);
			le.get(i).setPhotofeature(null);
			
		}
        int count = le.size();
		Map<String, List<Employee>> me = new HashMap<String, List<Employee>>();
		me.put("data", le);
		JSONObject json = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", count);
		json.put("data", me.get("data"));
		return json.toString();
	}
	
	
	@RequestMapping(value="/selectEmpByDepartmentname" , method= RequestMethod.GET)
	@ResponseBody
	public  String selectEmpByDepartmentname(HttpServletRequest request){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String   departmentName  =  request.getParameter("departmentname");
		/*try {
			if(StringUtils.isNotEmpty(departmentName)){
				departmentName = new String(departmentName.getBytes("ISO-8859-1"),"utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		Base64.Encoder  en  = Base64.getEncoder();
		List<Employee>  le  = es.selectEmpByDepartmentname(departmentName, ur.getBelongid());
        for (int i = 0; i < le.size(); i++) {
			/*int departmentid = le.get(i).getDepartmentid();*/
			/*String departmentName_1 = dps.seleteDepenName(departmentid,ur.getBelongid());*/
			le.get(i).setDepartmentname(departmentName);
			if(le.get(i).getPhoto()!=null){
			le.get(i).setPhoto_base(en.encodeToString(le.get(i).getPhoto()));
			}
			le.get(i).setPhoto(null);
			le.get(i).setPhotofeature(null);
		}
        int count = le.size();
		Map<String, List<Employee>> me = new HashMap<String, List<Employee>>();
		me.put("data", le);
		JSONObject json = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", count);
		json.put("data", me.get("data"));
		return json.toString();
	}
	
	@RequestMapping(value="/selectEmpByWorkId" ,method = RequestMethod.GET)
	@ResponseBody
	public  String  selectEmpByWorkId(HttpServletRequest request){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String workId = request.getParameter("workId");
		List<Employee> le  = es.selectEmpByWorkId(workId, ur.getBelongid());
		Base64.Encoder  en  = Base64.getEncoder();
		for (int i = 0; i < le.size(); i++) {
			int departmentid = le.get(i).getDepartmentid();
			String departmentName = dps.seleteDepenName(departmentid,ur.getBelongid());
			le.get(i).setDepartmentname(departmentName);
		
			if(le.get(i).getPhoto()!=null){
			le.get(i).setPhoto_base(en.encodeToString(le.get(i).getPhoto()));
			}
			le.get(i).setPhoto(null);
			le.get(i).setPhotofeature(null);
		}
        int count = le.size();
		Map<String, List<Employee>> me = new HashMap<String, List<Employee>>();
		me.put("data", le);
		JSONObject json = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", count);
		json.put("data", me.get("data"));
		return json.toString();
	}
	
	@RequestMapping(value="selectEmpByICcard" , method = RequestMethod.GET)
	@ResponseBody
	public  String  selectEmpByICcard(HttpServletRequest request){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String ICcard = request.getParameter("ICcard");
		List<Employee> le  = es.selectEmpByICcardList(ICcard, ur.getBelongid());
		Base64.Encoder  en  = Base64.getEncoder();
		for (int i = 0; i < le.size(); i++) {
			int departmentid = le.get(i).getDepartmentid();
			String departmentName = dps.seleteDepenName(departmentid,ur.getBelongid());
			le.get(i).setDepartmentname(departmentName);
		
			if(le.get(i).getPhoto()!=null){
			le.get(i).setPhoto_base(en.encodeToString(le.get(i).getPhoto()));
			}
			le.get(i).setPhoto(null);
			le.get(i).setPhotofeature(null);
		}
        int count = le.size();
		Map<String, List<Employee>> me = new HashMap<String, List<Employee>>();
		me.put("data", le);
		JSONObject json = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", count);
		json.put("data", me.get("data"));
		return json.toString();
	}
	
	
	
	@RequestMapping(value="/getDepartMent" ,method = RequestMethod.GET)
	@ResponseBody
	public  String  getDepartMent(HttpServletRequest request){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
			List<Department> ld = dps.selectDepens(ur.getBelongid());
		JSONObject  json  = new JSONObject();
		json.put("department", ld);
		
		return json.toString();
	}
	
	@RequestMapping(value="/updateEmp", method = RequestMethod.POST)
	@ResponseBody
	public  String updateEmp(HttpServletRequest  request){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String  data  = request.getParameter("data");
		JSONObject  json  = new  JSONObject(data);
		Employee  employee  =  new Employee();
		employee.setBelongid(ur.getBelongid());
		employee.setId(json.getString("id"));
		employee.setName(json.getString("name"));
		employee.setSex(json.getString("sex"));
		employee.setDepartmentid(json.getInt("departmentId"));
		employee.setEmail(json.getString("email"));
		employee.setPhone(json.getString("phone"));
		employee.setICcard(json.getString("ICcard"));
		String canvas  = json.getString("canvas");
		String canvas_new  = canvas.substring(canvas.indexOf(",")+1);
		employee.setPhoto_base(canvas_new);
		String id = request.getParameter("id");
	    int value =	es.updateEmp(employee, id,request);
		JSONObject json_1  = new JSONObject();
		if(value == 1){
			json_1.put("msg", "成功");
		}else if(value == -1){
			json_1.put("msg", "照片中没有人脸");
		}else if(value == 2){
			json_1.put("msg", "照片中有多张人脸");
		}else if(value == 0){
			json_1.put("msg", "更新出错了");
		}
		return json_1.toString();
	}
	
	
/*
 * 删除员工
 */
	@RequestMapping(value = "deleteEmp", method = RequestMethod.POST)
	public String deleteEmp(HttpServletRequest request) {
		UserRole  ur = (UserRole) request.getSession().getAttribute("UserRole");
		String id = request.getParameter("id");
		
		
		es.deleteEmp(id ,ur.getBelongid());

		return "visitorJsp/employee";
	}
	
	
	/**
	 * 下载模板表格
	 */
	@RequestMapping(value="/downModelExcel",method=RequestMethod.GET)
	public  void downModelExcel(HttpServletResponse  response ,HttpServletRequest  request){
		  
		        response.reset(); //清除buffer缓存
		        // 指定下载的文件名
		        response.setHeader("Content-Disposition", "attachment;filename=001.xlsx");
		        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		        response.setHeader("Pragma", "no-cache");
		        response.setHeader("Cache-Control", "no-cache");
		        response.setDateHeader("Expires", 0);
		        String path  = request.getSession().getServletContext().getRealPath("/download");
		        try{
	            InputStream in = new BufferedInputStream(new FileInputStream(path+"/001.xlsx"), 1024);
		        
		        OutputStream os = new BufferedOutputStream(response.getOutputStream());
	            
	            byte[] bytes = new byte[1024];
	            int i = 0;
	            while ((i = in.read(bytes)) > 0) {
	                os.write(bytes, 0, i);
	            }
	            os.flush();
	            os.close();
		        }catch(Exception e){
		        	e.printStackTrace();
		        }
	}
	
	/**
	 * 导入
	 */
	
	@RequestMapping(value = "/importEcxel"  , method =RequestMethod.POST)
	@ResponseBody
	public String impotr(HttpServletRequest request, Model model)  {
		UserRole  ur  =  (UserRole) request.getSession().getAttribute("UserRole");
		int x = 0;
	  try{
	     //获取上传的文件
	     MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
	     Iterator<String>  filenamaes  = multipart.getFileNames();
	     while(filenamaes.hasNext()){
	    	 MultipartFile file = multipart.getFile(filenamaes.next());
		     InputStream in = file.getInputStream();
		     //数据导入
		   x=  es.importExcelInfo(in,file ,ur);
		     in.close();
	     }
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	  JSONObject  json = new JSONObject();
	  json.put("code", x);
	  json.put("msg", "");
	  json.put("data", "{}");
	  
	     return  json.toString();
	}
	
	/*
	 * 开门延时
	 */
	@RequestMapping(value="/SetDoorDelay" , method = RequestMethod.POST)
	@ResponseBody
	public String  SetDoorDelay(HttpServletRequest  request){
		JSONObject  json = new JSONObject();
		int  time  = Integer.valueOf(request.getParameter("test"));
		ReadICcardThread.SetOpenDelay(time);
		json.put("msg", 1);
		return  json.toString();
	}
	
	@RequestMapping(value="/SetDoorPassWord" , method = RequestMethod.POST)
	@ResponseBody
	public String  SetDoorPassWord(HttpServletRequest  request){
		JSONObject  json = new JSONObject();
		int  time  = Integer.valueOf(request.getParameter("test"));
		ReadICcardThread.SetPassword(time);
		json.put("msg", 1);
		return  json.toString();
	}
	
}
