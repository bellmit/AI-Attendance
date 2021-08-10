package com.jian.ssm.entity;
/**
 * 
 * @ClassName:  CheckOut   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年6月11日 上午10:44:26   
 *
 */
public class CheckOut {
           
  private	String visitid;
  private String checkOutDeviceId;
  private long checkOutTime;
  private int belongId;
public String getVisitid() {
	return visitid;
}
public void setVisitid(String visitid) {
	this.visitid = visitid;
}
public String getCheckOutDeviceId() {
	return checkOutDeviceId;
}
public void setCheckOutDeviceId(String checkOutDeviceId) {
	this.checkOutDeviceId = checkOutDeviceId;
}
public long getCheckOutTime() {
	return checkOutTime;
}
public void setCheckOutTime(long checkOutTime) {
	this.checkOutTime = checkOutTime;
}
public int getBelongId() {
	return belongId;
}
public void setBelongId(int belongId) {
	this.belongId = belongId;
}
  
  
}
