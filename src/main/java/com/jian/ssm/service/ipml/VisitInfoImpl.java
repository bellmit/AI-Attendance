package com.jian.ssm.service.ipml;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.jian.ssm.dao.EmployeeDao;
import com.jian.ssm.dao.VersionDao;
import com.jian.ssm.dao.VisitInfoDao;

import com.jian.ssm.entity.CheckOut;
import com.jian.ssm.entity.ExcelBean;
import com.jian.ssm.entity.Version;
import com.jian.ssm.entity.VisiInfoTable;
import com.jian.ssm.entity.VisitInfo;
import com.jian.ssm.service.VisitInfoService;
import com.jian.ssm.util.ExcelUtil;


@Service
public class VisitInfoImpl  implements  VisitInfoService{
	@Resource
	VisitInfoDao  vid ;
	@Resource
	VersionDao  vd ;
	@Resource
	EmployeeDao  ed ;
	
	@Override
	public int insertVisitInfo(VisitInfo vi) {
		int x = 0 ;
	 vi.setEmployeeName(ed.selectEmpName(vi.getEmployeeid(),vi.getBelongid()));
		try{
	     x  =  vid.insertVisitInfo(vi.getVisitid(), vi.getEmployeeid(),
	    		                     vi.getVisitorid(), vi.getVisitorname(), vi.getReasonid(),
	    		                     vi.getCameraphoto(), vi.getCheckindeviceid(), vi.getCheckintime(),
	    		                     vi.getCheckoutdeviceid(), vi.getCheckouttime(), vi.getState(), vi.getComment(), vi.getAction(), vi.getVersion(),vi.getBelongid(),vi.getEmployeeName());
		}catch (DuplicateKeyException e){
			e.printStackTrace();
			x= 1;
		}
		if(x == 1){
			Version  version = vd.selectVerson("visitInfo",vi.getBelongid());
			if(version == null){
				vd.insertVersion("visitInfo", System.currentTimeMillis(),vi.getBelongid());
			}else{
				vd.updateVersion("visitInfo", System.currentTimeMillis(),vi.getBelongid());
			}
		}
		
		return x;
	}


	@Override
	public List<VisitInfo> selectViditInfos(long version, String deviceid ,int belongId) {
		
		return vid.selectViditInfos(version, deviceid ,belongId);
	}


	@Override
	public List<VisitInfo> selectVisit(int befor, int after ,int belongId) {
		
		return vid.selectVisit(befor, after ,belongId);
	}


	@Override
	public int selectCount(int belongId) {
		
		return vid.selectCount(belongId);
	}


	@Override
	public VisitInfo selectVisitInfo(String visitId,int belongId) {
		
		return vid.selectVisitInfo(visitId,belongId);
	}


	

	@Override
	public List<VisitInfo> visitReloadByVisitorName(String visitorName, int befor, int after,int belongId) {
		List<VisitInfo>  lv  = new ArrayList<VisitInfo>();
		if(StringUtils.isNotEmpty(visitorName)){
		lv = vid.VisitReloadByVisitorName(visitorName, befor, after ,belongId);
		}
		return lv;
	}


	@Override
	public List<VisitInfo> visitReloadByEmployeeName(String employeeName, int befor, int after,int belongId) {
		List<VisitInfo>  lv  = new ArrayList<VisitInfo>();
		if(StringUtils.isNotEmpty(employeeName)){
		lv = vid.VisitReloadByEmployeeName(employeeName, befor, after,belongId);
		}
		return lv;
	}


	@Override
	public List<VisitInfo> visitReloadByCheckInDevice(String checkInDevice, int befor, int after,int belongId) {
		List<VisitInfo>  lv  = new ArrayList<VisitInfo>();
		if(StringUtils.isNotEmpty(checkInDevice)){
		lv = vid.VisitReloadCheckInDevice(checkInDevice, befor, after ,belongId);
		}
		return lv;
	}


	@Override
	public List<VisitInfo> visitReloadByCheckOutDevice(String checkOutDevice, int befor, int after,int belongId) {
		List<VisitInfo>  lv  = new ArrayList<VisitInfo>();
		if(StringUtils.isNotEmpty(checkOutDevice)){
		lv = vid.VisitReloadCheckOutDevice(checkOutDevice, befor, after,belongId);
		}
		return lv;
	}


	@Override
	public int deleteVisitInfo(String visitId,int belongId) {
		
		return vid.deleteVisitInfo(visitId,belongId);
	}


	@Override
	public byte[] getAcameraPhoto(String visitorId) {
		VisitInfo  v = vid.getAcameraPhoto(visitorId);
		return v.getCameraphoto();
	}


	@Override
	public int CheckOutUpdate(CheckOut co) {
		
		return vid.CheckOutUpdate(co);
	}


	@Override
	public XSSFWorkbook exportExcelInfo(String data) {
		JSONArray  ja = new JSONArray(data);
		
		List<VisiInfoTable>  lv  = new ArrayList<>();
		
		for (int i = 0; i <ja.length(); i++) {
			VisiInfoTable  vi  = new VisiInfoTable();
			vi.setReasonName(ja.getJSONObject(i).getString("reasonName"));
			vi.setVisitorName(ja.getJSONObject(i).getString("visitorName"));
			if(!ja.getJSONObject(i).getString("checkOutTime").isEmpty()){
				vi.setCheckOutTime(ja.getJSONObject(i).getString("checkOutTime"));
			}
			try{
				vi.setCheckOutDevice(ja.getJSONObject(i).getString("checkOutDevice"));
				vi.setCheckInDevice(ja.getJSONObject(i).getString("checkInDevice"));
			}catch(Exception e){
				
				vi.setCheckOutDevice("");
				vi.setCheckInDevice("");
			}
			
			vi.setCheckInTime(ja.getJSONObject(i).getString("checkInTime"));
		
			vi.setEmpName(ja.getJSONObject(i).getString("empName"));
			vi.setId(ja.getJSONObject(i).getString("id"));
			lv.add(vi);
		}
		List<ExcelBean>  le  = new ArrayList<>();
		Map<Integer, List<ExcelBean>>  map = new LinkedHashMap<>();
	    XSSFWorkbook xssfWorkbook=null;
	    le.add(new ExcelBean("编号","id",0));
	    le.add(new ExcelBean("访问人","visitorName",0));
	    le.add(new ExcelBean("被访人","empName",0));
	    le.add(new ExcelBean("访问事由","reasonName",0));
	    le.add(new ExcelBean("状态","state",0));
	    le.add(new ExcelBean("签入设备","checkInDevice",0));
	    le.add(new ExcelBean("签入时间","checkInTime",0));
	    le.add(new ExcelBean("签离设备","checkOutDevice",0));
	    le.add(new ExcelBean("签离时间","checkOutTime",0));
	    map.put(0, le);
	    String sheetName = "访问记录";
	    //调用ExcelUtil的方法
	    try {
			xssfWorkbook = ExcelUtil.createExcelFile(VisiInfoTable.class, lv, map, sheetName);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return xssfWorkbook;
	}

}
