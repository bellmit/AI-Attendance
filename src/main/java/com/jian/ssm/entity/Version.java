package com.jian.ssm.entity;
/**
 * 
 * @ClassName:  Version   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年4月28日 下午2:53:48   
 *
 */
public class Version {
    private  String name ;
    private  long version;
    private  int belongid;
	public int getBelongid() {
		return belongid;
	}
	public void setBelongid(int belongid) {
		this.belongid = belongid;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
    
}
