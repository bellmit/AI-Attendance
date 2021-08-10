package com.jian.ssm.service.ipml;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jian.ssm.dao.AttenceDao;
import com.jian.ssm.dao.VacationDaysDao;
import com.jian.ssm.dao.VersionDao;
import com.jian.ssm.entity.Attence;
import com.jian.ssm.entity.AttenceInfo;
import com.jian.ssm.entity.AttenceReport;
import com.jian.ssm.entity.Employee;
import com.jian.ssm.entity.ExcelBean;
import com.jian.ssm.entity.UserRole;
import com.jian.ssm.entity.VacationDay;
import com.jian.ssm.entity.Version;
import com.jian.ssm.service.AttenceService;
import com.jian.ssm.util.BeforAndAfterDayUtils;
import com.jian.ssm.util.DatePoorUtil;
import com.jian.ssm.util.ExcelUtil;

@Service
public class AttenceImpl implements AttenceService {
	@Resource
	AttenceDao ad;
	@Resource
	VersionDao  vd ;
	@Autowired
	HttpServletRequest  request;
	@Resource
	VacationDaysDao  vdd;

	@Override
	public int insertAttence(Attence at) {

		return ad.insertAttence(at);
	}

	@Override
	public List<Attence> getAttenceInfo(String befor, String after, String employeeId) {

		return ad.getAttenceInfo(befor, after, employeeId);
	}

	@Override
	public String getAttenceBydate(String date, String empId) {
		Attence attence = ad.getAttenceBydate(date, empId);
		Base64.Encoder en = Base64.getEncoder();
		String camreaPhoto_base = null;
		if (attence != null){
			if (attence.getCamreaPhoto() == null) {
				camreaPhoto_base = null;
			} else {
				camreaPhoto_base = en.encodeToString(attence.getCamreaPhoto());
			}
		}
		return camreaPhoto_base;
	}

	@Override
	public List<Attence> getAllInfoById(String employeeId, int befor, int after) {

		return ad.getAllInfoById(employeeId, befor, after);
	}

	@Override
	public int delAttence(String employeeId, String upworkDate) {

		return ad.delAttence(employeeId, upworkDate);
	}

