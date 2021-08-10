package com.jian.ssm.service;



import java.util.List;

import com.jian.ssm.entity.Device;

/**
 * 
 * @ClassName:  DeviceService   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年4月27日 下午7:00:06   
 *
 */
public interface DeviceService {

	 Device  selectDevice(String deviceid );
	  int   insertDevice(String deviceid ,String ip ,
			              String param , int type ,
			             String address , String description,
			            int port,int belongId,int keystaus);
	  int   updateDevice(String deviceid , String ip ,
	              String param , int type ,
	             String address , String description,
	              int port,int belongId);
	  String selectDescription(String deviceId,int  belongId);
	  
	  
	  int  getDeviceCount(int belongId);
	  
	  List<Device>  getDeviceByBelongId(int belongId , int befor , int after);
	  
	  int  deleteDevice(String deviceId , int belongId);
	  
	  int  updateDeviceKeystatus(String deviceId ,int keyStatus);
}
