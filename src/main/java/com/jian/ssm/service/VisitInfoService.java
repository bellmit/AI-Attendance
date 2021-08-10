package com.jian.ssm.service;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jian.ssm.entity.CheckOut;
import com.jian.ssm.entity.VisitInfo;

public interface VisitInfoService {
	int  insertVisitInfo(VisitInfo  vi);
	List<VisitInfo>  selectViditInfos(long version , String  deviceid,int belongId);
	List<VisitInfo>  selectVisit(int befor , int after ,int belongId);
	int   selectCount(int belongId);
	VisitInfo  selectVisitInfo(String visitId ,int belongId);
	/*
	 * 数据重载
	 */
	List<VisitInfo>  visitReloadByVisitorName(String visitorName ,int befor ,int after,int belongId);
	List<VisitInfo>  visitReloadByEmployeeName(String employeeName ,int befor ,int after,int belongId);
	List<VisitInfo>  visitReloadByCheckInDevice(String checkInDevice ,int befor,int after,int belongId);
	List<VisitInfo>  visitReloadByCheckOutDevice(String checkOutDevice , int befor,int after,int belongId);
	
	
	int deleteVisitInfo(String visitId,int belongId);
	
	byte[]  getAcameraPhoto(String visitorId);
	
	
	int  CheckOutUpdate(CheckOut co);
	
	XSSFWorkbook exportExcelInfo(String data);
}