	@Override
	public XSSFWorkbook exportExcelInfo(String data) {
		
		JSONArray ja = new JSONArray(data);

		List<AttenceInfo> la = new ArrayList<>();

		for (int i = 0; i < ja.length(); i++) {
			AttenceInfo a = new AttenceInfo();
			a.setEmployeeId(ja.getJSONObject(i).getString("employeeId"));
			a.setName(ja.getJSONObject(i).getString("name"));
		
			try {
				a.setDepartmentName(ja.getJSONObject(i).getString("departmentName"));
				a.setUpWorkDate(ja.getJSONObject(i).getString("upWorkDate"));
				a.setDownWorkDate(ja.getJSONObject(i).getString("downWorkDate"));
			    a.setState(ja.getJSONObject(i).getString("state"));
			    a.setUpWorkPhoto_byte(ad.getAttenceBydate(a.getUpWorkDate(), a.getEmployeeId()).getCamreaPhoto());
			    a.setDownWorkPhoto_byte(ad.getAttenceBydate(a.getDownWorkDate(), a.getEmployeeId()).getCamreaPhoto());
			} catch (Exception e) {
				/*a.setUpWorkDate("无记录");
				a.setDownWorkDate("无记录");*/
			}
			la.add(a);
		}
		List<ExcelBean> le = new ArrayList<>();
		Map<Integer, List<ExcelBean>> map = new LinkedHashMap<>();
		XSSFWorkbook xssfWorkbook = null;
		le.add(new ExcelBean("工号", "employeeId", 0));
		le.add(new ExcelBean("姓名", "name", 0));
		le.add(new ExcelBean("部门", "departmentName", 0));
		le.add(new ExcelBean("上班时间", "upWorkDate", 0));
		le.add(new ExcelBean("上班照片","upWorkPhoto_byte" ,0));
		le.add(new ExcelBean("下班时间", "downWorkDate", 0));
		le.add(new ExcelBean("下班照片","downWorkPhoto_byte",0));
		le.add(new ExcelBean("状态", "state", 0));
		map.put(0, le);
		String sheetName = "考勤记录";
		// 调用ExcelUtil的方法
		try {
			xssfWorkbook = ExcelUtil.createExcelFile(AttenceInfo.class, la, map, sheetName);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return xssfWorkbook;
	}

	@Override
	public int getInfoCount(String empid) {

		return ad.getInfoCount(empid);
	}

	@Override
	public int selectAttenceCountBydate(String dat) {

		return ad.selectAttenceCountBydate(dat);
	}

	@Override
	public int deleteAllAttnece(String employeeid) {
		
		return ad.deleteAllAttnece(employeeid);
	}

	@Override
	public int selectAttenceCount() {
		
		return ad.selectAttenceCount();
	}

	@Override
	public List<Attence> getAllInfo(int befor, int after) {
	
		return ad.getAllInfo(befor, after);
	}

	@Override
	public int deleteAttenceByAttenceID(int attenceId) {
		
		return ad.deleteAttenceByAttenceID(attenceId);
	}

	
	
	/**
	 * 考勤报表
	 */
	
	@Override
	public List<AttenceReport> attenceReportData(List<Employee> le, String firstDay, String lastDay) {
		List<AttenceReport>  lar = new ArrayList<>();
		for(Employee e  : le){
			List<Attence>   la =  ad.getAttenceInfo(firstDay, lastDay, e.getId());
			AttenceReport  ar  = new AttenceReport();
			ar.setId(e.getId());
			ar.setName(e.getName());
			ar.setDepartmentName(e.getDepartmentname());
			ar.setAttendanceDays(attendanceDays(firstDay,lastDay));
			AttenceReport ar_2 = fullServiceDays(la, firstDay ,lastDay);
			ar.setFullServiceDays(ar_2.getFullServiceDays());
			ar.setLateMinutes(ar_2.getLateMinutes());
			ar.setLateTime(ar_2.getLateTime());
			ar.setEarlyRetreatMinutes(ar_2.getEarlyRetreatMinutes());
			ar.setEarlyRetreatTime(ar_2.getEarlyRetreatTime());
			ar.setOvertimeHours(ar_2.getOvertimeHours());
			ar.setAbsenteeismDays(ar_2.getAbsenteeismDays());
			lar.add(ar);
		}
		
		
		
		return lar;
	}
	
	/*应出勤天数= 相差天数-周六周日-节假日+必须上班日
	 */
	List<String>  vacationdays  ;//节假日
	List<String>  vacationdays2 ;//必须上班日
	public  int attendanceDays(String firstDay ,String lastDay ){
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		int day  = 0;
		try{
			BeforAndAfterDayUtils  bad  = new BeforAndAfterDayUtils();
		SimpleDateFormat  format  = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat  format2  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		vacationdays  = new ArrayList<>();
		vacationdays2 = new ArrayList<>();
		List<VacationDay>  lv = vdd.selectVacationDaysByType(1, ur.getBelongid());
		List<VacationDay>  lv2 = vdd.selectVacationDaysByType(0, ur.getBelongid());
		for(VacationDay v : lv){
			String day1 = format.format(format2.parse(v.getStartDate()));
			String day2 = format.format(format2.parse(v.getEndDate()));
			int days = (int) ((format.parse(day2).getTime() - format.parse(day1).getTime()) / (1000*3600*24))+1;
			for(int x = 0 ; x < days ; x++){
				vacationdays.add(day1);
				day1  = bad.getSpecifiedDayAfter(day1);
			}
		}
		for(VacationDay v2 : lv2){
			String day1 = format.format(format2.parse(v2.getStartDate()));
			String day2 = format.format(format2.parse(v2.getEndDate()));
			int days = (int) ((format.parse(day2).getTime() - format.parse(day1).getTime()) / (1000*3600*24))+1;
			for(int x = 0 ; x < days ; x++){
				vacationdays2.add(day1);
				day1  = bad.getSpecifiedDayAfter(day1);
			}
		}
		int j = 0 ;//周六周日节假日
		int w = 0;//必须上班日
		int days = (int) ((format.parse(lastDay).getTime() - format.parse(firstDay).getTime()) / (1000*3600*24))+1;
		Calendar  cal  = Calendar.getInstance();
		for(int i = 0 ; i < days ;i++){
			cal.setTime(format.parse(firstDay));
			if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY 
					|| vacationdays.contains(firstDay)){
				j++;
			}
			if( vacationdays2.size() > 0 &&  vacationdays2.contains(firstDay)){
				w++;
			}
			firstDay = bad.getSpecifiedDayAfter(firstDay);
		}
		
		
		day  = days - j +w;
		/*System.out.println(day);*/
		}catch(Exception e){
			e.printStackTrace();
		}

		return  day;
	}

