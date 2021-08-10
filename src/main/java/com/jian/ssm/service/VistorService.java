package com.jian.ssm.service;


import java.util.List;

import com.jian.ssm.entity.Vistor;

public interface VistorService {
	
	int insertVistor(Vistor  vistor);
	Vistor  selectVisitorById(String visitorId,int belongId);
	 String  selectVisitorAddressById(String visitorId ,int belongId);
	 int  updateVisitor (Vistor visitor);
	 List<Vistor>  selectVisitors(int befor , int after ,int belongId);
	 int  selectCount(int belongId);
	 
	 int updateVisiorAction(String visitorId, int action,int belongId);
	 int  insertBlackList(String visitorId,int belongId);
	 int deleteBlackList(String visitorId ,int belongId);
	 
	 
	 List<Vistor>  blackList(int befor ,int after ,int belongId);
	 List<Vistor>  getvisitorByVisitorName(String visitorName , int belongId);
}
