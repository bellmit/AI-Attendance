package com.jian.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jian.ssm.entity.Device;
import com.jian.ssm.entity.UserRole;
import com.jian.ssm.service.DeviceService;
@SuppressWarnings(value = { "unused" })  
@Controller
@RequestMapping("/device")
public class DeviceController {
	@Autowired
	DeviceService  ds ;
	/**
	 * 
	 * @Title: getdevice   
	 * @Description: 设备   
	 * @param: @param request
	 * @param: @return 
	 * @author: jianlinwei     
	 * @return: String      
	 * @throws
	 */
    @RequestMapping(value="/getdevice" , method  = RequestMethod.GET)
	public  String getdevice(HttpServletRequest request){
		
		
		return "visitorJsp/device";
	}
	@RequestMapping(value="/getdevicecount" , method = RequestMethod.GET)
	@ResponseBody
    public  Map<String, Integer>  getdevicecount(HttpServletRequest request){
    	UserRole   ur =  (UserRole) request.getSession().getAttribute("UserRole");
    	int count = ds.getDeviceCount(ur.getBelongid());
    	Map<String, Integer>  map  = new HashMap<>();
    	map.put("count", count);
    	return  map;
    }
	@RequestMapping(value="/getdevices" , method  = RequestMethod.GET)
	@ResponseBody
	public  Map<String, List<Device>> getdevices(HttpServletRequest request){
		UserRole   ur =  (UserRole) request.getSession().getAttribute("UserRole");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		int befor = Integer.parseInt(limit) * (Integer.parseInt(page) - 1) + 1;
		int after = Integer.parseInt(page) * Integer.parseInt(limit);
		List<Device>  ld = ds.getDeviceByBelongId(ur.getBelongid(),befor,after);
		Map<String, List<Device>>  map  = new HashMap<>();
		map.put("ld", ld);
		return map;
	}
	@RequestMapping(value="/deleteDevice" , method = RequestMethod.POST)
	public  String deleteDevice(HttpServletRequest  request){
		UserRole   ur =  (UserRole) request.getSession().getAttribute("UserRole");
		String deviceId = request.getParameter("deviceId");
		ds.deleteDevice(deviceId, ur.getBelongid());
		return "visitorJsp/device";
	}
	
	
	@RequestMapping(value="/updateDevice",method = RequestMethod.POST)
	public  String updateDevice(HttpServletRequest request){
		UserRole   ur =  (UserRole) request.getSession().getAttribute("UserRole");
		String deviceId = request.getParameter("deviceId");
		Device  de  =ds.selectDevice(deviceId);
		if(de.getKeyStatus() == 1){
			ds.updateDeviceKeystatus(deviceId, -1);
		}else{
			ds.updateDeviceKeystatus(deviceId, 1);
		}
		
		
		return "visitorJsp/device";
	}
}
