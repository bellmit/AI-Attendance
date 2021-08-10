package com.jian.ssm.service;

import java.util.List;

import com.jian.ssm.entity.VacationDay;

public interface VacationDaysService {
     int  insertVacationDay(VacationDay  vd);
     int  deleteVacationDay(VacationDay  vd);
     List<VacationDay>  selectVacationDays(VacationDay  vd ,int befor , int after);
     int  selectVacationDaysCount(VacationDay vd);
}
