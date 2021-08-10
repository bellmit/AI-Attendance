package com.jian.ssm.entity;

public class Metting {
	private  int id;
      private  int mettingId ;
      private  String mettingName;
      private  String startDate ;
      private  String endDate;
      private  int action;  //0 未任何操作  -1 删除
      
      
      private String employeeId ;
      private String empName;
      private byte[]  signPhoto;
      private String  photo;
      private String  signDate;
      
      
      
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getSignDate() {
		return signDate;
	}
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public byte[] getSignPhoto() {
		return signPhoto;
	}
	public void setSignPhoto(byte[] signPhoto) {
		this.signPhoto = signPhoto;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public int getMettingId() {
		return mettingId;
	}
	public void setMettingId(int mettingId) {
		this.mettingId = mettingId;
	}
	public String getMettingName() {
		return mettingName;
	}
	public void setMettingName(String mettingName) {
		this.mettingName = mettingName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
      
}
