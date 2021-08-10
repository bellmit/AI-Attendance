package com.jian.ssm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import com.jian.ssm.entity.Reason;
import com.jian.ssm.entity.UserRole;
import com.jian.ssm.entity.VisitInfo;
import com.jian.ssm.entity.Visiting;
import com.jian.ssm.entity.Vistor;
import com.jian.ssm.service.DeviceService;
import com.jian.ssm.service.EmployeeService;
import com.jian.ssm.service.ReasonService;
import com.jian.ssm.service.VisitInfoService;
import com.jian.ssm.service.VistorService;

import net.coobird.thumbnailator.Thumbnails;



/**
 * 
 * @ClassName: VistorController
 * @Description:TODO
 * @author: jianlinwei
 * @date: 2018年5月14日 下午6:14:44
 *
 */
@SuppressWarnings(value = { "unused" ,"resource" })  
@Controller
@RequestMapping("/vistor")
public class VistorController {
	@Autowired
	ReasonService rs;
	@Autowired
	VisitInfoService vis;
	@Autowired
	EmployeeService es ;
	@Autowired
	DeviceService  ds ;
	@Autowired
	VistorService  vs ;
    
	/**
	 * 
	 * @Title: vistor @Description: 访客 @param: @return @author:
	 * jianlinwei @return: String @throws
	 */

	@RequestMapping(value = "/vistormanage", method = RequestMethod.GET)
	public String vistor() {
		return "visitorJsp/vistormanage";
	}
 /*
  * 数据列表
  */
	@RequestMapping(value = "/getvisitinfo", method = RequestMethod.GET)
	@ResponseBody
	public String getvisitinfo(HttpServletRequest request) {
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		List<VisitInfo> lv = vis.selectVisit(befor, after,ur.getBelongid());
		List<Visiting> lvi = new ArrayList<Visiting>();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(int i = 0 ; i < lv.size() ; i++){
			Visiting  vi = new Visiting();
			vi.setId(lv.get(i).getVisitid());
			vi.setVisitorName(lv.get(i).getVisitorname());
			vi.setEmpName(lv.get(i).getEmployeeName());
			vi.setReasonName(rs.selectReasonName(lv.get(i).getReasonid() , ur.getBelongid()));
			if(lv.get(i).getState() == 0){
				vi.setState("<p  class=\"layui-btn layui-btn-danger\">访问中</p>");
			}else if(lv.get(i).getState() == 1){
				vi.setState("<p  class=\"layui-btn\">已签离</p>");
			}else if(lv.get(i).getState() == 2){
				vi.setState("<p  class=\"layui-btn layui-btn-warm\">预约中</p>");
			}else if(lv.get(i).getState() == 3){
				vi.setState("<p  class=\"layui-btn layui-btn-normal\">邀请中</p>");
			}
			vi.setCheckInDevice(ds.selectDescription(lv.get(i).getCheckindeviceid(),lv.get(i).getBelongid()));
			if(lv.get(i).getCheckintime() == 0){
				vi.setCheckInTime(" ");
			}else{
				vi.setCheckInTime(df.format(new Date(lv.get(i).getCheckintime())));
			}
			vi.setCheckOutDevice(ds.selectDescription(lv.get(i).getCheckoutdeviceid(),lv.get(i).getBelongid()));
			if(lv.get(i).getCheckouttime() == 0){
				vi.setCheckOutTime(" ");
			}else{
				vi.setCheckOutTime(df.format(new Date(lv.get(i).getCheckouttime())));
			}
			lvi.add(vi);
		}
		
		Map<String, List<Visiting>> map = new HashMap<String, List<Visiting>>();
		map.put("data", lvi);
		int count = vis.selectCount(ur.getBelongid());
		JSONObject json = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", count);
		json.put("data", map.get("data"));
		return json.toString();
	}
	/*
	 * 导出数据
	 */
	
