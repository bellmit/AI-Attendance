package com.jian.ssm.service;

import java.util.List;

import com.jian.ssm.entity.Metting;
import com.jian.ssm.entity.MettingEmp;

public interface MettingService {
     int  insertMetting(Metting  metting);
     
     List<Metting>   queryMetting();
     
     int  updateMetting(Metting m);
     
     int deleteMet(int mettingId);
     
     List<Metting>    getMettingSignInfo();
     
     Metting  selectMettingById(int  mettingId);
     
     int  deleteMetSignInfo(int id);
     
     List<Metting>  selectMetting();
     
     int  insertMettingEmp(MettingEmp  me);
}
