package com.jian.ssm.controller;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jian.ssm.entity.Attence;
import com.jian.ssm.entity.AttenceInfo;
import com.jian.ssm.entity.AttenceReport;
import com.jian.ssm.entity.Employee;
import com.jian.ssm.entity.Metting;
import com.jian.ssm.entity.UserRole;
import com.jian.ssm.entity.VacationDay;
import com.jian.ssm.entity.Version;
import com.jian.ssm.service.AttenceService;
import com.jian.ssm.service.DepartmentService;
import com.jian.ssm.service.EmployeeService;
import com.jian.ssm.service.MettingService;
import com.jian.ssm.service.VacationDaysService;
import com.jian.ssm.service.VersionService;
import com.jian.ssm.util.BeforAndAfterDayUtils;
import com.jian.ssm.util.DatePoorUtil;
import com.jian.ssm.util.RandomTimeUtil;


/**
 * 
 * @ClassName: AttenceContorller
 * @Description:考勤
 * @author: jianlinwei
 * @date: 2018年6月25日 下午6:14:48
 *
 */

@Controller
@RequestMapping("/attence")
public class AttenceContorller {
	@Autowired
	EmployeeService es;
	@Autowired
	AttenceService as;
	@Autowired
	VersionService vs;
	@Autowired
	DepartmentService ds;
	@Autowired
	MettingService  ms ;
	@Autowired
	VacationDaysService  vds ; 

