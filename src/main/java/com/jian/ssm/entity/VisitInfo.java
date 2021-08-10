package com.jian.ssm.entity;
/**
 * 
 * @ClassName:  VisitInfo   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年5月17日 下午2:48:40   
 *
 */
public class VisitInfo {
      private  String  visitid ;
      private  int  employeeid;
      private  String  visitorid;
      private  String  visitorname;
      private  int  reasonid;
      private  byte[]  cameraphoto;
      private  String  checkindeviceid;
      private  long     checkintime;
      private  String checkoutdeviceid;
      private  long  checkouttime ;
      private  int  state ;
      private  String comment ;
      private  int  action ;
      private  long version;
      private  Employee  employee;
      private  Vistor  visitor;
      private  Department   department;
      private  int belongid;
	  private String resonName;
	  private String employeeName;
	
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getResonName() {
		return resonName;
	}
	public void setResonName(String resonName) {
		this.resonName = resonName;
	}
	public int getBelongid() {
		return belongid;
	}
	public void setBelongid(int belongid) {
		this.belongid = belongid;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Vistor getVisitor() {
		return visitor;
	}
	public void setVisitor(Vistor visitor) {
		this.visitor = visitor;
	}
	public String getVisitid() {
		return visitid;
	}
	public void setVisitid(String visitid) {
		this.visitid = visitid;
	}
	
	
	
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getVisitorname() {
		return visitorname;
	}
	public void setVisitorname(String visitorname) {
		this.visitorname = visitorname;
	}
	
	public String getVisitorid() {
		return visitorid;
	}
	public void setVisitorid(String visitorid) {
		this.visitorid = visitorid;
	}
	public int getReasonid() {
		return reasonid;
	}
	public void setReasonid(int reasonid) {
		this.reasonid = reasonid;
	}
	public byte[] getCameraphoto() {
		return cameraphoto;
	}
	public void setCameraphoto(byte[] cameraphoto) {
		this.cameraphoto = cameraphoto;
	}
	
	
	public String getCheckindeviceid() {
		return checkindeviceid;
	}
	public void setCheckindeviceid(String checkindeviceid) {
		this.checkindeviceid = checkindeviceid;
	}
	public long getCheckintime() {
		return checkintime;
	}
	public void setCheckintime(long checkintime) {
		this.checkintime = checkintime;
	}
	public String getCheckoutdeviceid() {
		return checkoutdeviceid;
	}
	public void setCheckoutdeviceid(String checkoutdeviceid) {
		this.checkoutdeviceid = checkoutdeviceid;
	}
	public long getCheckouttime() {
		return checkouttime;
	}
	public void setCheckouttime(long checkouttime) {
		this.checkouttime = checkouttime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
      
}
