package com.jian.ssm.service.ipml;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.jian.ssm.dao.BlackListDao;
import com.jian.ssm.dao.VersionDao;
import com.jian.ssm.dao.VistorDao;
import com.jian.ssm.entity.BlackList;
import com.jian.ssm.entity.Version;
import com.jian.ssm.entity.Vistor;
import com.jian.ssm.service.VistorService;
@Service
public class VistorImpl implements VistorService{
 @Resource
 VistorDao  vd ;
 @Resource
 VersionDao  vsd ;
 @Resource
 BlackListDao  bld ;
	
	@Override
	public int insertVistor(Vistor  v) {
		int x = 0 ;
		try{
		x = vd.insertVistor(v.getVisitorid(), v.getIdtype(), v.getVisitorname(), v.getSex(), v.getNation(), v.getBirthday(), v.getAddress(), v.getDepart(),v.getValiditybegin(), v.getValidityend(), v.getIdphoto(), v.getCameraphoto(), v.getCamerafeature(), v.getFingerfeature(), v.getAction(), v.getVersion(),v.getBelongid(),v.getFaceVerifyScore(),v.getFaceVerifyResult(),v.getDataTime(),v.getContact());
		if(x == 1){
		Version version =	vsd.selectVerson("vistor",v.getBelongid());
		if(version == null){
			vsd.insertVersion("vistor", System.currentTimeMillis(),v.getBelongid());
		}else{
			vsd.updateVersion("vistor", System.currentTimeMillis(),v.getBelongid());
		}
		}
		}catch(DuplicateKeyException e){
			e.printStackTrace();
			x=2;
		}
		
		return x;
	}

	@Override
	public Vistor selectVisitorById(String visitorId ,int belongId) {
		
		return vd.selectVisitorById(visitorId,belongId);
	}

	@Override
	public String selectVisitorAddressById(String visitorId ,int belongId) {
		
		return vd.selectVisitorAddressById(visitorId,belongId);
	}

	@Override
	public int updateVisitor(Vistor v) {
		
		return vd.updateVisitor(v.getIdtype(),v.getVisitorid(), v.getCameraphoto(),v.getBelongid());
	}

	@Override
	public List<Vistor> selectVisitors(int befor, int after,int belongId) {
		
		return vd.selectVisitors(befor, after,belongId);
	}

	@Override
	public int selectCount(int belongId) {
		
		return vd.selectCount(belongId);
	}

	@Override
	public int updateVisiorAction(String visitorId, int action,int belongId) {
		
		return vd.updateVisiorAction(visitorId ,action,belongId);
	}

	@Override
	public int insertBlackList(String visitorId , int belongId) {
		
		return vd.insertBlackList(visitorId ,belongId);
	}

	@Override
	public List<Vistor> blackList(int befor, int after ,int belongId) {
	   List<BlackList>  lb  =  bld.selectBlackList(befor, after ,belongId);
	   List<Vistor>  lv  = new ArrayList<Vistor>();
	   for(int i = 0 ; i < lb.size() ; i++){
		   Vistor  v  = vd.selectVisitorById(lb.get(i).getVisitorid() ,belongId);
		   lv.add(v);
	   }
		return lv;
	}

	@Override
	public int deleteBlackList(String visitorId,int belongId) {
		
		return vd.deleteBlackList(visitorId,belongId);
	}

	@Override
	public List<Vistor> getvisitorByVisitorName(String visitorName , int belongId) {
	
		return vd.getvisitorByVisitorName(visitorName , belongId);
	}

	

}
