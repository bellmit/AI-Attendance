package com.jian.ssm.service;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.jian.ssm.entity.Employee;
import com.jian.ssm.entity.UserRole;

/**
 * 
 * @ClassName: EmployeeService
 * @Description:TODO
 * @author: jianlinwei
 * @date: 2018年5月7日 上午11:19:35
 *
 */
public interface EmployeeService {
	int seleteEmp(String name, int belongId);

	List<Employee> seleteLemp(int befor, int after, int belongId);

	String insertEmp( String id ,int departmentid, String name,  String phone, String email, String photo, String sex,
			int belongId, HttpServletRequest request ,String ICcard);

	int seleteEmpCount(int belongId);

	int deleteEmp(String id,  int belongId);

	byte[] selectEmpPhoto(String id, int belongId);

	List<Employee> selectEmp(int belongId );

	String selectEmpName(int id, int belongId);
	
	
	List<Employee>  selectEmpByName(String name ,int belongId);
	
	List<Employee>   selectEmpByDepartmentname(String departmentName , int belongId);
	
	List<Employee>   selectEmpByWorkId(String workId , int belongId);
	
	int  updateEmp(Employee employee  , String id, HttpServletRequest request);
	
	List<Employee>  selectEmpByVersion(long version);
	
	Employee  selectEmpById(String employeeId , int belongId);
	
	List<Employee>  selectEmpByIdList(String employeeId,int belongId);
	
	int   importExcelInfo(InputStream in, MultipartFile file ,UserRole  ur);
	
	Employee  selectEmpByZeId(int id);
	
	Employee  selectEmpByICcard(String ICcard);
	
	List<Employee>  selectEmpByICcardList(String ICcard, int belongId);
	
	List<Employee> selectEmpByRowbounds(int belongId ,int befor ,int after);
}
