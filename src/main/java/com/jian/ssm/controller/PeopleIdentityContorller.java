package com.jian.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jian.ssm.entity.PeopleIdentity;
import com.jian.ssm.entity.RoleMenus;
import com.jian.ssm.entity.UserRole;
import com.jian.ssm.service.PeopleIdentityService;
import com.jian.ssm.service.UserRoleService;

@Controller
@RequestMapping("/peopleIdentity")
public class PeopleIdentityContorller {
	@Autowired
	PeopleIdentityService  pis ;
	@Autowired
	UserRoleService  urs ;
	
	/**
	 * 
	 * @LocalUrl: http://192.168.3.115:8080/LTManage/PeopleIdentityApi  
	 * @ServerUrl:  http://47.105.48.97:8086/LTManage/PeopleIdentityApi  
	 * @Description: 人证比对接口  
	 * @param: @param request{"birth": "1988-11-25", "deviceId": "863539032189584",  
	 * "idCardNum": "320921198811252431",    "name": "XXX",  "nation": "汉族",    "permanentAddr": "江苏省响水县", 
	 * "sex": "男", "idCardPic": "/9j/4AAQS..","photo": "/9j/4AAQS.."  ,"compareScore":"0.63" ,"compareResult":"成功" ,"userName":"test"}
	 * @param: @param data
	 * @param: @return {resultCode:0,resultDesc:"操作成功",data:\"}
	 * @author: JianLinWei     
	 * @return: String      
	 * @throws
	 */
	
	@RequestMapping(value="/PeopleIdentityApi" , method = RequestMethod.POST)
	@ResponseBody
	public  String  PeopleIdentityApi(HttpServletRequest  request , @RequestBody String data){
		JSONObject  json = new JSONObject();
		Base64.Decoder   de  = Base64.getDecoder();
		SimpleDateFormat  format  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		PeopleIdentity  pi  = new PeopleIdentity();
		int  x =0;
		try{
	    json = new JSONObject(data);
		pi.setUuid(String.valueOf(UUID.randomUUID()));
		pi.setIdcard(json.getString("idCardNum"));
		pi.setName(json.getString("name"));
		pi.setSex(json.getString("sex"));
		pi.setBirthday(json.getString("birth"));
		pi.setDeviceId(json.getString("deviceId"));
		pi.setNation(json.getString("nation"));
		pi.setAddress(json.getString("permanentAddr"));
		pi.setIdphoto(de.decode(json.getString("idCardPic")));
		pi.setCameraphoto(de.decode(json.getString("photo")));
		pi.setIdentityDate(format.format(new Date()));
		pi.setCompareScore(json.getString("compareScore"));
		pi.setCompareResult(json.getString("compareResult"));
	    UserRole   ur =	urs.selectUser(json.getString("userName"));
	    if(ur!=null){
	    	pi.setBelongid(ur.getBelongid());
	    }
		 x = pis.insertPeopleIdentity(pi);
		}catch(Exception e){
			e.printStackTrace();
			json.put("resultCode", -1);
			json.put("resultDesc", "数据格式有误");
			json.put("data", "");
		}
	
		if(x==1){
			json.put("resultCode", 1);
			json.put("resultDesc", "操作成功");
			json.put("data", "");
		}
		return  json.toString();
	}
	
	/**
	 * 
	 * @Title: GetPeopleIdentity   
	 * @Description: TODO   
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value="/GetPeopleIdentity" , method =RequestMethod.GET)
	public  String  GetPeopleIdentity(HttpServletRequest request ,Model  model){
		UserRole ur = (UserRole) request.getSession().getAttribute("UserRole");
		List<RoleMenus>  lr  =  urs.selectRoleMenus(ur.getRoleId());
		if(lr.size()>0 && lr.contains(20)){
			model.addAttribute("query", 1);
		}
		if(lr.size() > 0 && lr.contains(21)){
			model.addAttribute("delete", 1);
		}
		
		return "plepeoIdentity/plepeoIdentity";
	}
	@RequestMapping(value="/GetPeopleIdentityS" , method =RequestMethod.GET)
	@ResponseBody
	public String  GetPeopleIdentityS(HttpServletRequest  request){
		UserRole ur = (UserRole) request.getSession().getAttribute("UserRole");
		JSONObject  json  = new JSONObject();
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		List<PeopleIdentity>  lp = pis.selectPeopleIdentityByBelongId(befor, after, ur);
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", lp.size());
		json.put("data", lp);
		return json.toString();
	}
	
	
	@RequestMapping(value="/GetPeopleIdentityReload" ,method = RequestMethod.GET)
	@ResponseBody
	public   String GetPeopleIdentityReload(HttpServletRequest request){
		UserRole ur = (UserRole) request.getSession().getAttribute("UserRole");
		JSONObject  json = new JSONObject();
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		String  idcard  = request.getParameter("idcard");
		String name = request.getParameter("name");
		List<PeopleIdentity>  lp  = new ArrayList<>();
		if(StringUtils.isNotEmpty(idcard)){
		  lp =	pis.selectPeopleIdentityByIdcard(befor, after,ur, idcard);
		}
		
		if(StringUtils.isNotEmpty(name)){
			lp  = pis.selectPeopleIdentityByName(befor, after, ur, name);
		}
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", lp.size());
		json.put("data", lp);
		return  json.toString();
	}

	
	
}
