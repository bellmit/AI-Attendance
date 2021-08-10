package com.jian.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jian.ssm.entity.Device;

/**
 * 
 * @ClassName:  DeviceDao   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年4月27日 上午11:11:23   
 *
 */
public interface DeviceDao {
      
	  Device  selectDevice(@Param("deviceId")String deviceid);
	  
	  int   insertDevice(@Param("deviceId")String deviceid ,@Param("ip") String ip ,
			             @Param("parameter") String param , @Param("type")int type ,
			             @Param("address")String address , @Param("description")String description,
			             @Param("port") int port,@Param("belongId")int belongId,@Param("keyStatus")int keystatus);
	  int   updateDevice(@Param("deviceId")String deviceid ,@Param("ip") String ip ,
	             @Param("parameter") String param , @Param("type")int type ,
	             @Param("address")String address , @Param("description")String description,
	             @Param("port") int port,@Param("belongId")int belongId);
	  String selectDescription(@Param("deviceId")String deviceId,@Param("belongId")int belongId);
	  
	  
	  int  getDeviceCount(@Param("belongId")int belongId);
	  
	  List<Device>  getDeviceByBelongId(@Param("belongId")int belongId,@Param("befor") int befor ,@Param("after")int after);
	  
	  String  getCompanyDes(@Param("belongId")int belongId);
	  
	  int  deleteDevice(@Param("deviceId")String deviceId ,@Param("belongId")int belongId);
	  
	  
	  int  updateDeviceKeystatus(@Param("deviceId")String deviceId ,@Param("keyStatus")int keyStatus);
}
