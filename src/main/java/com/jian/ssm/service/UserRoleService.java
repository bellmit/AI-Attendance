package com.jian.ssm.service;

import java.util.List;


import com.jian.ssm.entity.RoleMenus;
import com.jian.ssm.entity.UserRole;

/**
 * 
 * @ClassName:  UserRoleService   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018��4��26�� ����11:43:53   
 *
 */
public interface UserRoleService {
     
	   UserRole  selectUser(String  userName);
	   List<UserRole>  selectMenus(int  roleId ,String userName);
	   List<UserRole>  getManagers(int belongId);
	   int  deleteUser(String userName);
	   
	   int insertUser(String userName,String password,String description,int belongId);
	   
	   int insertRoleMenus(int roleId ,int menuId);
	   
	   int getroleId(String userName);
	   
	   
	   int getUserRoleCount(int belongId);
	   
	   int changePwd(String name ,String pwd);
	   
	   List<RoleMenus>  selectRoleMenus(int roleId);
	   
	    String    selectMenusByMuensId(int menusId );
	    
	    int updateUserRole(UserRole  ur);
	    
	    int  deleteRoleMenusByRoleId(int roleId);
	   
} 
