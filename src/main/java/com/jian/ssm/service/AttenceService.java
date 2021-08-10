package com.jian.ssm.service;

import java.util.List;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jian.ssm.entity.Attence;
import com.jian.ssm.entity.AttenceReport;
import com.jian.ssm.entity.Employee;

public interface AttenceService {
	int insertAttence(Attence at);
	
	List<Attence>  getAttenceInfo(String befor ,String  after ,String employeeId);
	
	String  getAttenceBydate(String date ,String  empId );
	
	List<Attence>   getAllInfoById(String employeeId , int befor , int after);
	
	int delAttence(String employeeId , String workDate );
	
	XSSFWorkbook  exportExcelInfo(String data);
	
	int  getInfoCount(String empid);
	
	int selectAttenceCountBydate(String dat);
	
	int  deleteAllAttnece(String employeeid);
	
	 int selectAttenceCount();
	 List<Attence>   getAllInfo(int befor ,int after);
	 int  deleteAttenceByAttenceID(int  attenceId);
	 //考勤报表
	 List<AttenceReport>   attenceReportData( List<Employee> le ,String  firstDay  ,String lastDay);
	 
	 XSSFWorkbook  exportAttenceReportExcelInfo(String data);
	 
	 //一个人指定日期内数量
	 int   getCountAll(List<Employee>  le , String  startDate  ,String endDate);
}
