package com.jian.ssm.service.ipml;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jian.ssm.dao.ReasonDao;
import com.jian.ssm.dao.VersionDao;
import com.jian.ssm.entity.Reason;
import com.jian.ssm.entity.Version;
import com.jian.ssm.service.ReasonService;

/**
 * 
 * @ClassName:  ReasonImpl   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年5月15日 下午12:21:23   
 *
 */
@Service
public class ReasonImpl implements ReasonService {
	@Resource
	ReasonDao  rd;
	@Resource
	VersionDao vd;

	@Override
	public Reason seleteReasonByName(String reasonName,int belongId) {
	
		return rd.seleteReasonByName(reasonName,belongId);
	}

	@Override
	public int inserRason(String reasonname ,int belongId) {
		int x = rd.inserRason(reasonname ,belongId);
		if(x == 1){
		Version version =	vd.selectVerson("reason",belongId);
		if(version == null){
			vd.insertVersion("reason", System.currentTimeMillis(),belongId);
		}else{
			vd.updateVersion("reason", System.currentTimeMillis(),belongId);
		}
		}
		return x;
	}

	@Override
	public  List<Reason> sleteReason(int belongId) {
		
		return rd.sleteReason(belongId);
	}

	@Override
	public int deleteReason(int reasonid,int belongId) {
	   vd.updateVersion("reason", System.currentTimeMillis(),belongId);
		return rd.deleteReason(reasonid,belongId);
	}

	@Override
	public String selectReasonName(int reasonid,int belongId) {
		
		return rd.selectReasonName(reasonid,belongId);
	}
  
}
