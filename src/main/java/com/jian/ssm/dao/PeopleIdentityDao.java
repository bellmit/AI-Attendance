package com.jian.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jian.ssm.entity.PeopleIdentity;

public interface PeopleIdentityDao {
	int insertPeopleIdentity(@Param("pi") PeopleIdentity pi);

	List<PeopleIdentity> selectPeopleIdentityByBelongId(@Param("befor") int befor, @Param("after") int after,
			@Param("belongId") int belongId);

	int deletePeopleIdentityByUUID(@Param("uuid") String uuid);
	
	List<PeopleIdentity>   selectPeopleIdentityByName(@Param("befor")int befor, @Param("after") int after,@Param("belongId")int belongId,@Param("name")String name);
	
	List<PeopleIdentity>   selectPeopleIdentityByIdcard(@Param("befor")int befor, @Param("after") int after,@Param("belongId")int belongId,@Param("idcard")String idcard);
}
