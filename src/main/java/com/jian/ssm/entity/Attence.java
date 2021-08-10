package com.jian.ssm.entity;

import java.util.Date;

/**
 * 
 * @ClassName:  Attence   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年6月28日 下午5:16:09   
 *
 */
public class Attence {
     private int  attenceId;
     private String employeeId;
     private String name ;
     private Date workDate ;
     private byte[]  camreaPhoto;
     
     private String photo;
     private String date;
     
     private String type;
     
     
     
   
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
	
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	public byte[] getCamreaPhoto() {
		return camreaPhoto;
	}
	public void setCamreaPhoto(byte[] camreaPhoto) {
		this.camreaPhoto = camreaPhoto;
	}
     
	
	
	
     
}
