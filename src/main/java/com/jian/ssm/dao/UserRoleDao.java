package com.jian.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.jian.ssm.entity.RoleMenus;
import com.jian.ssm.entity.UserRole;

/**
 * 
 * @ClassName:  UserRoleDao   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018��4��26�� ����3:40:45   
 *
 */
public interface  UserRoleDao {
         UserRole   selectUser(@Param("userName")String userName); 
         
         List<UserRole>  selectMenus(@Param("roleId")int  roleId ,@Param("userName")String userName);
         
         List<UserRole>  getManagers(@Param("belongId")int belongId );
         
         int deleteUser(@Param("userName")String userName);
         
         int insertUser(@Param("userName")String userName ,
        		         @Param("password")String password ,
        		         @Param("description")String description,
        		         @Param("belongId")int belongId);
         
         int insertRoleMenus(@Param("roleId")int roleId ,@Param("menusId")int menuId);
         
         int getroleId(@Param("userName")String userName);
         int deleteRoleMenu(@Param("roleId")int roleId);
         
         int getUserRoleCount(@Param("belongId")int belongId);
         
         
         int changePwd(@Param("name")String name ,@Param("pwd")String pwd);
         
         
         List<RoleMenus>  selectRoleMenus(@Param("roleId")int roleId);
       
         String    selectMenusByMuensId(@Param("menusId")int menusId );
         
         int updateUserRole(@Param("ur")UserRole  ur);
         
}
