package com.jian.ssm.service;

import java.util.List;


import com.jian.ssm.entity.PeopleIdentity;
import com.jian.ssm.entity.UserRole;

public interface PeopleIdentityService {
	int insertPeopleIdentity(PeopleIdentity pi);

	List<PeopleIdentity> selectPeopleIdentityByBelongId( int befor, int after,
			UserRole ur);

	int deletePeopleIdentityByUUID(String uuid);
	
	List<PeopleIdentity>   selectPeopleIdentityByName(int befor, int after,UserRole ur,String name);
	
	List<PeopleIdentity>   selectPeopleIdentityByIdcard(int befor, int after,UserRole ur,String idcard);
}
