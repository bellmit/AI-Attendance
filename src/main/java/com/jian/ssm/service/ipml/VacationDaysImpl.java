package com.jian.ssm.service.ipml;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jian.ssm.dao.VacationDaysDao;
import com.jian.ssm.entity.VacationDay;
import com.jian.ssm.service.VacationDaysService;

@Service
public class VacationDaysImpl implements VacationDaysService {
	@Resource
	VacationDaysDao  vdd ;

	@Override
	public int insertVacationDay(VacationDay vd) {
		
		return vdd.insertVacationDay(vd);
	}

	@Override
	public int deleteVacationDay(VacationDay vd) {
		
		return vdd.deleteVacationDay(vd);
	}

	@Override
	public List<VacationDay> selectVacationDays(VacationDay vd , int befor , int after) {
		
		return vdd.selectVacationDays(vd , befor , after);
	}

	@Override
	public int selectVacationDaysCount(VacationDay vd) {
		
		return vdd.selectVacationDaysCount(vd);
	}

	

}
