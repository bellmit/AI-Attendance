package com.jian.ssm.service.ipml;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jian.ssm.dao.DepartmentDao;
import com.jian.ssm.entity.Department;
import com.jian.ssm.service.DepartmentService;

/**
 * 
 * @ClassName:  DepartmentImpl   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年4月28日 下午2:51:16   
 *
 */
@Service
public class DepartmentImpl  implements  DepartmentService{
  @Resource
  DepartmentDao  dpd;
	@Override
	public int insertDepartment(String departmentname,int belongId) {
	
		return dpd.insertDepartment(departmentname, belongId);
	}

	@Override
	public List<Department> selectDepens(int belongId) {
	
		return dpd.selectDepens(belongId);
	}

	@Override
	public Department selectDepen(String departmentname,int belongId) {
	
		return dpd.selectDepen(departmentname,belongId);
	}

	@Override
	public int deleteDepen(int departmentid,int belongId) {
		
		return dpd.deleteDepen(departmentid,belongId);
	}

	@Override
	public String seleteDepenName(int departmentid,int belongId) {
		
		return dpd.seleteDepenName(departmentid ,belongId);
	}
         
}
