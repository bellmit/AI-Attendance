package com.jian.ssm.service;



import java.util.List;

import com.jian.ssm.entity.Version;

public interface VersionService {
	 int  insertVersion(String name , long version,int belongId);
     int   updateVersion(String name ,long version,int belongId);
      Version selectVerson(String name,int belongId);
      List<Version>   selectVersions(int belongId);
}
