package com.jian.ssm.service.ipml;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jian.ssm.dao.UserRoleDao;
import com.jian.ssm.entity.RoleMenus;
import com.jian.ssm.entity.UserRole;
import com.jian.ssm.service.UserRoleService;

/**
 * 
 * @ClassName:  UserRoleImpl   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018��4��26�� ����11:45:38   
 *
 */
@Service
public class UserRoleImpl  implements UserRoleService{
  @Resource
  UserRoleDao  urd ;
	@Override
	public UserRole selectUser(String userName) {
		
		return urd.selectUser(userName);
	}
	@Override
	public List<UserRole> selectMenus(int roleId ,String userName) {
		
		return urd.selectMenus(roleId ,userName);
	}
	@Override
	public List<UserRole> getManagers(int belongId) {
		
		return urd.getManagers(belongId);
	}
	@Override
	public int deleteUser(String userName) {
		 urd.deleteRoleMenu(urd.getroleId(userName));
		return urd.deleteUser(userName);
	}
	@Override
	public int insertUser(String userName, String password, String description,int belongId) {
	 
		return urd.insertUser(userName, password, description,belongId) ;
	}
	@Override
	public int insertRoleMenus(int roleId, int menuId) {
	
		return urd.insertRoleMenus(roleId, menuId);
	}
	@Override
	public int getroleId(String userName) {
		
		return urd.getroleId(userName);
	}
	@Override
	public int getUserRoleCount(int belongId) {
		
		return urd.getUserRoleCount(belongId);
	}
	@Override
	public int changePwd(String name ,String pwd) {
		
		return urd.changePwd(name ,pwd);
	}
	@Override
	public List<RoleMenus> selectRoleMenus(int roleId) {
		
		return urd.selectRoleMenus(roleId);
	}
	@Override
	public String selectMenusByMuensId(int menusId) {
		
		return urd.selectMenusByMuensId(menusId);
	}
	@Override
	public int updateUserRole(UserRole ur) {
		
		return urd.updateUserRole(ur);
	}
	@Override
	public int deleteRoleMenusByRoleId(int roleId) {
	
		return urd.deleteRoleMenu(roleId);
	}
	
}
