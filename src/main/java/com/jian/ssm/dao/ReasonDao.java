package com.jian.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jian.ssm.entity.Reason;

/**
 * 
 * @ClassName:  ReasonDao   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年5月15日 下午12:07:37   
 *
 */
public interface ReasonDao {
	Reason seleteReasonByName(@Param("reasonName") String reasonName,@Param("belongId")int belongId);
     int inserRason(@Param("reasonName") String reasonname,@Param("belongId")int belongId); 
	List<Reason>   sleteReason(@Param("belongId")int belongId);
	 int deleteReason(@Param("reasonId")int reasonid,@Param("belongId")int belongId);
	 String  selectReasonName(@Param("reasonId")int reasonid,@Param("belongId")int belongId);
}