	@RequestMapping(value="/exportExcel" ,method=RequestMethod.POST)
	@ResponseBody
	public  String  exportExcel(HttpServletRequest request,HttpServletResponse response){
		JSONObject json = new JSONObject();
	    String salaryDate = request.getParameter("data_ex");
	    try {
			if(StringUtils.isNotEmpty(salaryDate)){
	        XSSFWorkbook workbook=null;
	        //导出Excel对象
	        workbook = vis.exportExcelInfo(salaryDate);
	        String path  = request.getSession().getServletContext().getRealPath("/download");
			String path_ex  =System.currentTimeMillis()+".xlsx";
	        FileOutputStream  fileOutputStream  = new FileOutputStream(path+"/"+path_ex);
	            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(fileOutputStream);
	            bufferedOutPut.flush();
	            workbook.write(bufferedOutPut);
	            bufferedOutPut.close();
			  json.put("url_ex", path_ex);
			
			}
			} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
		}
	    
	    return  json.toString();
	}
	
	@RequestMapping(value="/down",method=RequestMethod.GET)
	public  void export(HttpServletRequest request, HttpServletResponse response)  {
	    String url = request.getParameter("url");
	    if(url!=""){
	        response.reset(); //清除buffer缓存
	        // 指定下载的文件名
	        response.setHeader("Content-Disposition", "attachment;filename="+url);
	        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
	        response.setHeader("Pragma", "no-cache");
	        response.setHeader("Cache-Control", "no-cache");
	        response.setDateHeader("Expires", 0);
	        String path  = request.getSession().getServletContext().getRealPath("/download");
	        try{
			InputStream in = new BufferedInputStream(new FileInputStream(path+"/"+url), 1024);
	        
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
	}
	
	
	/*
	 * 数据重载
	 */
	@RequestMapping(value="/getvisitInfoByVisitorName",method = RequestMethod.GET)
	@ResponseBody
  public String visitInfoByKey(HttpServletRequest request){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		String visitorName = null;
		try {
			if(StringUtils.isNotEmpty(request.getParameter("visitorName"))){
			visitorName = new String(request.getParameter("visitorName").getBytes("ISO-8859-1"),"utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		List<VisitInfo>  lv  = vis.visitReloadByVisitorName(visitorName,  befor, after,ur.getBelongid());
		List<Visiting> lvi = new ArrayList<Visiting>();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for(int i = 0 ; i < lv.size() ; i++){
			Visiting  vi = new Visiting();
			vi.setId(lv.get(i).getVisitid());
			vi.setVisitorName(lv.get(i).getVisitorname());
			vi.setEmpName(es.selectEmpName(lv.get(i).getEmployeeid(),ur.getBelongid()));
			vi.setReasonName(rs.selectReasonName(lv.get(i).getReasonid(),ur.getBelongid()));
			if(lv.get(i).getState() == 0){
				vi.setState("<p  class=\"layui-btn layui-btn-danger\">访问中</p>");
			}else if(lv.get(i).getState() == 1){
				vi.setState("<p  class=\"layui-btn\">已签离</p>");
			}else if(lv.get(i).getState() == 2){
				vi.setState("<p  class=\"layui-btn layui-btn-warm\">预约中</p>");
			}else if(lv.get(i).getState() == 3){
				vi.setState("<p  class=\"layui-btn layui-btn-normal\">邀请中</p>");
			}
			vi.setCheckInDevice(ds.selectDescription(lv.get(i).getCheckindeviceid(),lv.get(i).getBelongid()));
			if(lv.get(i).getCheckintime() == 0){
				vi.setCheckInTime(" ");
			}else{
				vi.setCheckInTime(df.format(new Date(lv.get(i).getCheckintime())));
			}
			vi.setCheckOutDevice(ds.selectDescription(lv.get(i).getCheckoutdeviceid(),lv.get(i).getBelongid()));
			if(lv.get(i).getCheckouttime() == 0){
				vi.setCheckOutTime(" ");
			}else{
				vi.setCheckOutTime(df.format(new Date(lv.get(i).getCheckouttime())));
			}
			lvi.add(vi);
		}
		
		Map<String, List<Visiting>> map = new HashMap<String, List<Visiting>>();
		map.put("data", lvi);
		int count = vis.selectCount(ur.getBelongid());
		JSONObject json = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", count);
		json.put("data", map.get("data"));
		return json.toString();
		
  }
	@RequestMapping(value="/getvisitInfoByEmployeeName",method = RequestMethod.GET)
	@ResponseBody
	public  String  getvisitInfoByEmployeeName(HttpServletRequest request){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		String employeeName= null;
		try{
		if(StringUtils.isNotEmpty(request.getParameter("employeeName"))){
			 employeeName = new String(request.getParameter("employeeName").getBytes("ISO-8859-1"),"utf-8");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		List<VisitInfo>  lv  = vis.visitReloadByEmployeeName(employeeName, befor, after,ur.getBelongid());
		List<Visiting> lvi = new ArrayList<Visiting>();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for(int i = 0 ; i < lv.size() ; i++){
			Visiting  vi = new Visiting();
			vi.setId(lv.get(i).getVisitid());
			vi.setVisitorName(lv.get(i).getVisitorname());
			vi.setEmpName(es.selectEmpName(lv.get(i).getEmployeeid(),ur.getBelongid()));
			vi.setReasonName(rs.selectReasonName(lv.get(i).getReasonid(),ur.getBelongid()));
			if(lv.get(i).getState() == 0){
				vi.setState("<p  class=\"layui-btn layui-btn-danger\">访问中</p>");
			}else if(lv.get(i).getState() == 1){
				vi.setState("<p  class=\"layui-btn\">已签离</p>");
			}else if(lv.get(i).getState() == 2){
				vi.setState("<p  class=\"layui-btn layui-btn-warm\">预约中</p>");
			}else if(lv.get(i).getState() == 3){
				vi.setState("<p  class=\"layui-btn layui-btn-normal\">邀请中</p>");
			}
			vi.setCheckInDevice(ds.selectDescription(lv.get(i).getCheckindeviceid(),lv.get(i).getBelongid()));
			if(lv.get(i).getCheckintime() == 0){
				vi.setCheckInTime(" ");
			}else{
				vi.setCheckInTime(df.format(new Date(lv.get(i).getCheckintime())));
			}
			vi.setCheckOutDevice(ds.selectDescription(lv.get(i).getCheckoutdeviceid(),lv.get(i).getBelongid()));
			if(lv.get(i).getCheckouttime() == 0){
				vi.setCheckOutTime(" ");
			}else{
				vi.setCheckOutTime(df.format(new Date(lv.get(i).getCheckouttime())));
			}
			lvi.add(vi);
		}
		
		Map<String, List<Visiting>> map = new HashMap<String, List<Visiting>>();
		map.put("data", lvi);
		int count = vis.selectCount(ur.getBelongid());
		JSONObject json = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", count);
		json.put("data", map.get("data"));
		return json.toString();
		
	}
	@RequestMapping(value="/getvisitInfoByCheckInDevice",method = RequestMethod.GET)
	@ResponseBody
	public  String  getvisitInfoByCheckInDevice(HttpServletRequest request){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		String checkInDevice= null;
		try{
			if(StringUtils.isNotEmpty(request.getParameter("checkInDevice"))){
				 checkInDevice = new String(request.getParameter("checkInDevice").getBytes("ISO-8859-1"),"utf-8");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		List<VisitInfo>  lv  = vis.visitReloadByCheckInDevice(checkInDevice, befor, after,ur.getBelongid());
		List<Visiting> lvi = new ArrayList<Visiting>();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for(int i = 0 ; i < lv.size() ; i++){
			Visiting  vi = new Visiting();
			vi.setId(lv.get(i).getVisitid());
			vi.setVisitorName(lv.get(i).getVisitorname());
			vi.setEmpName(es.selectEmpName(lv.get(i).getEmployeeid(),ur.getBelongid()));
			vi.setReasonName(rs.selectReasonName(lv.get(i).getReasonid(),ur.getBelongid()));
			if(lv.get(i).getState() == 0){
				vi.setState("<p  class=\"layui-btn layui-btn-danger\">访问中</p>");
			}else if(lv.get(i).getState() == 1){
				vi.setState("<p  class=\"layui-btn\">已签离</p>");
			}else if(lv.get(i).getState() == 2){
				vi.setState("<p  class=\"layui-btn layui-btn-warm\">预约中</p>");
			}else if(lv.get(i).getState() == 3){
				vi.setState("<p  class=\"layui-btn layui-btn-normal\">邀请中</p>");
			}
			vi.setCheckInDevice(ds.selectDescription(lv.get(i).getCheckindeviceid(),lv.get(i).getBelongid()));
			if(lv.get(i).getCheckintime() == 0){
				vi.setCheckInTime(" ");
			}else{
				vi.setCheckInTime(df.format(new Date(lv.get(i).getCheckintime())));
			}
			vi.setCheckOutDevice(ds.selectDescription(lv.get(i).getCheckoutdeviceid(),lv.get(i).getBelongid()));
			if(lv.get(i).getCheckouttime() == 0){
				vi.setCheckOutTime(" ");
			}else{
				vi.setCheckOutTime(df.format(new Date(lv.get(i).getCheckouttime())));
			}
			lvi.add(vi);
		}
		
		Map<String, List<Visiting>> map = new HashMap<String, List<Visiting>>();
		map.put("data", lvi);
		int count = vis.selectCount(ur.getBelongid());
		JSONObject json = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", count);
		json.put("data", map.get("data"));
		return json.toString();
		
	}
	@RequestMapping(value="/getvisitInfoByCheckOutDevice",method = RequestMethod.GET)
	@ResponseBody
	public  String  getvisitInfoByCheckOutDevice(HttpServletRequest request){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		String checkOutDevice= null;
		try{
			if(StringUtils.isNotEmpty(request.getParameter("checkOutDevice"))){
				 checkOutDevice = new String(request.getParameter("checkOutDevice").getBytes("ISO-8859-1"),"utf-8");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		List<VisitInfo>  lv  = vis.visitReloadByCheckOutDevice(checkOutDevice, befor, after,ur.getBelongid());
		List<Visiting> lvi = new ArrayList<Visiting>();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for(int i = 0 ; i < lv.size() ; i++){
			Visiting  vi = new Visiting();
			vi.setId(lv.get(i).getVisitid());
			vi.setVisitorName(lv.get(i).getVisitorname());
			vi.setEmpName(es.selectEmpName(lv.get(i).getEmployeeid(),ur.getBelongid()));
			vi.setReasonName(rs.selectReasonName(lv.get(i).getReasonid(),ur.getBelongid()));
			if(lv.get(i).getState() == 0){
				vi.setState("<p  class=\"layui-btn layui-btn-danger\">访问中</p>");
			}else if(lv.get(i).getState() == 1){
				vi.setState("<p  class=\"layui-btn\">已签离</p>");
			}else if(lv.get(i).getState() == 2){
				vi.setState("<p  class=\"layui-btn layui-btn-warm\">预约中</p>");
			}else if(lv.get(i).getState() == 3){
				vi.setState("<p  class=\"layui-btn layui-btn-normal\">邀请中</p>");
			}
			vi.setCheckInDevice(ds.selectDescription(lv.get(i).getCheckindeviceid(),lv.get(i).getBelongid()));
			if(lv.get(i).getCheckintime() == 0){
				vi.setCheckInTime(" ");
			}else{
				vi.setCheckInTime(df.format(new Date(lv.get(i).getCheckintime())));
			}
			vi.setCheckOutDevice(ds.selectDescription(lv.get(i).getCheckoutdeviceid(),lv.get(i).getBelongid()));
			if(lv.get(i).getCheckouttime() == 0){
				vi.setCheckOutTime(" ");
			}else{
				vi.setCheckOutTime(df.format(new Date(lv.get(i).getCheckouttime())));
			}
			lvi.add(vi);
		}
		
		Map<String, List<Visiting>> map = new HashMap<String, List<Visiting>>();
		map.put("data", lvi);
		int count = vis.selectCount(ur.getBelongid());
		JSONObject json = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", count);
		json.put("data", map.get("data"));
		return json.toString();
		
	}
	
	/*
	 * 查看详情
	 */
	@RequestMapping(value = "/visiting", method = RequestMethod.GET)
	public  String  visiting(HttpServletRequest  request , Model  model ){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String visitId  = request.getParameter("visitId");
		 VisitInfo  visitinfo =  vis.selectVisitInfo(visitId,ur.getBelongid());
		 if(visitinfo != null){
			 String path = request.getContextPath();
				String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
						+ "/"+"empimages";
				visitinfo.getEmployee().setPhoto_base(basePath +"/"+visitinfo.getEmployee().getPhoto());
			model.addAttribute("vi", visitinfo);
		 }else{
			 model.addAttribute("msg", "获取数据失败");
		 }
		return "visitorJsp/visiting";
	}
	/*
	 * 查看身份证照片
	 */
	@RequestMapping(value="/getIdPhoto",method = RequestMethod.GET)
	public void getIdPhoto(HttpServletRequest request , HttpServletResponse response){
		UserRole   ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String visitorId  = request.getParameter("visitorId");
		Vistor  visitor  = vs.selectVisitorById(visitorId ,ur.getBelongid());
		
		byte[]  idPhoto  = visitor.getIdphoto() ;
		InputStream  ins = null ;
		try{
			ins  = new ByteArrayInputStream(idPhoto);
			 OutputStream out = response.getOutputStream();
			byte[] data = new byte[(int)idPhoto.length];
			int i = 0;
			    while((i=ins.read(data))!=-1){
			       out.write(data);
			    }
			    out.close();
			    ins.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * 现场照片
	 */
	@RequestMapping(value="/getCamPhoto", method=RequestMethod.GET)
	public  void getCamereaPhoto(HttpServletRequest request , HttpServletResponse response){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String visitId  = request.getParameter("visitId");
		VisitInfo  visInfo =   vis.selectVisitInfo(visitId,ur.getBelongid());
		
		byte[]  CamPhoto  = visInfo.getCameraphoto() ;
		InputStream  ins = null ;
		try{
			ins  = new ByteArrayInputStream(CamPhoto);
			 OutputStream out = response.getOutputStream();
			byte[] data = new byte[(int)CamPhoto.length];
			 int i = 0;
			    while((i=ins.read(data))!=-1){
			       out.write(data);
			    }
			    out.close();
			    ins.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * 删除
	 */
	@RequestMapping(value="/deleteVisitInfo" ,method = RequestMethod.POST)
	public  void deleteVisitInfo(HttpServletRequest request){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String visitId  = request.getParameter("visitId");
		vis.deleteVisitInfo(visitId,ur.getBelongid());
		
	}
	@RequestMapping(value = "/visitorInfo" ,method = RequestMethod.POST)
	@ResponseBody
	public  String  visitorInfo(HttpServletRequest request){
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		
		return null ;
	}
	
	/*
	 * 访客管理
	 */
	
	@RequestMapping(value="/getvisitor" , method = RequestMethod.GET)
	public  String getvisitor(HttpServletRequest request){
		return "visitorJsp/getvisitor";
	}
	@RequestMapping(value="/getvisitors" ,method =RequestMethod.GET)
	@ResponseBody
	public  String get(HttpServletRequest request ,Model model){
		UserRole  ur =  (UserRole) request.getSession().getAttribute("UserRole");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		List<Vistor>  lv =  vs.selectVisitors(befor, after ,ur.getBelongid());
		for(int i = 0 ; i< lv.size() ; i++){
			lv.get(i).setId(lv.get(i).getVisitorid());
			Base64.Encoder  en  = Base64.getEncoder();
			 StringBuffer  sb  = new StringBuffer();
			 byte[]  idPhoto  =lv.get(i).getIdphoto();
			 if(idPhoto!=null){
    		 sb.append("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64," 
    		 + en.encodeToString(idPhoto) + "\"");
			lv.get(i).setIdphotoBase(sb.toString());
			 }
			
			byte[] camereaPhoto  =lv.get(i).getCameraphoto();
			if(camereaPhoto!=null){
			try{
	        ByteArrayInputStream intputStream = new ByteArrayInputStream(camereaPhoto);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Thumbnails.of(intputStream).scale(0.5f).outputQuality(0.8f).toOutputStream(baos);
             camereaPhoto = baos.toByteArray();
			}catch(Exception e){
			System.out.println("yas");
			}
			}
			
			 StringBuffer  sb1  = new StringBuffer();
			 sb1.append("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64," 
		    		 + en.encodeToString(camereaPhoto) + "\"");
			 lv.get(i).setCameraphotoBase(sb1.toString());
			 
			 lv.get(i).setCameraphoto(null);
			 lv.get(i).setIdphoto(null);
		}
		Map<String, List<Vistor>>  map = new HashMap<String ,List<Vistor>>();
		map.put("data", lv);
		JSONObject  json  = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", vs.selectCount(ur.getBelongid()));
		json.put("data", map.get("data"));
		
		return json.toString();
	}
	@RequestMapping(value="/setblackList" , method= RequestMethod.POST)
	@ResponseBody
	public  String  setblackList(HttpServletRequest request){
		UserRole  ur = (UserRole)request.getSession().getAttribute("UserRole");
		String visitorId  =  request.getParameter("visitorId");
		vs.updateVisiorAction(visitorId,-2,ur.getBelongid()); //加入黑名单
		vs.insertBlackList(visitorId,ur.getBelongid());
		return "getvisitor";
	}
	/*
	 * 访客搜索 ，数据重载
	 */
	@RequestMapping(value="/getvisitorByVisitorId" , method = RequestMethod.GET)
	@ResponseBody
	public  String getvisitorByVisitorId(HttpServletRequest request){
		UserRole   ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String visitorId  = request.getParameter("visitorId");
	Vistor  v  =	vs.selectVisitorById(visitorId,ur.getBelongid());
	List<Vistor>  lv  =  new ArrayList<Vistor>();
	if(v != null && v.getAction() != -2){
	v.setId(v.getVisitorid());
	Base64.Encoder  en  = Base64.getEncoder();
	 StringBuffer  sb  = new StringBuffer();
	 sb.append("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64," 
	 + en.encodeToString(v.getIdphoto()) + "\"");
	v.setIdphotoBase(sb.toString());
	byte[] camereaPhoto  =v.getCameraphoto();
	Base64.Encoder  en1  = Base64.getEncoder();
	 StringBuffer  sb1  = new StringBuffer();
	 sb1.append("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64," 
    		 + en1.encodeToString(camereaPhoto) + "\"");
	 v.setCameraphotoBase(sb1.toString());
	 lv.add(v);
	}
	 JSONObject  json  = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", vs.selectCount(ur.getBelongid()));
		json.put("data", lv);
		return json.toString();
	}
	@RequestMapping(value="/getvisitorByVisitorName" , method = RequestMethod.GET)
	@ResponseBody
	public  String  getvisitorByVisitorName(HttpServletRequest request){
		UserRole ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String visitorName = null;
		try {
			visitorName = new String(request.getParameter("visitorName").getBytes("ISO-8859-1") ,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		List<Vistor>  lv = vs.getvisitorByVisitorName(visitorName ,ur.getBelongid());
		for(int i = 0 ; i< lv.size() ; i++){
			if(lv.get(i).getAction() != -2){
			lv.get(i).setId(lv.get(i).getVisitorid());
			Base64.Encoder  en  = Base64.getEncoder();
			 StringBuffer  sb  = new StringBuffer();
    		 sb.append("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64," 
    		 + en.encodeToString(lv.get(i).getIdphoto()) + "\"");
			lv.get(i).setIdphotoBase(sb.toString());
			byte[] camereaPhoto  =lv.get(i).getCameraphoto();
			Base64.Encoder  en1  = Base64.getEncoder();
			 StringBuffer  sb1  = new StringBuffer();
			 sb1.append("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64," 
		    		 + en1.encodeToString(camereaPhoto) + "\"");
			 lv.get(i).setCameraphotoBase(sb1.toString());
			}else{
				lv.remove(i);
			}
		}
		Map<String, List<Vistor>>  map = new HashMap<String ,List<Vistor>>();
		map.put("data", lv);
		JSONObject  json  = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", vs.selectCount(ur.getBelongid()));
		json.put("data", map.get("data"));
		
		return json.toString();
		
	}
	/**
	 * 
	 * @Title: blacklist @Description: 黑名单 @param: @return @author:
	 * jianlinwei @return: String @thro ws
	 */
	@RequestMapping(value = "/blacklist", method = RequestMethod.GET)
	public String blacklist() {
		return "visitorJsp/blacklist";
	}
	@RequestMapping(value="/getblackList" , method = RequestMethod.GET)
	@ResponseBody
	public  String getblackList(HttpServletRequest request){
		UserRole   ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		  List<Vistor> lv  = vs.blackList(befor, after,ur.getBelongid());
		  for(int i = 0 ; i< lv.size() ; i++){
				lv.get(i).setId(lv.get(i).getVisitorid());
				Base64.Encoder  en  = Base64.getEncoder();
				 StringBuffer  sb  = new StringBuffer();
	    		 sb.append("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64," 
	    		 + en.encodeToString(lv.get(i).getIdphoto()) + "\"");
				lv.get(i).setIdphotoBase(sb.toString());
				/*byte[] camereaPhoto  =vis.getAcameraPhoto(lv.get(i).getVisitorid());*/
				byte[] camereaPhoto  =lv.get(i).getCameraphoto();
				Base64.Encoder  en1  = Base64.getEncoder();
				 StringBuffer  sb1  = new StringBuffer();
				 sb1.append("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64," 
			    		 + en1.encodeToString(camereaPhoto) + "\"");
				 lv.get(i).setCameraphotoBase(sb1.toString());
				 lv.get(i).setIdphoto(null);
				 lv.get(i).setCameraphoto(null);
			}
			Map<String, List<Vistor>>  map = new HashMap<String ,List<Vistor>>();
			map.put("data", lv);
			JSONObject  json  = new JSONObject();
			json.put("code", 0);
			json.put("msg", "");
			json.put("count", vs.selectCount(ur.getBelongid()));
			json.put("data", map.get("data"));
			
			return json.toString();
		
	}
	@RequestMapping(value="/setblack" , method= RequestMethod.POST)
	@ResponseBody
	public  String  setblack(HttpServletRequest request){
		UserRole  ur  =  (UserRole) request.getSession().getAttribute("UserRole");
		String visitorId  =  request.getParameter("visitorId");
		vs.updateVisiorAction(visitorId,0,ur.getBelongid());
		vs.deleteBlackList(visitorId,ur.getBelongid());
		return "getvisitor";
	}
	/*
	 * 黑名单搜索 ，数据重载
	 */
	@RequestMapping(value="/getblackById" , method = RequestMethod.GET)
	@ResponseBody
    public  String  getblackById(HttpServletRequest request){
		UserRole   ur  = (UserRole) request.getSession().getAttribute("UserRole");
    	String visitorId  = request.getParameter("visitorId");
    Vistor v =	vs.selectVisitorById(visitorId,ur.getBelongid());
    List<Vistor>  lv  =  new ArrayList<Vistor>();
    	if(v !=  null && v.getAction() == -2){ 
    		v.setId(v.getVisitorid());
    		Base64.Encoder  en  = Base64.getEncoder();
    		 StringBuffer  sb  = new StringBuffer();
    		 sb.append("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64," 
    		 + en.encodeToString(v.getIdphoto()) + "\"");
    		v.setIdphotoBase(sb.toString());
    		byte[] camereaPhoto  =vis.getAcameraPhoto(v.getVisitorid());
    		Base64.Encoder  en1  = Base64.getEncoder();
    		 StringBuffer  sb1  = new StringBuffer();
    		 sb1.append("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64," 
    	    		 + en1.encodeToString(camereaPhoto) + "\"");
    		 v.setCameraphotoBase(sb1.toString());
    		 lv.add(v);
    		 }
    	 JSONObject  json  = new JSONObject();
			json.put("code", 0);
			json.put("msg", "");
			json.put("count", vs.selectCount(ur.getBelongid()));
			json.put("data", lv);
			return json.toString();

    }
	
	@RequestMapping(value="/getblackByName" , method = RequestMethod.GET)
	@ResponseBody
	public  String  getblackByName(HttpServletRequest request){
		UserRole ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String visitorName = null;
		try {
			visitorName = new String(request.getParameter("visitorName").getBytes("ISO-8859-1") ,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		List<Vistor>  lv = vs.getvisitorByVisitorName(visitorName ,ur.getBelongid());
		for(int i = 0 ; i< lv.size() ; i++){
			if(lv.get(i).getAction() == -2){
			lv.get(i).setId(lv.get(i).getVisitorid());
			Base64.Encoder  en  = Base64.getEncoder();
			 StringBuffer  sb  = new StringBuffer();
    		 sb.append("<img  height=\"70px\" src=\" " + "data:image/png;base64," 
    		 + en.encodeToString(lv.get(i).getIdphoto()) + "\"");
			lv.get(i).setIdphotoBase(sb.toString());
			byte[] camereaPhoto  =vis.getAcameraPhoto(lv.get(i).getVisitorid());
			Base64.Encoder  en1  = Base64.getEncoder();
			 StringBuffer  sb1  = new StringBuffer();
			 sb1.append("<img  height=\"70px\" src=\" " + "data:image/png;base64," 
		    		 + en1.encodeToString(camereaPhoto) + "\"");
			 lv.get(i).setCameraphotoBase(sb1.toString());
			}else{
				lv.remove(i);
			}
		}
		Map<String, List<Vistor>>  map = new HashMap<String ,List<Vistor>>();
		map.put("data", lv);
		JSONObject  json  = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", vs.selectCount(ur.getBelongid()));
		json.put("data", map.get("data"));
		
		return json.toString();
		
	}
	/**
	 * 
	 * @Title: reason @Description: 访问事由 @param: @param
	 * request @param: @return @author: jianlinwei @return: String @throws
	 */

	@RequestMapping(value = "/reason", method = RequestMethod.GET)
	public String reason(HttpServletRequest request, Model model) {
		UserRole  ur =  (UserRole) request.getSession().getAttribute("UserRole");
		List<Reason> lr = rs.sleteReason(ur.getBelongid());
		model.addAttribute("lr", lr);
		return "visitorJsp/reason";
	}

	@RequestMapping(value = "/insertReason", method = RequestMethod.POST)
	public String insertreason(HttpServletRequest request, Model model) {
		UserRole ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String reasonName = request.getParameter("reasonName");
		Reason reason = rs.seleteReasonByName(reasonName,ur.getBelongid());
		if (reason == null) {
			rs.inserRason(reasonName,ur.getBelongid());
		} else {
			model.addAttribute("msg", "已存在");
		}
		return "visitorJsp/reason";
	}

	@RequestMapping(value = "/deleteReason", method = RequestMethod.POST)
	public String deletereason(HttpServletRequest request) {
		UserRole ur = (UserRole) request.getSession().getAttribute("UserRole");
		int reasonid = Integer.valueOf(request.getParameter("reasonId"));
		rs.deleteReason(reasonid,ur.getBelongid());
		return "visitorJsp/reason";
	}

	
	
}
