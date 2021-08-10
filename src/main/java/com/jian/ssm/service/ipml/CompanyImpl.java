package com.jian.ssm.service.ipml;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jian.ssm.dao.CompanyDao;
import com.jian.ssm.entity.Company;
import com.jian.ssm.service.CompanyService;

@Service
public class CompanyImpl implements CompanyService {
   @Resource
   CompanyDao   cd ;
	@Override
	public List<Company> selectCompany() {
		
		return cd.selectCompany();
	}
	@Override
	public Company getCompanyByBelongId(int belongId) {
		
		return cd.getCompanyByBelongId(belongId);
	}
	@Override
	public int addCompany(Company company) {
		
		return cd.addCompany(company);
	}
	@Override
	public int updateCompany(Company company) {
		
		return cd.updateCompany(company);
	}
             
	
}
