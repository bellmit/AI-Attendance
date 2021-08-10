package com.jian.ssm.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.jian.ssm.entity.Vistor;

public interface VistorDao {
         int  insertVistor(@Param("visitorId")String vistorId , 
        		           @Param("idType")int  idType ,
        		           @Param("visitorName")String vistorName ,
        		           @Param("sex")String sex ,
        		           @Param("nation")String nation,
        		           @Param("birthday")String birthday,
        		           @Param("address")String address,
        		           @Param("depart")String depart ,
        		           @Param("validityBegin")String validityBegin,
        		           @Param("validityEnd")String validityEnd ,
        		           @Param("idPhoto")byte[] idPhoto ,
        		           @Param("cameraPhoto")byte[] cameraPhoto ,
        		           @Param("cameraFeature")byte[] cameraFeature,
        		           @Param("fingerFeature")byte[] fingerFeature ,
        		           @Param("action")int action ,
        		           @Param("version") long version,
        		           @Param("belongId")int  belongId,
        		           @Param("faceVerifyScore") float  faceVerifyScore,
        		           @Param("faceVerifyResult") String faceVerifyResult ,
        		           @Param("dataTime")long dataTime,
        		           @Param("contact")String contact);
         
         
         Vistor  selectVisitorById(@Param("visitorId")String vistorId ,@Param("belongId")int belongId);
         
         String  selectVisitorAddressById(@Param("visitorId")String visitorId,@Param("belongId")int belongId);
         
         int  updateVisitorALL(@Param("visitorId")String visitorId ,
        		   @Param("idType")int  idType ,
		           @Param("sex")String sex ,
		           @Param("nation")String nation,
		           @Param("birthday")String birthday,
		           @Param("address")String address,
		           @Param("depart")String depart ,
		           @Param("validityBegin")String validityBegin,
		           @Param("validityEnd")String validityEnd ,
		           @Param("idPhoto")byte[] idPhoto ,
		           @Param("cameraPhoto")byte[] cameraPhoto ,
		           @Param("version") long version,
		           @Param("belongId")int belongId);
         
         
         int  updateVisitor(@Param("idType")int  idType ,@Param("visitorId")String visitorId, @Param("cameraPhoto")byte[] cameraPhoto,@Param("belongId")int belongId );
         List<Vistor>  selectVisitors(@Param("befor")int befor , @Param("after")int after,@Param("belongId")int belongId);
         int selectCount(@Param("belongId")int belongId);
         
         int updateVisiorAction(@Param("visitorId")String visitorId ,@Param("action") int action,@Param("belongId")int belongId);
         int  insertBlackList(@Param("visitorId")String visitorId,@Param("belongId")int belongId);
         
         int deleteBlackList(@Param("visitorId")String visitorId ,@Param("belongId")int belongId);
       
         
         List<Vistor>  getvisitorByVisitorName(@Param("visitorName")String visitorName , @Param("belongId")int belongId);
         
         
         
}
