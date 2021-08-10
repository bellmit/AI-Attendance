package com.jian.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jian.ssm.entity.Attence;


public interface AttenceDao {
      int  insertAttence(@Param("at")Attence  at);
	  
      List<Attence>  getAttenceInfo(@Param("befor")String befor ,@Param("after")String  after ,@Param("employeeId")String employeeId);
      
      Attence  getAttenceBydate(@Param("date")String date , @Param("employeeId")String employeeId);
      
      List<Attence>   getAllInfoById(@Param("employeeId")String employeeId , @Param("befor")int befor ,@Param("after")int after);
      
      int delAttence(@Param("employeeId")String employeeId , @Param("workDate")String workDate );
	
      
      int  getInfoCount(@Param("employeeid")String empid);
      
      int selectAttenceCountBydate(@Param("date")String date);
      
      int  deleteAllAttnece(@Param("employeeid")String employeeid);
      
      int selectAttenceCount();
      List<Attence>   getAllInfo(@Param("befor")int befor ,@Param("after")int after);
      
      int  deleteAttenceByAttenceID(@Param("ad")int  attenceId);
      
      int   getCountAll(@Param("employeeid")String employeeId , @Param("befor")String  startDate  ,@Param("after")String endDate);
}
