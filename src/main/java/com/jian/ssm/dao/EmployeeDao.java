package com.jian.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jian.ssm.entity.Employee;

/**
 * 
 * @ClassName: EmployeeDao
 * @Description:TODO
 * @author: jianlinwei
 * @date: 2018年5月7日 上午10:41:14
 *
 */
public interface EmployeeDao {

	int seleteEmp(@Param("name") String name, @Param("belongId") int belongId);

	List<Employee> seleteLemp(@Param("befor") int befor, @Param("after") int after, @Param("belongId") int belongId);

	int insertEmp(@Param("id")String id,@Param("departmentId") int departmentid, @Param("name") String name, 
			@Param("phone") String phone, @Param("email") String email,@Param("photoFeature")byte[]  photoFeature, @Param("photo") byte[] photo,
			@Param("sex") String sex, @Param("belongId") int belongId ,@Param("version")long version ,@Param("ICcard")String ICcard);

	int seleteEmpCount(@Param("belongId") int belongId);

	int deleteEmp(@Param("id") String  id, @Param("belongId") int belongId);

	byte[] seleteEmpPhoto(@Param("id") String id, @Param("belongId") int belongId);

	List<Employee> selectEmp(@Param("belongId") int belongId);

	String selectEmpName(@Param("id") int id, @Param("belongId") int belongId);
	
	List<Employee>  selectEmpByName(@Param("name")String name ,@Param("belongId")int belongId);
	
	List<Employee>   selectEmpByDepartmentname(@Param("departmentName")String departmentName ,@Param("belongId") int belongId);
	
	List<Employee>   selectEmpByWorkId(@Param("workId")String workId ,@Param("belongId") int belongId);
	
	int  updateEmp(@Param("emp")Employee employee ,@Param("id")String id);
	
	List<Employee>  selectEmpByVersion(@Param("version")long version);
	
	Employee  selectEmpById(@Param("employeeId")String employeeId ,@Param("belongId")int belongId);
	
	List<Employee>  selectEmpByIdList(@Param("employeeId")String employeeId,@Param("belongId")int belongId);
	
	Employee  selectEmpByZeId(@Param("zeId")int id);
	
	Employee  selectEmpByICcard(String ICcard);
	
	List<Employee>  selectEmpByICcardList(@Param("ICcard")String ICcard, @Param("belongId")int belongId);
	
	List<Employee> selectEmpByRowbounds(@Param("belongId")int belongId ,@Param("befor")int befor ,@Param("after")int after);
}
