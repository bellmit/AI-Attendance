package com.jian.ssm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BeforAndAfterDayUtils {
	/** 
	* 获得指定日期的前一天 
	* @param specifiedDay 
	* @return 
	* @throws Exception 
	*/ 
	public  String getSpecifiedDayBefore(String specifiedDay){ 
	//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	Calendar c = Calendar.getInstance(); 
	Date date=null; 
	try { 
	date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay); 
	} catch (ParseException e) { 
	e.printStackTrace(); 
	} 
	c.setTime(date); 
	int day=c.get(Calendar.DATE); 
	c.set(Calendar.DATE,day-1); 

	String dayBefore=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
	return dayBefore; 
	} 
	/** 
	* 获得指定日期的后一天 
	* @param specifiedDay 
	* @return 
	*/ 
	public  String getSpecifiedDayAfter(String specifiedDay){ 
	Calendar c = Calendar.getInstance(); 
	Date date=null; 
	try { 
	date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay); 
	} catch (ParseException e) { 
	e.printStackTrace(); 
	} 
	c.setTime(date); 
	int day=c.get(Calendar.DATE); 
	c.set(Calendar.DATE,day+1); 

	String dayAfter=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
	return dayAfter; 
	}
}
