package com.jian.ssm.entity;
/**
 * 
 * @ClassName:  MettingEmp   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年7月10日 上午9:52:29   
 *
 */
public class MettingEmp {
       private int  mettingId;
       private String employeeId ;
       private byte[]   signPhoto;
       private String  signDate;
	public int getMettingId() {
		return mettingId;
	}
	public void setMettingId(int mettingId) {
		this.mettingId = mettingId;
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
	public String getSignDate() {
		return signDate;
	}
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
       
       
       
}
