package com.jian.ssm.service;

import java.util.List;



import com.jian.ssm.entity.Department;

/**
 * 
 * @ClassName:  DepartmentService   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年4月28日 下午2:50:36   
 *
 */
public interface DepartmentService {

	  int   insertDepartment(String departmentname,int belongId);
	  List<Department>  selectDepens(int belongId);
	  Department   selectDepen( String departmentName,int belongId);
	  int   deleteDepen( int departmentid,int belongId);
	  
	  String seleteDepenName(int departmentid,int belongId);
}
