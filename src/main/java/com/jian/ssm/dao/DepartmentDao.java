package com.jian.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jian.ssm.entity.Department;

/**
 * 
 * @ClassName:  DepartmentDao   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年4月28日 下午2:36:48   
 *
 */
public interface DepartmentDao {
                
	  int   insertDepartment(@Param("departmentName") String departmentname,@Param("belongId")int belongId);
	  List<Department>  selectDepens(@Param("belongId")int belongId);
	  Department   selectDepen(@Param("departmentName") String   departmentname,@Param("belongId")int belongId);
	  int   deleteDepen(@Param("departmentId") int departmentid,@Param("belongId")int belongId);
	  String seleteDepenName(@Param("departmentId")int departmentid,@Param("belongId")int belongId);
}
