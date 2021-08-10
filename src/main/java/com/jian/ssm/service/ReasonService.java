package com.jian.ssm.service;



import java.util.List;

import com.jian.ssm.entity.Reason;

/**
 * 
 * @ClassName:  ReasonService   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年5月15日 下午12:20:32   
 *
 */
public interface ReasonService {
	Reason seleteReasonByName(String reasonName,int belongId);
    int inserRason(String reasonname ,int belongId); 
	 List<Reason>  sleteReason(int belongId);
	 int deleteReason(int reasonid ,int belongId);  
	 String  selectReasonName(int reasonid,int belongId);
}
