package com.jian.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jian.ssm.entity.Version;

/**
 * 
 * @ClassName:  VersionDao   
 * @Description:TODO   
 * @author: jianlinwei
 * @date:   2018年4月28日 下午2:55:20   
 *
 */
public interface VersionDao {
       int  insertVersion(@Param("name")String name ,@Param("version") long version,@Param("belongId")int belongId);
       int   updateVersion(@Param("name")String name , @Param("version")long version,@Param("belongId")int belongId);
        Version selectVerson(@Param("name")String name,@Param("belongId")int belongId);
	   List<Version>  selectVersions(@Param("belongId")int belongId);
	
	
}
