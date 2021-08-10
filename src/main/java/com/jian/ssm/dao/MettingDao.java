package com.jian.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jian.ssm.entity.Metting;
import com.jian.ssm.entity.MettingEmp;

public interface MettingDao {
	int  insertMetting(@Param("m")Metting  metting);
	
	List<Metting>   queryMetting();
	
	
	int  updateMetting(@Param("m")Metting m);
	
	int deleteMet(int mettingId);
	
	 List<Metting>    getMettingSignInfo();
	 
	 Metting  selectMettingById(@Param("mettingId")int  mettingId);
	 
	 int  deleteMetSignInfo(@Param("id")int id);
	 
	 List<Metting>  selectMetting();
	 
	 int  insertMettingEmp(@Param("me")MettingEmp  me);
}
