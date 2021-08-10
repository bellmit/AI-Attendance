package com.jian.ssm.entity;

public class AttenceInfo {
	 private int  attenceId;
     private String employeeId;
     private String name ;
     private int attenceIdTwo;
     private String upWorkDate;
     private String downWorkDate;
     private String upWorkPhoto;
     private String downWorkPhoto;
     private String state;
     private String departmentName ;
     private byte[] upWorkPhoto_byte;
     private byte[] downWorkPhoto_byte;
     
     
     
	public byte[] getUpWorkPhoto_byte() {
		return upWorkPhoto_byte;
	}
	public void setUpWorkPhoto_byte(byte[] upWorkPhoto_byte) {
		this.upWorkPhoto_byte = upWorkPhoto_byte;
	}
	public byte[] getDownWorkPhoto_byte() {
		return downWorkPhoto_byte;
	}
	public void setDownWorkPhoto_byte(byte[] downWorkPhoto_byte) {
		this.downWorkPhoto_byte = downWorkPhoto_byte;
	}
	public int getAttenceIdTwo() {
		return attenceIdTwo;
	}
	public void setAttenceIdTwo(int attenceIdTwo) {
		this.attenceIdTwo = attenceIdTwo;
	}
	public int getAttenceId() {
		return attenceId;
	}
	public void setAttenceId(int attenceId) {
		this.attenceId = attenceId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUpWorkDate() {
		return upWorkDate;
	}
	public void setUpWorkDate(String upWorkDate) {
		this.upWorkDate = upWorkDate;
	}
	public String getDownWorkDate() {
		return downWorkDate;
	}
	public void setDownWorkDate(String downWorkDate) {
		this.downWorkDate = downWorkDate;
	}
	public String getUpWorkPhoto() {
		return upWorkPhoto;
	}
	public void setUpWorkPhoto(String upWorkPhoto) {
		this.upWorkPhoto = upWorkPhoto;
	}
	public String getDownWorkPhoto() {
		return downWorkPhoto;
	}
	public void setDownWorkPhoto(String downWorkPhoto) {
		this.downWorkPhoto = downWorkPhoto;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
     
     
}
