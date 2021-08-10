package com.jian.ssm.entity;

public class VisiInfoTable {
	private  String  id;
	private  String   visitorName;
	private  String 	empName;
	private  String 	reasonName;
	private  String 	state;
	private  String 	checkInDevice;
	private  String 	checkInTime;
	private  String 	checkOutDevice ;
	private  String 	checkOutTime ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getReasonName() {
		return reasonName;
	}
	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCheckInDevice() {
		return checkInDevice;
	}
	public void setCheckInDevice(String checkInDevice) {
		this.checkInDevice = checkInDevice;
	}
	public String getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	public String getCheckOutDevice() {
		return checkOutDevice;
	}
	public void setCheckOutDevice(String checkOutDevice) {
		this.checkOutDevice = checkOutDevice;
	}
	public String getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	
}
