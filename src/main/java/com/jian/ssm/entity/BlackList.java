package com.jian.ssm.entity;
/**
 * 
 * @ClassName:  BlackList   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年5月23日 下午5:43:54   
 *
 */
public class BlackList {
     private  int  id ;
     private String visitorid ;
     private byte[]  photofeature;
     private int belongid;
     
	public int getBelongid() {
		return belongid;
	}
	public void setBelongid(int belongid) {
		this.belongid = belongid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVisitorid() {
		return visitorid;
	}
	public void setVisitorid(String visitorid) {
		this.visitorid = visitorid;
	}
	public byte[] getPhotofeature() {
		return photofeature;
	}
	public void setPhotofeature(byte[] photofeature) {
		this.photofeature = photofeature;
	}
     
}
