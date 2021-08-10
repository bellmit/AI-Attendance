package com.jian.ssm.entity;
/**
 * 
 * @ClassName:  Employee   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年5月7日 上午10:37:33   
 *
 */
public class Employee {
    private  String id ; //工号
    private  int  departmentid;
    private  String name ;
    private  String phone ;
    private  String email ;
    private  byte[] photo ;
    private  String photo_base;
    private  byte[] photofeature;
    private  String  fingerfeature;
    private  String  sex;
    private  String departmentname;
    private  int belongid;
    private int zeId;
    private long version ;
    private String ICcard;
    
    
    
	
	public String getICcard() {
		return ICcard;
	}
	public void setICcard(String iCcard) {
		ICcard = iCcard;
	}
	public String getPhoto_base() {
		return photo_base;
	}
	public void setPhoto_base(String photo_base) {
		this.photo_base = photo_base;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public int getZeId() {
		return zeId;
	}
	public void setZeId(int zeId) {
		this.zeId = zeId;
	}
	public int getBelongid() {
		return belongid;
	}
	public void setBelongid(int belongid) {
		this.belongid = belongid;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public byte[] getPhotofeature() {
		return photofeature;
	}
	public void setPhotofeature(byte[] photofeature) {
		this.photofeature = photofeature;
	}
	public String getFingerfeature() {
		return fingerfeature;
	}
	public void setFingerfeature(String fingerfeature) {
		this.fingerfeature = fingerfeature;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
    
    
	
	
}
