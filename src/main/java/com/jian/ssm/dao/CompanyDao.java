package com.jian.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jian.ssm.entity.Company;

public interface CompanyDao {
       List<Company>   selectCompany();
       
       List<Company>   getCompanys(@Param("belongId")int belongId);
       
       Company  getCompanyByBelongId(@Param("belongId")int belongId);
       
       int  addCompany(@Param("Company")Company  company) ;
       
       int updateCompany(@Param("Company")Company company);
}
