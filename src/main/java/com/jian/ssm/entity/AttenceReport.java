package com.jian.ssm.entity;

/**
 * 
 * @ClassName: AttenceReport
 * @Description:考勤报表
 * @author: jianlinwei
 * @date: 2018年8月7日 上午10:12:09
 *
 */
public class AttenceReport {
	private String id;
	private String name;
	private String departmentName;
	private int attendanceDays;// 应出勤天数
	private int fullServiceDays;// 全勤天数
	private int lateMinutes;// 迟到分钟
	private int lateTime;// 迟到次数
	private int earlyRetreatMinutes;// 早退分钟
	private int earlyRetreatTime;// 早退次数
	private int overtimeHours;// 加班小时
	private int absenteeismDays;// 旷工天数
	private String orthers;
	

	public String getOrthers() {
		return orthers;
	}

	public void setOrthers(String orthers) {
		this.orthers = orthers;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getAttendanceDays() {
		return attendanceDays;
	}

	public void setAttendanceDays(int attendanceDays) {
		this.attendanceDays = attendanceDays;
	}

	public int getFullServiceDays() {
		return fullServiceDays;
	}

	public void setFullServiceDays(int fullServiceDays) {
		this.fullServiceDays = fullServiceDays;
	}

	public int getLateMinutes() {
		return lateMinutes;
	}

	public void setLateMinutes(int lateMinutes) {
		this.lateMinutes = lateMinutes;
	}

	public int getLateTime() {
		return lateTime;
	}

	public void setLateTime(int lateTime) {
		this.lateTime = lateTime;
	}

	public int getEarlyRetreatMinutes() {
		return earlyRetreatMinutes;
	}

	public void setEarlyRetreatMinutes(int earlyRetreatMinutes) {
		this.earlyRetreatMinutes = earlyRetreatMinutes;
	}

	public int getEarlyRetreatTime() {
		return earlyRetreatTime;
	}

	public void setEarlyRetreatTime(int earlyRetreatTime) {
		this.earlyRetreatTime = earlyRetreatTime;
	}

	public int getOvertimeHours() {
		return overtimeHours;
	}

	public void setOvertimeHours(int overtimeHours) {
		this.overtimeHours = overtimeHours;
	}

	public int getAbsenteeismDays() {
		return absenteeismDays;
	}

	public void setAbsenteeismDays(int absenteeismDays) {
		this.absenteeismDays = absenteeismDays;
	}

}
