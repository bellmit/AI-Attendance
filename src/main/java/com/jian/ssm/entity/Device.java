package com.jian.ssm.entity;
/**
 * 
 * @ClassName:  Device   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年4月27日 上午11:11:56   
 *
 */
public class Device {
     private String  deviceid  ;
     private String  ip ;
     private String  parameter;
     private  int  type ;
     private  String address;
     private  String description;
     private  int port;
     private  int belongid;
     private  String company;
	private  int keyStatus; //1 已授权 -1 未授权
	private  String key;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getKeyStatus() {
		return keyStatus;
	}
	public void setKeyStatus(int keyStatus) {
		this.keyStatus = keyStatus;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getBelongid() {
		return belongid;
	}
	public void setBelongid(int belongid) {
		this.belongid = belongid;
	}
	
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
     
     
	
}
