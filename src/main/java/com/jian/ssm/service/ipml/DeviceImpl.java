package com.jian.ssm.service.ipml;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jian.ssm.dao.CompanyDao;
import com.jian.ssm.dao.DeviceDao;
import com.jian.ssm.entity.Company;
import com.jian.ssm.entity.Device;
import com.jian.ssm.service.DeviceService;

@Service
public class DeviceImpl implements DeviceService {
    @Resource
    DeviceDao  dd ;
    @Resource
    CompanyDao  cd ;

	@Override
	public Device selectDevice(String deviceid) {
		
		return dd.selectDevice(deviceid);
	}

	@Override
	public int insertDevice(String deviceid, String ip, String param, int type, String address, String description,
			int port,int belongId,int keystatus) {
		
		return dd.insertDevice(deviceid, ip, param, type, address, description, port,belongId,keystatus);
	}

	@Override
	public int updateDevice(String deviceid, String ip, String param, int type, String address, String description,
			int port,int belongId) {
		
		return dd.updateDevice(deviceid, ip, param, type, address, description, port,belongId);
	}

	@Override
	public String selectDescription(String deviceId,int belongId) {
		
		return dd.selectDescription(deviceId,belongId);
	}

	@Override
	public int getDeviceCount(int belongId) {
		int  count = dd.getDeviceCount(belongId);
		if(belongId != 0){
	   List<Company>  lc  =  cd.getCompanys(belongId);
	   for(int i = 0 ; i < lc.size() ;i++){
		   if(lc.get(i).getBelongid()!=belongId){
		 count = count +  dd.getDeviceCount(lc.get(i).getBelongid());
		   }
	   }
		}
	   
		return count;
	}


	@Override
	public List<Device> getDeviceByBelongId(int belongId, int befor, int after) {
		List<Device>  ld  = dd.getDeviceByBelongId(belongId, befor, after);
		if(belongId !=0){
		List<Company>  lc  =  cd.getCompanys(belongId);
		   for(int i = 0 ; i < lc.size() ;i++){
			   if(lc.get(i).getBelongid()!=belongId){
				   ld.addAll(dd.getDeviceByBelongId(lc.get(i).getBelongid(), befor, after));
			   }
		   }
		}
			for(int i = 0 ; i < ld.size() ; i++){
				ld.get(i).setCompany(dd.getCompanyDes(ld.get(i).getBelongid()));
				if(ld.get(i).getKeyStatus() == 1){
					ld.get(i).setKey("已授权");
				}else{
					ld.get(i).setKey("未授权");
				}
			}
		return  ld;
	}

	@Override
	public int deleteDevice(String deviceId, int belongId) {
		
		return dd.deleteDevice(deviceId, belongId);
	}

	@Override
	public int updateDeviceKeystatus(String deviceId, int keyStatus ) {
		
		return dd.updateDeviceKeystatus(deviceId, keyStatus);
	}
	
    
    
}
