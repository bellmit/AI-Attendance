package com.jian.ssm.service.ipml;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jian.ssm.dao.MettingDao;
import com.jian.ssm.entity.Metting;
import com.jian.ssm.entity.MettingEmp;
import com.jian.ssm.service.MettingService;
@Service
public class MettingImpl  implements  MettingService {
   @Resource
   MettingDao  md ;
	
	
	@Override
	public int insertMetting(Metting metting) {
		
		return md.insertMetting(metting);
	}


	@Override
	public List<Metting> queryMetting() {
	
		return md.queryMetting();
	}


	@Override
	public int updateMetting(Metting m) {
		
		return md.updateMetting(m);
	}


	@Override
	public int deleteMet(int mettingId) {
		
		return md.deleteMet(mettingId);
	}


	@Override
	public List<Metting> getMettingSignInfo() {
		
		return md.getMettingSignInfo();
	}


	@Override
	public Metting selectMettingById(int mettingId) {
		
		return md.selectMettingById(mettingId);
	}


	@Override
	public int deleteMetSignInfo(int id) {
		
		return md.deleteMetSignInfo(id);
	}


	@Override
	public List<Metting> selectMetting() {
	
		return md.selectMetting();
	}


	@Override
	public int insertMettingEmp(MettingEmp me) {
		
		return md.insertMettingEmp(me);
	}

}
