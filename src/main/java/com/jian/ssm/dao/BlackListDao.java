package com.jian.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jian.ssm.entity.BlackList;


public interface BlackListDao {
	  List<BlackList>  selectBlackList(@Param("befor")int befor ,@Param("after")int after ,@Param("belongId")int belongId);
	  int  getBlackListPeo(@Param("visitorId")String visitorId,@Param("belongId")int belongId);
}
