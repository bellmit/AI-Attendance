package com.jian.ssm.entity;

/**
 * 
 * @ClassName: UserRole
 * @Description:TODO
 * @author: jianlinwei
 * @date: 2018��4��26�� ����11:41:09
 *
 */
public class UserRole {
	private String username;
	private String password;
	private int roleId;
	private int menusId;
	private String description;
	
	private String scope;
	private int belongid;
	private Company company;


	

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getBelongid() {
		return belongid;
	}

	public void setBelongid(int belongid) {
		this.belongid = belongid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public int getMenusId() {
		return menusId;
	}

	public void setMenusId(int menusId) {
		this.menusId = menusId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
