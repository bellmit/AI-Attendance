package com.jian.ssm.entity;
/**
 * 
 * @ClassName:  Reason   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年5月15日 下午12:04:33   
 *
 */
public class Reason {
      private int reasonid;
      private String reasonname;
      private int belongid;
	public int getBelongid() {
		return belongid;
	}
	public void setBelongid(int belongid) {
		this.belongid = belongid;
	}
	public int getReasonid() {
		return reasonid;
	}
	public void setReasonid(int reasonid) {
		this.reasonid = reasonid;
	}
	public String getReasonname() {
		return reasonname;
	}
	public void setReasonname(String reasonname) {
		this.reasonname = reasonname;
	}
      
      
	
}
