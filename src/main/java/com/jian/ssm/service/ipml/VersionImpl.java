package com.jian.ssm.service.ipml;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jian.ssm.dao.VersionDao;
import com.jian.ssm.entity.Version;
import com.jian.ssm.service.VersionService;

@Service
public class VersionImpl  implements VersionService {
  @Resource
  VersionDao  vd ;

@Override
public int insertVersion(String name, long version ,int belongId) {

	return vd.insertVersion(name, version,belongId);
}

@Override
public int updateVersion(String name, long version ,int belongId) {

	return vd.updateVersion(name, version,belongId);
}

@Override
public Version selectVerson(String name,int belongId) {
	
	return vd.selectVerson(name,belongId);
}

@Override
public List<Version> selectVersions(int belongId) {
	
	return vd.selectVersions(belongId);
}
  
  
  
  
}
