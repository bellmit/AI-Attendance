package com.jian.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jian.ssm.entity.CheckOut;
import com.jian.ssm.entity.VisitInfo;

public interface VisitInfoDao {
         int  insertVisitInfo(@Param("visitId")String visitId ,
        		              @Param("employeeId") int employeeId,
        		              @Param("visitorId") String visitorId,
        		              @Param("visitorName") String visitorName,
        		              @Param("reasonId") int reasonId,
        		              @Param("cameraPhoto") byte[] cameraPhoto,
        		              @Param("checkInDeviceId") String checkInDeviceId ,
        		              @Param("checkInTime")long checkInTime ,
        		              @Param("checkOutDeviceId")String checkOutDeviceId ,
        		              @Param("checkOutTime") long checkOutTime ,
        		              @Param("state") int state ,
        		              @Param("comment")String comment ,
        		              @Param("action") int action,
        		              @Param("version") long version,
        		              @Param("belongId")int belongId ,
        		              @Param("employeeName")String employeeName);
         
         List<VisitInfo>  selectViditInfos(@Param("version")long version ,@Param("checkInDeviceId")String checkInDeviceId,@Param("belongId")int belongId);
         
         List<VisitInfo>  selectVisit(@Param("befor")int befor , @Param("after")int after ,@Param("belongId")int belongId);
         
         int   selectCount(@Param("belongId")int belongId);
         
         
         VisitInfo  selectVisitInfo(@Param("visitId")String visitId ,@Param("belongId")int belongId);
         /*
          * 数据重载
          */
         List<VisitInfo> VisitReloadByVisitorName(@Param("visitorName")String visitorName,@Param("befor")int befor , @Param("after")int after ,@Param("belongId")int belongId);
         List<VisitInfo> VisitReloadByEmployeeName(@Param("employeeName")String employeeName,@Param("befor")int befor , @Param("after")int after,@Param("belongId")int belongId);
         List<VisitInfo>  VisitReloadCheckInDevice(@Param("checkInDevice")String checkInDevice ,@Param("befor")int befor , @Param("after")int after,@Param("belongId")int belongId);
         List<VisitInfo>  VisitReloadCheckOutDevice(@Param("checkOutDevice")String checkOutDevice,@Param("befor")int befor , @Param("after")int after,@Param("belongId")int belongId);
         
         int deleteVisitInfo(@Param("visitId")String visitId ,@Param("belongId")int belongId);
         
         VisitInfo  getAcameraPhoto(@Param("visitorId")String visitorId);
         
         int  CheckOutUpdate(@Param("co")CheckOut co );
}
