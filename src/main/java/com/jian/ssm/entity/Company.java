package com.jian.ssm.entity;
/**
 * 
 * @ClassName:  Company   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年5月30日 下午3:23:07   
 *
 */
public class Company {
     private  int belongid ;
     private  String description ;
     private  int  parentid;
     private  int level;
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	public int getBelongid() {
		return belongid;
	}
	public void setBelongid(int belongid) {
		this.belongid = belongid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
     
     
}