	/*
	 * 全勤天数
	 */
	public AttenceReport fullServiceDays(List<Attence>   la ,String firstDay ,String lastDay){
		int i = 0;//全勤天数
		int j = 0 ; //迟到分钟
		int h = 0 ;//迟到次数
		int z = 0 ;//早退分钟
		int c = 0 ; //早退次数
		int b = 0 ;//加班小时
		int d = 0 ;//旷工次数=正常上班日旷工+必须上班日旷工
		try{
		UserRole  ur  = (UserRole) request.getSession().getAttribute("UserRole");
		SimpleDateFormat  format  = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat   format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat  format2 = new SimpleDateFormat("yyyy-MM-dd");
		Version  v1 = vd.selectVerson("startTime", ur.getBelongid());
		Version  v2  = vd.selectVerson("endTime", ur.getBelongid());
		Version  v3 = vd.selectVerson("attenceTime", ur.getBelongid());
		Version  v4 = vd.selectVerson("workOverTime", ur.getBelongid());
		DatePoorUtil dpu = new DatePoorUtil();
		BeforAndAfterDayUtils  beforAndAfterDayUtils = new BeforAndAfterDayUtils();
		
		for(Attence a : la){
			String  upWorkDate ,downWorkDate;
			List<Attence>   la_1 = ad.getAttenceInfo(firstDay, firstDay, a.getEmployeeId());
			List<Date>  ld  = new ArrayList<>();
			for(Attence a1 : la_1){
				ld.add(a1.getWorkDate());
			}
			if(ld.size()>1){
				upWorkDate = format1.format(Collections.min(ld));
				downWorkDate = format1.format(Collections.max(ld));
				long worktime = dpu.getDatePoor(format1.parse(downWorkDate),
						format1.parse(upWorkDate));
				long attencetime = format.parse(format.format(format1.parse(upWorkDate))).getTime();
				
				long attencetime_1 = format.parse(format.format(format1.parse(downWorkDate))).getTime();
				/*if( attencetime >= v1.getVersion() && attencetime <= v2.getVersion() && worktime >=v3.getVersion()){
					i++;
				}*/
				i++;
				if(attencetime > v2.getVersion()){
					/*j += (attencetime - v2.getVersion())/(60*1000);*/
					j= 0;
				/*	h ++ ;*/
					h = 0;
				}
				
				if(worktime<v3.getVersion()){
					/*c++;*/
					/*z += (v3.getVersion()-worktime)*60;*/
					z = 0;
					c = 0;
				}
				
				if(worktime > v3.getVersion() && attencetime_1 >= v4.getVersion()){
					b+= (worktime-v3.getVersion());
				}
				
			} if(ld.size() == 1){
				long attencetime_2 = format.parse(format.format(ld.get(0))).getTime();
				long x = format.parse("12:00:00").getTime();
				if(attencetime_2 > x){
					h++;
				}
			} if(ld.size()==0){
				Calendar  cal  = Calendar.getInstance();
				cal.setTime(format2.parse(firstDay));
				if(format2.parse(firstDay).getTime() <= format2.parse(lastDay).getTime() &&
						cal.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY && 
						cal.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY  ){
				/*d++;*/
					d = 0;
				}
				if(vacationdays2.size() >0  && vacationdays2.contains(firstDay)){
					d++;
					d = 0;
				}
			}
			firstDay = beforAndAfterDayUtils.getSpecifiedDayAfter(firstDay);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		AttenceReport  ar  = new AttenceReport();
		ar.setFullServiceDays(i);
		ar.setLateMinutes(j);
		ar.setLateTime(h);
		ar.setEarlyRetreatMinutes(z);
		ar.setEarlyRetreatTime(c);
		ar.setOvertimeHours(b);
		ar.setAbsenteeismDays(d);
		return ar;
	}

	@Override
	public XSSFWorkbook exportAttenceReportExcelInfo(String data) {
		JSONArray ja = new JSONArray(data);
		List<AttenceReport> la = new ArrayList<>();

		for (int i = 0; i < ja.length(); i++) {
			AttenceReport a = new AttenceReport();
			a.setId(ja.getJSONObject(i).getString("id"));
			a.setName(ja.getJSONObject(i).getString("name"));
			try{
			a.setDepartmentName(ja.getJSONObject(i).getString("departmentName"));
			}catch(Exception e){
				a.setDepartmentName("");
			}
			a.setAttendanceDays(ja.getJSONObject(i).getInt("attendanceDays"));
			a.setFullServiceDays(ja.getJSONObject(i).getInt("fullServiceDays"));
			a.setLateMinutes(ja.getJSONObject(i).getInt("lateMinutes"));
			a.setLateTime(ja.getJSONObject(i).getInt("lateTime"));
			a.setEarlyRetreatMinutes(ja.getJSONObject(i).getInt("earlyRetreatMinutes"));
			a.setEarlyRetreatTime(ja.getJSONObject(i).getInt("earlyRetreatTime"));
			a.setOvertimeHours(ja.getJSONObject(i).getInt("overtimeHours"));
			a.setAbsenteeismDays(ja.getJSONObject(i).getInt("absenteeismDays"));
			a.setOrthers("");
			la.add(a);
		}
		List<ExcelBean> le = new ArrayList<>();
		Map<Integer, List<ExcelBean>> map = new LinkedHashMap<>();
		XSSFWorkbook xssfWorkbook = null;
		le.add(new ExcelBean("工号", "id", 0));
		le.add(new ExcelBean("姓名", "name", 0));
		le.add(new ExcelBean("部门", "departmentName", 0));
		le.add(new ExcelBean("应出勤 天数", "attendanceDays", 0));
		le.add(new ExcelBean("全勤天数", "fullServiceDays", 0));
		le.add(new ExcelBean("迟到分钟", "lateMinutes", 0));
		le.add(new ExcelBean("迟到次数", "lateTime", 0));
		le.add(new ExcelBean("早退分钟", "earlyRetreatMinutes", 0));
		le.add(new ExcelBean("早退次数", "earlyRetreatTime", 0));
		le.add(new ExcelBean("加班小时", "overtimeHours", 0));
		le.add(new ExcelBean("旷工天数", "absenteeismDays", 0));
		le.add(new ExcelBean("未刷次数", "orthers", 0));
		le.add(new ExcelBean("签到次数", "orthers", 0));
		le.add(new ExcelBean("出差 (天)", "orthers", 0));
		le.add(new ExcelBean("病假 (天)", "orthers", 0));
		le.add(new ExcelBean("事假 (天)", "orthers", 0));
		le.add(new ExcelBean("探亲假 (天)", "orthers", 0));
		le.add(new ExcelBean("产假（检） (天)", "orthers", 0));
		le.add(new ExcelBean("年假 (天)", "orthers", 0));
		le.add(new ExcelBean("外出会议 (天)", "orthers", 0));
		le.add(new ExcelBean("借调 (天)", "orthers", 0));
		le.add(new ExcelBean("培训学习 (天)", "orthers", 0));
		le.add(new ExcelBean("中心活动 (天)", "orthers", 0));
		le.add(new ExcelBean("体育锻炼 (天)", "orthers", 0));
		le.add(new ExcelBean("婚假 (天)", "orthers", 0));
		le.add(new ExcelBean("京内 (天)", "orthers", 0));
		le.add(new ExcelBean("丧假 (天)", "orthers", 0));
		le.add(new ExcelBean("工伤假 (天)", "orthers", 0));
		le.add(new ExcelBean("上课 (天)", "orthers", 0));
		
		map.put(0, le);
		String sheetName = "考勤报表";
		// 调用ExcelUtil的方法
		try {
			xssfWorkbook = ExcelUtil.createExcelFile(AttenceReport.class, la, map, sheetName);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return xssfWorkbook;
	}
/*
 * (non-Javadoc)
 * @see com.jian.ssm.service.AttenceService#getCountAll(int, java.lang.String, java.lang.String)
 *一个人指定日期内的数量
 */
	@Override
	public int getCountAll(List<Employee>  le, String startDate, String endDate) {
		int count = 0;
		for(Employee e : le){
			count += ad.getCountAll(e.getId(), startDate, endDate);
		}
		return  count;
	}
	

}


