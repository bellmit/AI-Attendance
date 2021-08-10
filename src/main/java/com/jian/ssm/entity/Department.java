package com.jian.ssm.entity;
/**
 * 
 * @ClassName:  Department   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年4月28日 下午2:33:50   
 *
 */
public class Department {
       private   int  departmentId ;
       private   String departmentName;
       private   int   belongid;
	public int getBelongid() {
		return belongid;
	}
	public void setBelongid(int belongid) {
		this.belongid = belongid;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
       
}
