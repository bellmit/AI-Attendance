package com.jian.ssm.service;

import java.util.List;

import com.jian.ssm.entity.Company;

public interface CompanyService {
	 List<Company>   selectCompany();
	 Company  getCompanyByBelongId(int belongId);
	 
	 int  addCompany(Company company);
	 
	 int updateCompany(Company company);
	 
}
