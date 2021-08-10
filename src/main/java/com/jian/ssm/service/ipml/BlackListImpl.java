package com.jian.ssm.service.ipml;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jian.ssm.dao.BlackListDao;

import com.jian.ssm.service.BlackListService;
@Service
public class BlackListImpl implements BlackListService {
   @Resource
   BlackListDao  bd ;
	@Override
	public int getBlackListPeo(String visitorId,int belongId) {
		
		return bd.getBlackListPeo(visitorId,belongId);
	}

}
