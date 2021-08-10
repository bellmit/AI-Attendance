package com.jian.ssm.entity;
/**
 * 
 * @ClassName:  VacationDay   
 * @Description:TODO   
 * @author: JianLinWei
 * @date:   2018年8月8日 上午9:46:11   
 *
 */
public class VacationDay {
      private  int  id  ;
      private  String description ;
      private  String  startDate;
      private  String   endDate;
      private  int   belongId;
      private  int type;
      
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public int getBelongId() {
		return belongId;
	}
	public void setBelongId(int belongId) {
		this.belongId = belongId;
	}
      
      
}
