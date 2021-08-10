package com.jian.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jian.ssm.entity.VacationDay;

public interface VacationDaysDao {
	 int  insertVacationDay(@Param("vd")VacationDay  vd);
     int  deleteVacationDay(@Param("vd")VacationDay  vd);
     List<VacationDay>  selectVacationDays(@Param("vd")VacationDay  vd ,@Param("befor")int befor ,@Param("after")int after);
     int  selectVacationDaysCount(@Param("vd")VacationDay  vd);
     List<VacationDay>  selectVacationDaysByType(@Param("type") int type ,@Param("belongId")int belongId);
}