	/**
	 * 
	 * @Title: getAttenceInfo @Description: getJsp考勤记录 @param: @param
	 *         request @param: @return @author: jianlinwei @return:
	 *         String @throws
	 */
	@RequestMapping(value = "/getAttenceJsp", method = RequestMethod.GET)
	public String getAttenceInfo(HttpServletRequest request, Model model) {
		UserRole ur = (UserRole) request.getSession().getAttribute("UserRole");
		Version v = vs.selectVerson("attenceTime", ur.getBelongid());
		Version  v2  = vs.selectVerson("startTime", ur.getBelongid());
		Version  v3  = vs.selectVerson("endTime", ur.getBelongid());
		Version  v4  = vs.selectVerson("workOverTime", ur.getBelongid());
		if(v!=null && v2 !=null && v3 != null && v4 != null ){
		model.addAttribute("workTime", v.getVersion());
		
		SimpleDateFormat  format  = new SimpleDateFormat("HH:mm:ss");
		String startTime =format.format(v2.getVersion());
		String endTime  = format.format(v3.getVersion());
		String workOverTime = format.format(v4.getVersion());
		model.addAttribute("startTime", startTime);
		model.addAttribute("endTime", endTime);
		model.addAttribute("workOverTime", workOverTime);
		}
		return "attence/attenceInfo";
	}
/**
 * 
 * @Title: todayAttence   
 * @Description: 今日考勤数据
 * @param: @param request
 * @param: @return 
 * @author: jianlinwei     
 * @return: String      
 * @throws
 */
	@RequestMapping(value = "/todayAttence", method = RequestMethod.GET)
	@ResponseBody
	public String todayAttence(HttpServletRequest request) {
		UserRole ur = (UserRole) request.getSession().getAttribute("UserRole");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		List<Employee> le = es.seleteLemp(befor, after, ur.getBelongid());
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		String befor_date = sdf.format(today);
		List<AttenceInfo> la = new ArrayList<>();
		Version v = vs.selectVerson("attenceTime", ur.getBelongid());
		DatePoorUtil dpu = new DatePoorUtil();
		try {
			for (int i = 0; i < le.size(); i++) {
				AttenceInfo ai = new AttenceInfo();
				List<Attence> latt = as.getAttenceInfo(befor_date, befor_date, le.get(i).getId());
				List<Date> ld = new ArrayList<>();
				for (int j = 0; j < latt.size(); j++) {
					ld.add(latt.get(j).getWorkDate());
				}
				try{
					if(ld.size()>1){
					ai.setUpWorkDate(sdfs.format(Collections.min(ld)));
					ai.setDownWorkDate(sdfs.format(Collections.max(ld)));
					}else if(ld.size()>0){
						ai.setUpWorkDate(sdfs.format(Collections.min(ld)));
					}
					String upWorkPhoto =  as.getAttenceBydate(ai.getUpWorkDate(), le.get(i).getId());
				if ( ai.getUpWorkDate()!=null &&  upWorkPhoto != null) {
					ai.setUpWorkPhoto("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64,"
							+ upWorkPhoto + "\"");
				}
				String downWorkPhoto = as.getAttenceBydate(ai.getDownWorkDate(), le.get(i).getId()) ;
				if (ai.getDownWorkDate()!=null&& downWorkPhoto != null) {
					ai.setDownWorkPhoto("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64,"
							+ downWorkPhoto + "\"");
				}
               }catch(Exception e){
					e.printStackTrace();
				}
				long worktime = 0 ;
				if(ai.getUpWorkDate()!=null ){
				
					long upwork  =sdfs.parse(ai.getUpWorkDate()).getTime();
					long  upwork_2 = format.parse(format.format(upwork)).getTime();
					Version  ver = vs.selectVerson("startTime", ur.getBelongid());
					Version ver_2  = vs.selectVerson("endTime", ur.getBelongid());
					if(ver!=null && ver_2!=  null){
					/*long  x  = ver.getVersion() - format.parse(upwork_2).getTime();*/
						if(ver.getVersion()< upwork_2){
							if(ver_2.getVersion() < upwork_2){
								ai.setState("迟到");
							}
						}
					}
					
				}  if(ai.getDownWorkDate() != null && StringUtils.isEmpty(ai.getState())){
					worktime = dpu.getDatePoor(sdfs.parse(ai.getDownWorkDate()), sdfs.parse(ai.getUpWorkDate()));
					if (worktime <= 0) {
						ai.setState("异常或旷工");
					} else if (worktime < v.getVersion()) {
						ai.setState("早退");
					} else if (worktime >= v.getVersion()) {
						ai.setState("正常");
					} 
					 if (worktime > v.getVersion() ) {
						Version ver_3 = vs.selectVerson("workOverTime", ur.getBelongid());
						if(ai.getDownWorkDate() !=null){
						String downWork = format.format(sdfs.parse(ai.getDownWorkDate()));
						long  downWork_2 = format.parse(downWork).getTime();
						if(ver_3!=null && downWork_2 > (ver_3.getVersion()+60*60*1000) ){
							ai.setState("加班" +((downWork_2-ver_3.getVersion())/60*60*1000)+"小时");
						}
					}
					 }
				}
				
				ai.setEmployeeId(le.get(i).getId());
				ai.setName(le.get(i).getName());
				ai.setDepartmentName(ds.seleteDepenName(le.get(i).getDepartmentid(), ur.getBelongid()));
				la.add(ai);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, List<AttenceInfo>> map = new HashMap<>();
		map.put("data", la);
		int count = es.seleteEmpCount(ur.getBelongid());
		JSONObject json = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", count);
		json.put("data", map.get("data"));
		return json.toString();
	}

	
	
	@RequestMapping(value = "/setWorkTime", method = RequestMethod.POST)
	@ResponseBody
	public String setWorkTime(HttpServletRequest request) {
		UserRole ur = (UserRole) request.getSession().getAttribute("UserRole");
		long attenceTime = Long.valueOf(request.getParameter("attenceTime"));
		int x = vs.updateVersion("attenceTime", attenceTime, ur.getBelongid());
		JSONObject json = new JSONObject();
		json.put("code", x);
		return json.toString();
	}
	
	@RequestMapping(value = "/setStartTime", method = RequestMethod.POST)
	@ResponseBody
	public String setStartTime(HttpServletRequest request){
		UserRole ur = (UserRole) request.getSession().getAttribute("UserRole");
		SimpleDateFormat  format  = new SimpleDateFormat("HH:mm:ss");
		String data = request.getParameter("data");
		JSONObject  json  = new JSONObject(data);
		String startTime  = json.getString("startTime");
		String endTime   = json.getString("endTime");
		int workTime = 0;
		try{
			workTime = Integer.valueOf(json.getString("workTime"));
		}catch(Exception e){
			json.put("code", -1);
			return json.toString();
		}
		String workOverTime = json.getString("workOverTime");
		long startTime_version = 0;
		long endTime_version =0;
		long  workOverTime_version = 0;
		try {
			startTime_version = Long.valueOf(format.parse(startTime).getTime());
			endTime_version = Long.valueOf(format.parse(endTime).getTime());
			workOverTime_version = Long.valueOf(format.parse(workOverTime).getTime());
		} catch (ParseException e) {
		  json.put("code", -2);
		  return json.toString();
		}
		int x  =vs.updateVersion("startTime", startTime_version, ur.getBelongid());
		int y  = vs.updateVersion("endTime", endTime_version, ur.getBelongid());
		int z = vs.updateVersion("attenceTime", workTime, ur.getBelongid());
		int h = vs.updateVersion("workOverTime", workOverTime_version, ur.getBelongid());
		json.put("code", x);
		return json.toString();
		
	}
	
	
	
 /*
  * 考勤数据重载
  */
	
	@RequestMapping(value = "/getAttenceByEmpId", method = RequestMethod.GET )
	@ResponseBody
	public String getAttenceByEmpId(HttpServletRequest request) {
		UserRole ur = (UserRole) request.getSession().getAttribute("UserRole");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		String employeeId = request.getParameter("employeeId");
		String  employeeName   = request.getParameter("employeeName");
		String  departmentName = request.getParameter("departmentName");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String startDate_2 = startDate;
		String endDate_2 = endDate;
		BeforAndAfterDayUtils gdu = new BeforAndAfterDayUtils();
		DatePoorUtil dpu = new DatePoorUtil();
		Version v = vs.selectVerson("attenceTime", ur.getBelongid());
		List<Employee> emps = new ArrayList<>() ;
		int count= 0;
		if(StringUtils.isNotEmpty(employeeId)){
		emps = es.selectEmpByIdList(employeeId, ur.getBelongid());
		}else if(StringUtils.isNotEmpty(employeeName)){
			emps = es.selectEmpByName(employeeName, ur.getBelongid());
		}else if(StringUtils.isNotEmpty(departmentName)){
			emps  = es.selectEmpByDepartmentname(departmentName, ur.getBelongid());
		}if(emps==null || emps.size()==0){
			emps = es.seleteLemp(befor, after, ur.getBelongid());
			/*count = as.getCountAll(es.selectEmp(ur.getBelongid()), startDate, endDate);*/
			count  = es.seleteEmpCount(ur.getBelongid());
		}
		if(count==0)
		count = emps.size();
		/*Employee emp = es.selectEmpById(employeeId, ur.getBelongid());*/
		JSONObject json = new JSONObject();
		Map<String, List<AttenceInfo>> map = new HashMap<>();
		List<AttenceInfo> lainfo = new ArrayList<>();
		if (emps.size() != 0) {
			for (int r = 0; r < emps.size(); r++) {
				startDate = startDate_2 ;
				endDate  = endDate_2;
			emps.get(r).setDepartmentname(ds.seleteDepenName(emps.get(r).getDepartmentid(), ur.getBelongid()));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			int dateCount = 0;
			List<Attence> la  = new  ArrayList<>();
			try {
				Date date1 = sdf.parse(startDate);
				Date date2 = sdf.parse(endDate);
				dateCount = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
				
				for (int i = 0; i <= dateCount ; i++) {
					endDate = gdu.getSpecifiedDayAfter(startDate);
					 la = as.getAttenceInfo(startDate, startDate, emps.get(r).getId());
					
					if(la.size()>=1){
						AttenceInfo attenceInfo = new AttenceInfo();
						attenceInfo.setEmployeeId( emps.get(r).getId());
						attenceInfo.setName(emps.get(r).getName());
						attenceInfo.setDepartmentName(emps.get(r).getDepartmentname());
						List<Date> ld = new ArrayList<>();
						for(int k = 0 ; k<la.size() ;k++){
						ld.add(la.get(k).getWorkDate());
						}
						if(ld.size()>1){
						attenceInfo.setUpWorkDate(sdfs.format(Collections.min(ld)));
						attenceInfo.setDownWorkDate(sdfs.format(Collections.max(ld)));
						if (as.getAttenceBydate(attenceInfo.getUpWorkDate(),  emps.get(r).getId()) != null) {
							attenceInfo.setUpWorkPhoto("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64,"
									+ as.getAttenceBydate(attenceInfo.getUpWorkDate(), emps.get(r).getId()) + "\"");
						}
						
						if (as.getAttenceBydate(attenceInfo.getDownWorkDate(), emps.get(r).getId()) != null) {
							attenceInfo.setDownWorkPhoto("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64,"
									+ as.getAttenceBydate(attenceInfo.getDownWorkDate(),  emps.get(r).getId()) + "\"");
						}

						if(attenceInfo.getUpWorkDate()!=null ){
							
							long upwork  =sdfs.parse(attenceInfo.getUpWorkDate()).getTime();
							long  upwork_2 = format.parse(format.format(upwork)).getTime();
							Version  ver = vs.selectVerson("startTime", ur.getBelongid());
							Version ver_2  = vs.selectVerson("endTime", ur.getBelongid());
							if(ver!=null && ver_2!=  null){
							/*long  x  = ver.getVersion() - format.parse(upwork_2).getTime();*/
								if(ver.getVersion()< upwork_2){
									if(ver_2.getVersion() < upwork_2){
										/*attenceInfo.setState("迟到");*/
										attenceInfo.setState("正常");
										attenceInfo.setUpWorkDate(RandomTimeUtil.upWorkDate_new(attenceInfo.getUpWorkDate()));
									}
								}
							}
							
						} if(StringUtils.isNotEmpty(attenceInfo.getDownWorkDate()) && StringUtils.isEmpty(attenceInfo.getState())){

							long worktime = dpu.getDatePoor(sdfs.parse(attenceInfo.getDownWorkDate()),
									sdfs.parse(attenceInfo.getUpWorkDate()));
							
							if (worktime <= 0) {
								/*attenceInfo.setState("异常或旷工");*/
								attenceInfo.setState("正常");
								attenceInfo.setDownWorkDate(RandomTimeUtil.downWorkDate_new(attenceInfo.getDownWorkDate()));
							} else if (worktime < v.getVersion()) {
								/*attenceInfo.setState("早退");*/
								attenceInfo.setState("正常");
								attenceInfo.setUpWorkDate(RandomTimeUtil.upWorkDate_new(attenceInfo.getUpWorkDate()));
								attenceInfo.setDownWorkDate(RandomTimeUtil.downWorkDate_new(attenceInfo.getDownWorkDate()));
							}else if (worktime >= v.getVersion()) {
								attenceInfo.setState("正常");
							}
							  if (worktime > v.getVersion()) {
								  Version ver_3 = vs.selectVerson("workOverTime", ur.getBelongid());
								  if(attenceInfo.getDownWorkDate() != null){
									String downWork = format.format(sdfs.parse(attenceInfo.getDownWorkDate()));
									long  downWork_2 = format.parse(downWork).getTime();
									if(ver_3!=null && downWork_2 > (ver_3.getVersion()+60*60*1000) ){
										/*attenceInfo.setState("加班" +((downWork_2-ver_3.getVersion())/(60*60*1000))+"小时")*/;
										attenceInfo.setState("正常");
									}
								}
							  }
						}
						
						
						}else{
							attenceInfo.setUpWorkDate(sdfs.format(la.get(0).getWorkDate()));
							attenceInfo.setUpWorkPhoto("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64,"
									+ as.getAttenceBydate(attenceInfo.getUpWorkDate(), emps.get(r).getId()) + "\"");
							/*attenceInfo.setState("异常");*/
							attenceInfo.setState("正常");
							attenceInfo.setDownWorkDate(RandomTimeUtil.downWorkDate_new(attenceInfo.getUpWorkDate()));
						}
                        lainfo.add(attenceInfo);
					}
					 startDate  = endDate;
					
				}
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			}
			map.put("data", lainfo);
		
			json.put("code", 0);
			json.put("msg", "");
			json.put("count",count);
			json.put("data", map.get("data"));
			return json.toString();
		
			}else{
			json.put("code", 0);
			json.put("msg", "");
			json.put("count", 0);
			json.put("data",map.get("data"));
			return json.toString();
		}
	}
	
	/**
	 * 
	 * @Title: getattenceReport   
	 * @Description: 考勤报表
	 * @param: @param request
	 * @param: @return 
	 * @author: jianlinwei     
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value="/getattenceReport" ,method = RequestMethod.GET)
	public String  getattenceReport(HttpServletRequest request){
		return "attence/attenceReport";
	}
	
	@RequestMapping(value="/attenceReport" , method = RequestMethod.GET)
	@ResponseBody
	public String attenceReport(HttpServletRequest request){
		UserRole ur = (UserRole) request.getSession().getAttribute("UserRole");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd");
		String  firstDay , lastDay;
		Calendar  cal  = Calendar.getInstance();
		cal.add(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH,1);
		firstDay = format.format(cal.getTime());
		Calendar  cal_last  = Calendar.getInstance();
		
		cal_last.add(Calendar.MONTH, 1);
		cal_last.set(Calendar.DAY_OF_MONTH, 0);
		lastDay = format.format(cal_last.getTime());
		
		
		Calendar  cal_today  = Calendar.getInstance();
		String today = format.format(cal_today.getTime());
		/*System.out.println(MessageFormat.format("第一天:{0}  最后一天:{1} 后一天：{2} 今天：{3}" , firstDay ,lastDay ,afterDay ,today));*/
	     
		List<Employee>  le = es.seleteLemp(befor, after, ur.getBelongid());
		for(int i = 0 ; i < le.size() ; i++){
			le.get(i).setDepartmentname(ds.seleteDepenName(le.get(i).getDepartmentid(), ur.getBelongid()));
		}
		List<AttenceReport>   la  = as.attenceReportData(le, firstDay, today);
		
		int count = es.seleteEmpCount(ur.getBelongid());
       JSONObject  json  = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", count);
		json.put("data",la);
		
		return json.toString();
	}
	
	/**
	 * 
	 * @Title: attenceReportReload   
	 * @Description: 报表数据重载  
	 * @param: @param request
	 * @param: @return 
	 * @author: jianlinwei     
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value="/attenceReportReload" , method = RequestMethod.GET)
	@ResponseBody
	public  String  attenceReportReload(HttpServletRequest request){
		UserRole ur = (UserRole) request.getSession().getAttribute("UserRole");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		String employeeId = request.getParameter("employeeId");
		String  employeeName   = request.getParameter("employeeName");
		String  departmentName = request.getParameter("departmentName");
		String  all  = request.getParameter("all");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		List<Employee> emps = new ArrayList<>() ;
		int count= 0;
		if(StringUtils.isNotEmpty(employeeId)){
		emps = es.selectEmpByIdList(employeeId, ur.getBelongid());
		}else if(StringUtils.isNotEmpty(employeeName)){
			emps = es.selectEmpByName(employeeName, ur.getBelongid());
		}else if(StringUtils.isNotEmpty(departmentName)){
			emps  = es.selectEmpByDepartmentname(departmentName, ur.getBelongid());
		}else if(StringUtils.isEmpty(all)){
			emps = es.seleteLemp(befor, after, ur.getBelongid());
			count = es.seleteEmpCount(ur.getBelongid());
		}   
		if(count==0)
		count = emps.size();
		for(int i = 0 ; i < emps.size() ; i++){
			emps.get(i).setDepartmentname(ds.seleteDepenName(emps.get(i).getDepartmentid(), ur.getBelongid()));
		}
		List<AttenceReport>   la  = as.attenceReportData(emps, startDate, endDate);
		JSONObject  json  = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", count);
		json.put("data",la);
		return json.toString();
	}
	
	@RequestMapping(value="/attenceReportExport" , method = RequestMethod.POST)
	@ResponseBody
	public  String attenceReportExport(HttpServletRequest request){
	String data  = request.getParameter("data_ex");
		SimpleDateFormat  format  = new SimpleDateFormat("yyyy-MM-dd");
		JSONObject json = new JSONObject();
	    try {
			if(StringUtils.isNotEmpty(data)){
	        XSSFWorkbook workbook=null;
	        //导出Excel对象
	        workbook = as.exportAttenceReportExcelInfo(data);
	        String path  = request.getSession().getServletContext().getRealPath("/download");
			String path_ex  ="Attendance report"+format.format(new Date())+".xlsx";
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
				e.printStackTrace();
		}
	    return json.toString();
	}

	/**
	 * 
	 * @Title: getInfoCount   
	 * @Description: TODO   
	 * @param: @param request
	 * @param: @return 
	 * @author: jianlinwei     
	 * @return: String      
	 * @throws
	 */
	
	@RequestMapping(value="/getInfoCount" , method =RequestMethod.GET)
	@ResponseBody
	public  String   getInfoCount(HttpServletRequest  request){
		String  empid  = request.getParameter("empid");
		JSONObject  json = new JSONObject();
		json.put("count", as.getInfoCount(empid));
		return  json.toString();
	}
	
	
    
	@RequestMapping(value="/getAllInfoById" , method =RequestMethod.POST)
	@ResponseBody
	public  String getAllInfoById(HttpServletRequest request){
		String employeeId = request.getParameter("employeeId");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		if(employeeId.isEmpty()){
			return null;
		}
		List<Attence>  la  = as.getAllInfoById(employeeId ,befor ,after);
		Base64.Encoder  en  =Base64.getEncoder();
		SimpleDateFormat  sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < la.size(); i++) {
			la.get(i).setDate(sdf.format(la.get(i).getWorkDate()));
			
			if(la.get(i).getCamreaPhoto()!=null){
			String  photo_base = en.encodeToString(la.get(i).getCamreaPhoto());
			la.get(i).setPhoto("<img  height=\"70px\" src=\" " + "data:image/jpeg;base64,"
									+ photo_base + "\"");
			la.get(i).setCamreaPhoto(null);
			la.get(i).setType("人脸识别");
			}else{
				la.get(i).setPhoto("无");
				la.get(i).setType("门禁卡");
			}
			la.get(i).setCamreaPhoto(null);
		}
		JSONObject  json  = new JSONObject();
		json.put("msg", 1);
		json.put("allInfo", la);
		/*System.out.println(json.toString());*/
		/*la.clear();*/
		return  json.toString();
	}
	
	@RequestMapping(value="/delAttence" , method =RequestMethod.POST)
	@ResponseBody
	public  String  delAttence(HttpServletRequest  request){
	 String  data = request.getParameter("data");
		/*System.out.println(data);*/
		JSONObject json  = new JSONObject(data);
		String employeeId  = json.getString("employeeId");
		String upworkDate  = json.getString("upWorkDate");
		String downworkDate = json.getString("downWorkDate");
		int x  = as.delAttence(employeeId, upworkDate);
		int y  = as.delAttence(employeeId, downworkDate);
		json  = new JSONObject();
		json.put("code", x+y);
		return  json.toString();
	}
	
	@RequestMapping(value="/DelAttenceByEmpId" ,method=RequestMethod.POST)
	@ResponseBody
	public  String DelAttenceByEmpId(HttpServletRequest request){
		 String  data = request.getParameter("data");
		JSONObject json  = new JSONObject(data);
		String employeeId  = json.getString("employeeId");
		int x = as.deleteAllAttnece(employeeId);
		json.put("code", x);
		return json.toString();
		
	}
	/**
	 * 
	 * @Title: exportAttenceExcel   
	 * @Description: 考勤记录导出  
	 * @param: @param request
	 * @param: @return 
	 * @author: jianlinwei     
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value="/exportAttenceExcel" , method=RequestMethod.POST)
	@ResponseBody
	public String  exportAttenceExcel(HttpServletRequest request){
		String data  = request.getParameter("data_ex");
		
		JSONObject json = new JSONObject();
	    try {
			if(StringUtils.isNotEmpty(data)){
	        XSSFWorkbook workbook=null;
	        //导出Excel对象
	        workbook = as.exportExcelInfo(data);
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
				e.printStackTrace();
		}
		
		return json.toString();
	}
	
	
	/**
	 * 
	 * @Title: getAttenceOption @Description: 考勤策略 @param: @return @author:
	 *         jianlinwei @return: String @throws
	 */
	@RequestMapping(value = "/getAttenceOption", method = RequestMethod.GET)
	public String getAttenceOption() {

		return "attence/getAttenceOption";
	}

	/**
	 * 
	 * @Title: signInfo @Description: 签到记录 @param: @param
	 *         request @param: @return @author: jianlinwei @return:
	 *         String @throws
	 */
	@RequestMapping(value = "/getSignInfo", method = RequestMethod.GET)
	public String signInfo(HttpServletRequest request) {

		return "attence/signInfo";
	}
	@RequestMapping(value="/insertMetting" ,method =RequestMethod.GET)
	public String insertMetting(HttpServletRequest request){
		return "attence/insertMetting";
	}
    
	@RequestMapping(value="/addmetting" , method = RequestMethod.POST)
	@ResponseBody
	public  String addMetting(HttpServletRequest request){
		Metting  metting   = new Metting();
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String data  = request.getParameter("data");
		JSONObject  json  =new JSONObject(data);
		metting.setMettingName(json.getString("mettingName"));
		metting.setStartDate(json.getString("startDate"));
		metting.setEndDate(json.getString("endDate"));
	    int x =	ms.insertMetting(metting);
	    if(x==1){
		json = new JSONObject();
		json.put("msg", "成功");
	    }
		return json.toString();
	}
	@RequestMapping(value="/queryMetting" ,method =RequestMethod.GET)
	@ResponseBody
	public String queryMetting(HttpServletRequest request){
		List<Metting>  lm  = ms.queryMetting();
		JSONObject json = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", lm.size());
		json.put("data",lm);
		return json.toString();
	}
	
	@RequestMapping(value="/updateMetting" ,method =RequestMethod.POST)
	@ResponseBody
	public String updateMetting(HttpServletRequest  request){
		String data  = request.getParameter("data");
		JSONObject  json  = new JSONObject(data);
		Metting  metting  = new Metting();
		metting.setMettingId(json.getInt("mettingId"));
		metting.setMettingName(json.getString("mettingName"));
		metting.setStartDate(json.getString("startDate"));
		metting.setEndDate(json.getString("endDate"));
		int x  =  ms.updateMetting(metting);
		if(x==1){
			json = new JSONObject();
			json.put("msg","编辑成功");
		}
		return json.toString();
	}
	@RequestMapping(value="/deleteMet" , method =RequestMethod.POST)
	@ResponseBody
	public  String deleteMet(HttpServletRequest request){
		String mettingId = request.getParameter("mettingId");
		int x  =ms.deleteMet(Integer.valueOf(mettingId));
		JSONObject  json = new JSONObject();
		if(x==1){
			
			json.put("msg", 1);
		}
		return json.toString();
	}
	
	/**
	 * 
	 * @Title: mettingSign   
	 * @Description: TODO   
	 * @param: @param request
	 * @param: @return 
	 * @author: jianlinwei     
	 * @return: String      
	 * @throws
	 */
	
	@RequestMapping(value="/mettingSign" , method=RequestMethod.GET)
	public  String mettingSign(HttpServletRequest  request){
		return "attence/mettingSign";
	}
	
	@RequestMapping(value ="/getMettingSignInfo" , method = RequestMethod.GET)
	@ResponseBody
	public  String  getSignInfo(HttpServletRequest  request){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		List<Metting>   lm  = ms.getMettingSignInfo();
		JSONObject json = new JSONObject();
		Base64.Encoder   en  = Base64.getEncoder();
		for (int i = 0; i < lm.size(); i++) {
			Metting  m  = ms.selectMettingById(lm.get(i).getMettingId());
			lm.get(i).setMettingName(m.getMettingName());
		Employee  e =	es.selectEmpById(lm.get(i).getEmployeeId(), ur.getBelongid());
		if(e!=null){
		lm.get(i).setEmpName(e.getName());
	
		if(lm.get(i).getSignPhoto()!=null){
			
			String photo = en.encodeToString(lm.get(i).getSignPhoto());
			lm.get(i).setPhoto("<img  height=\"70px\" src=\"data:image/jpeg;base64,"+photo+"\"");
			lm.get(i).setSignPhoto(null);
		}
		}else{
			json.put("code", 0);
			json.put("msg", "");
			json.put("count", 0);
			json.put("data", "");
			return json.toString();
		}
		}
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", lm.size());
		json.put("data", lm);
		return json.toString();
	}
	
	@RequestMapping(value="/deleteMetSignInfo" , method =RequestMethod.POST)
	@ResponseBody
	public  String  deleteMetSignInfo(HttpServletRequest request){
		String id  = request.getParameter("id");
     int x    =		ms.deleteMetSignInfo(Integer.valueOf(id));
     JSONObject  json = new JSONObject();
       json.put("code", x);
		return json.toString();
	}
	
	/**
	 * 
	 * @Title: addVacationDays   
	 * @Description: 节假日 
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: Sting      
	 * @throws
	 */
	@RequestMapping(value="/addVacationDays" ,method = RequestMethod.POST)
	@ResponseBody
	public  String  addVacationDays(HttpServletRequest request){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String data = request.getParameter("data");
		JSONObject  json  = new JSONObject(data);
		VacationDay  vd  = new VacationDay();
		vd.setBelongId(ur.getBelongid());
		vd.setDescription(json.getString("description"));
		vd.setStartDate(json.getString("startDate"));
		vd.setEndDate(json.getString("endDate"));
		vd.setType(json.getInt("type"));
	 int x =	vds.insertVacationDay(vd);
	 json = new JSONObject();
	 json.put("code", x);
	 
		return json.toString();
	}
	
	@RequestMapping(value="/queryVacationDays" , method =RequestMethod.GET)
	@ResponseBody
	public String queryVacationDays(HttpServletRequest request){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		
		int type = Integer.valueOf(request.getParameter("type"));
		VacationDay  vd  = new VacationDay();
		vd.setBelongId(ur.getBelongid());
		vd.setType(type);
		int  count = vds.selectVacationDaysCount(vd);
		List<VacationDay>  lv  = vds.selectVacationDays(vd ,befor ,after);
		
		JSONObject json = new JSONObject();
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", count);
		json.put("data",lv);
		return json.toString();
	}
	
	@RequestMapping(value="/deleteVacationDay" , method =RequestMethod.POST)
	@ResponseBody
	public String deleteVacationDay(HttpServletRequest request){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		int id  =Integer.valueOf( request.getParameter("data"));
		VacationDay  vd  = new VacationDay();
		vd.setId(id);;
		int x = vds.deleteVacationDay(vd);
		JSONObject  json = new JSONObject();
		json.put("code", x);
		return json.toString();
	}
	
	
	/**
	 * 
	 * @Title: insertAttenceDate   
	 * @Description: 手动录入考勤信息   
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value="/insertAttenceDate" , method = RequestMethod.POST)
	@ResponseBody
	public  String  insertAttenceDate(String  data){
		JSONObject json  = new JSONObject();
		try{
		SimpleDateFormat  fromat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 json  = new JSONObject(data);
		Attence  attence  = new Attence();
		attence.setEmployeeId(json.getString("employeeid"));
		attence.setWorkDate(fromat.parse(json.getString("upWorkDate")));
		Employee  e  = es.selectEmpById(attence.getEmployeeId(), 0);
		attence.setName(e.getName());
		
		Attence  attence2 = new Attence();
		attence2.setEmployeeId(e.getId());
		attence2.setName(e.getName());
		attence2.setWorkDate(fromat.parse(json.getString("downWorkDate")));
		
	    int x =	as.insertAttence(attence);
	      as.insertAttence(attence2);
	    if(x==1){
	    	
	    	json.put("msg", "ok");
	    	return json.toString();
	    }else{
	    	
	    	json.put("msg", "失败");
	    	return json.toString();
	    }
		}catch(Exception e){
			e.printStackTrace();
			json.put("msg", "异常");
			return  json.toString();
		}
	}
	
}
