package com.jian.ssm.controller;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jian.ssm.entity.Company;
import com.jian.ssm.entity.RoleMenus;
import com.jian.ssm.entity.UserRole;
import com.jian.ssm.service.CompanyService;
import com.jian.ssm.service.UserRoleService;
import com.jian.ssm.util.MD5Util;

/**
 * 
 * @ClassName:  UserRoleController   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年5月24日 上午10:32:04   
 *
 */
@SuppressWarnings(value = { "unused" })  
@Controller
@RequestMapping("/user")
public class UserRoleController {
	@Autowired
	UserRoleService  urs ;
	@Autowired
	CompanyService  cs ;

	/**
	 * 
	 * @Title: admin @Description: 管理员管理 @param: @return @author:
	 * jianlinwei @return: String @throws
	 */
	@RequestMapping(value = "/getadminconfig", method = RequestMethod.GET)
	public  String getadmincongfig(){
		return "visitorJsp/adminconfig";
	}
	
	
	@RequestMapping(value = "/adminconfig", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, List<UserRole>> admin(HttpServletRequest request ,Model  model) {
       UserRole ur  = (UserRole) request.getSession().getAttribute("UserRole");
       Map<String, List<UserRole>>  map  = new HashMap<>();
       List<UserRole> lu  = urs.getManagers(ur.getBelongid());
         
      /* lu.add(ur);*/
       for(int f  = 0 ; f < lu.size()  ; f++){
    	   lu.get(f).setCompany(cs.getCompanyByBelongId(lu.get(f).getBelongid()));
    	   List<UserRole>  lum  = urs.selectMenus(lu.get(f).getRoleId() ,lu.get(f).getUsername());
    	   StringBuffer  sb=  new StringBuffer();
           for (int i = 0; i < lum.size(); i++) {
        	   if(lum.get(i).getMenusId() == 1){sb.append("管理员管理");}
        	   if(lum.get(i).getMenusId() == 2){sb.append(",角色管理");}
        	   if(lum.get(i).getMenusId() == 3){sb.append(",访客平台");}
        	   if(lum.get(i).getMenusId() == 4){sb.append(",访问记录");}
        	   if(lum.get(i).getMenusId() == 5){sb.append(",访客管理");}
        	   if(lum.get(i).getMenusId() == 6){sb.append(",黑名单管理");}
        	   if(lum.get(i).getMenusId() == 7){sb.append(",访问事由字典");}
        	   if(lum.get(i).getMenusId() == 8){sb.append(",部门管理");}
        	   if(lum.get(i).getMenusId() == 9){sb.append(",员工管理");}
        	   if(lum.get(i).getMenusId() == 10){sb.append(",考勤平台");}
        	   if(lum.get(i).getMenusId() == 11){sb.append(",考勤记录");}
        	   if(lum.get(i).getMenusId() == 12){sb.append(",签到平台");}
        	   if(lum.get(i).getMenusId() == 13){sb.append(",创建会议");}
        	   if(lum.get(i).getMenusId() == 14){sb.append(",会议签到记录");}
        	   if(lum.get(i).getMenusId() == 15){sb.append(",设备管理");}
        	   if(lum.get(i).getMenusId() == 16){sb.append(",设备列表");}
        	   if(lum.get(i).getMenusId() == 17){sb.append(",考勤报表");}
        	   if(lum.get(i).getMenusId() == 18){sb.append(",人证合一");}
        	   if(lum.get(i).getMenusId() == 19){sb.append(",人证核验");}
        	   String scope  = sb.toString();
        	   for (int j = 0; j < lu.size(); j++) {
        			if(lu.get(j).getUsername().equals(lum.get(i).getUsername())){
        				lu.get(j).setScope(scope);
        			}
        		}
    	   }
       }
       map.put("lu", lu);
       
		return map;
	}
    @RequestMapping(value="/deleteUser" , method  =RequestMethod.POST)
	public  String deleteUser(HttpServletRequest request,Model model){
		String userName = request.getParameter("userName");
		if(!userName.equals((String)request.getSession().getAttribute("user"))){
			  urs.deleteUser(userName);
		}else{
			model.addAttribute("msg", "把自己删了还怎么玩？");
		}
		
		return  "visitorJsp/adminconfig";
	}
    
    
    
    @RequestMapping(value = "/addUser" , method=RequestMethod.GET)
    public  String  addUser(HttpServletRequest  request){
    	
    	return "visitorJsp/addUser";
    }
    @RequestMapping(value = "/addUser" , method=RequestMethod.POST)
    public  String  addUser(HttpServletRequest  request,HttpServletResponse response , Model model) throws UnsupportedEncodingException{
    	UserRole  ur = (UserRole) request.getSession().getAttribute("UserRole");
    	String  menu  = request.getParameter("menu");
    String data = request.getParameter("data");
    JSONObject  json  = new JSONObject(data);
    String userName = json.getString("username");
    if(  urs.selectUser(userName) !=null){
   	 model.addAttribute("msg", "改用户名已经被使用");
   	 request.setAttribute("msg", "改用户名已经被使用");
   	 return "0";
    }else{
    String password = json.getString("password");
    String description = json.getString("description");
    MD5Util  md5  = new MD5Util();
    String password_md5  = md5.md5(password, "utf-8");
    String companyDes  = json.getString("company");
    Company  company  = new Company();
    company.setDescription(companyDes);
    company.setParentid(ur.getBelongid());
    company.setLevel(0);
   cs.addCompany(company);
    int sss = company.getBelongid();
     urs.insertUser(userName, password_md5, description,  sss);
     int roleid = urs.getroleId(userName) ;
        Iterator<String>  ii  =  menuLisit(menu);
        while(ii.hasNext()){
        	String x  = ii.next();
        	if(x.equals("1")){urs.insertRoleMenus(roleid, 1);}
        	if(x.equals("2")){urs.insertRoleMenus(roleid, 2);}
        	if(x.equals("3")){urs.insertRoleMenus(roleid, 3);}
        	if(x.equals("4")){urs.insertRoleMenus(roleid, 4);}
        	if(x.equals("5")){urs.insertRoleMenus(roleid, 5);}
        	if(x.equals("6")){urs.insertRoleMenus(roleid, 6);}
        	if(x.equals("7")){urs.insertRoleMenus(roleid, 7);}
        	if(x.equals("8")){urs.insertRoleMenus(roleid, 8);}
        	if(x.equals("9")){urs.insertRoleMenus(roleid, 9);}
        	if(x.equals("10")){urs.insertRoleMenus(roleid, 10);}
        	if(x.equals("11")){urs.insertRoleMenus(roleid, 11);}
        	if(x.equals("12")){urs.insertRoleMenus(roleid, 12);}
        	if(x.equals("13")){urs.insertRoleMenus(roleid, 13);}
        	if(x.equals("14")){urs.insertRoleMenus(roleid, 14);}
        	if(x.equals("15")){urs.insertRoleMenus(roleid, 15);}
        	if(x.equals("16")){urs.insertRoleMenus(roleid, 16);}
        	if(x.equals("17")){urs.insertRoleMenus(roleid, 17);}
        	if(x.equals("18")){urs.insertRoleMenus(roleid, 18);}
        	if(x.equals("19")){urs.insertRoleMenus(roleid, 19);}
        }
     }
    	return "visitorJsp/addUser";
    }
    
    public  Iterator<String> menuLisit(String menu){
    	String[]  menus = menu.split(",");
    	List<String>  ls   = new ArrayList<>();
    	for(int i = 0 ; i < menus.length ; i++){
    		if(menus[i].equals("2")){
    			ls.add("1");
    		}
    		if(menus[i].equals("4")||menus[i].equals("5")||menus[i].equals("6")||menus[i].equals("7")||menus[i].equals("8")||menus[i].equals("9")){
    			ls.add("3");
    		}
    		if(menus[i].equals("11")){
    			ls.add("10");
    		}
    		if(menus[i].equals("13")||menus[i].equals("14")){
    			ls.add("12");
    		}
    		if(menus[i].equals("16")){
    			ls.add("15");
    		}
    		if(menus[i].equals("19")){
    			ls.add("18");
    		}
    		ls.add(menus[i]);
    	}
    	return ls.iterator();
    }
    
    /**
     * 
     * @Title: updateAdmin   
     * @Description: TODO   
     * @param: @param request
     * @param: @param username
     * @param: @return 
     * @author: jianlinwei     
     * @return: String      
     * @throws
     */
    @RequestMapping(value="/updateAdmin/{username}" , method=RequestMethod.GET)
    public  String GetupdateAdmin(HttpServletRequest  request ,Model  model,@PathVariable String username){
        UserRole  ur =	urs.selectUser(username);
       Company  co = cs.getCompanyByBelongId(ur.getBelongid());
       ur.setCompany(co);
        model.addAttribute("ur", ur);
    	return "visitorJsp/updateAdmin";
    }
    
    @RequestMapping(value="/updateAdmin" , method = RequestMethod.POST)
    public  String updateAdmin(HttpServletRequest request) throws UnsupportedEncodingException{
    	String  menu  = request.getParameter("menu");
        String data = request.getParameter("data");
        UserRole ur = new UserRole();
       
        JSONObject  json  = new JSONObject(data);
       ur.setUsername(json.getString("username"));
        String password = json.getString("password");
        ur.setDescription(json.getString("description"));
        MD5Util  md5  = new MD5Util();
        String password_md5  = md5.md5(password, "utf-8");
        ur.setPassword(password_md5);
        String companyDes  = json.getString("company");
        Company  company  = new Company();
        company.setDescription(companyDes);
        UserRole  ur_2  = urs.selectUser(ur.getUsername());
        company.setBelongid(ur_2.getBelongid());
    	cs.updateCompany(company);
    	urs.updateUserRole(ur);
    	urs.deleteRoleMenusByRoleId(ur_2.getRoleId());
    	
    	 Iterator<String>  ii  =  menuLisit(menu);
         while(ii.hasNext()){
         	String x  = ii.next();
         	if(x.equals("1")){urs.insertRoleMenus(ur_2.getRoleId(), 1);}
         	if(x.equals("2")){urs.insertRoleMenus(ur_2.getRoleId(), 2);}
         	if(x.equals("3")){urs.insertRoleMenus(ur_2.getRoleId(), 3);}
         	if(x.equals("4")){urs.insertRoleMenus(ur_2.getRoleId(), 4);}
         	if(x.equals("5")){urs.insertRoleMenus(ur_2.getRoleId(), 5);}
         	if(x.equals("6")){urs.insertRoleMenus(ur_2.getRoleId(), 6);}
         	if(x.equals("7")){urs.insertRoleMenus(ur_2.getRoleId(), 7);}
         	if(x.equals("8")){urs.insertRoleMenus(ur_2.getRoleId(), 8);}
         	if(x.equals("9")){urs.insertRoleMenus(ur_2.getRoleId(), 9);}
         	if(x.equals("10")){urs.insertRoleMenus(ur_2.getRoleId(), 10);}
         	if(x.equals("11")){urs.insertRoleMenus(ur_2.getRoleId(), 11);}
         	if(x.equals("12")){urs.insertRoleMenus(ur_2.getRoleId(), 12);}
         	if(x.equals("13")){urs.insertRoleMenus(ur_2.getRoleId(), 13);}
         	if(x.equals("14")){urs.insertRoleMenus(ur_2.getRoleId(), 14);}
         	if(x.equals("15")){urs.insertRoleMenus(ur_2.getRoleId(), 15);}
         	if(x.equals("16")){urs.insertRoleMenus(ur_2.getRoleId(), 16);}
         	if(x.equals("17")){urs.insertRoleMenus(ur_2.getRoleId(), 17);}
        	if(x.equals("18")){urs.insertRoleMenus(ur_2.getRoleId(), 18);}
        	if(x.equals("19")){urs.insertRoleMenus(ur_2.getRoleId(), 19);}
         }
      
    	
    	
    	return "visitorJsp/updateAdmin";
    }
    
    
    /**
     * 
     * @Title: getUserRoleCount   
     * @Description: TODO   
     * @param: @param request
     * @param: @return 
     * @author: jianlinwei     
     * @return: Map<String,Integer>      
     * @throws
     */
    @RequestMapping(value="/getUserRoleCount" , method =RequestMethod.GET)
    @ResponseBody
    public Map<String, Integer>   getUserRoleCount(HttpServletRequest request){
    	UserRole  ur =  (UserRole) request.getSession().getAttribute("UserRole");
    	Map<String, Integer>  map  = new HashMap<>();
    	  int  count  = urs.getUserRoleCount(ur.getBelongid());
    	  map.put("count", count);
    	return map;
    }
    
    /**
     * 
     * @Title: getCompany   
     * @Description: 公司机构  
     * @param: @return 
     * @author: jianlinwei     
     * @return: String      
     * @throws
     */
    @RequestMapping(value="/getCompany",method = RequestMethod.GET)
    public String getCompany(){
    	
    	return "visitorJsp/company";
    }
    
    /**
     * 
     * @Title: getRoleMenus   
     * @Description: Xtree获取功能列表 
     * @param: @return 
     * @author: jianlinwei     
     * @return: String      
     * @throws
     */
    @RequestMapping(value="/getMenus" , method= RequestMethod.GET)
    @ResponseBody
    public  String getMenus(HttpServletRequest request){
    	UserRole  uro =  (UserRole) request.getSession().getAttribute("UserRole");
    	List<RoleMenus>   lr  = urs.selectRoleMenus(uro.getRoleId());
    	
    	
    	return null;
    	
    }
    
}
