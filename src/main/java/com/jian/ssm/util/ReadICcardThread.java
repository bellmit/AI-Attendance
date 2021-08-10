package com.jian.ssm.util;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import java.util.List;


import com.jian.ssm.entity.Attence;
import com.jian.ssm.entity.Employee;
import com.jian.ssm.service.AttenceService;
import com.jian.ssm.service.EmployeeService;
import com.ygwit.DoorController.ControlParam;
import com.ygwit.DoorController.IController;
import com.ygwit.DoorController.Privilige;
import com.ygwit.DoorController.Record;

@SuppressWarnings(value = { "unused" })  
public class ReadICcardThread implements Runnable {
	private AttenceService as;
	private EmployeeService es;
	
	public   ReadICcardThread(AttenceService as ,EmployeeService es){
		this.as = as;
		this.es = es ;
	}
	
	
	static int itcount = 1;
	// 1. 搜索控制器
	static List<IController> ctrls = IController.Search(IController.CONCTROLLER_YG);
	/*static List<IController> ctrls = YGController.Search();*/
	static Boolean falg = true;
	static IController _controller = null;
	
	@Override
	public void run() {
		
		boolean readCard = true;
		int recordIndex = 0;
		Record rec = null;
		for(IController c : ctrls){
		if (c.Version.compareTo("1.2.2.42") == 0 || c.SerialNo == 1101448233) {
	
			_controller = c;
		}
		}
		_controller.SetTime(Calendar.getInstance());
		while (falg) {
			try {
				Thread.sleep(2000);
				rec = _controller.GetStatus();
				
				// 记录类型为 1=刷卡记录， 2=按钮开门 3=报警记录 4=旋钮开门 5=密码开门
				if (recordIndex == rec.RecIndex) {
					continue;
				}
				if (readCard) {
					if (rec != null && rec.Type == 1) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						/*System.out.println(MessageFormat.format(" 卡号:{0}, 时间:{1},", rec.CardNo,sdf.format(rec.Time.getTime())));*/
						Attence  at  =new Attence();
						String iccard = String.format("%010d", rec.CardNo);
					Employee  emp =	es.selectEmpByICcard(iccard);
					at.setEmployeeId(emp.getId());
					at.setName(emp.getName());
					at.setWorkDate(sdf.parse(sdf.format(rec.Time.getTime())));
					int  count = as.selectAttenceCountBydate(sdf.format(at.getWorkDate()));
					if(count <= 0){
						int  x = as.insertAttence(at);
	                       if(x == 1){
	                    	   System.out.println("读卡插入成功");
	                       }
							
					}
					recordIndex = rec.RecIndex;

					}
				

				}
		
				
			} catch (Exception e) {
				e.getMessage();
			}
			
			
		}

	}

	public static  void ICAecss(String ICcard) {
		for (IController c : ctrls) {
			try {
				// 2 判断控制器版本及序列号
			/*	if (c.Version.compareTo("1.2.0.8") == 0 || c.SerialNo == 1101448233) {*/

						// 添加权限
						long cardno = Long.valueOf(ICcard);
						Privilige p = new Privilige();
						p.CardNo = cardno;
						p.BeginTime = Calendar.getInstance();
						Calendar end = Calendar.getInstance();
						end.add(Calendar.MONTH, 1);
						p.EndTime = end;
						p.DoorEnabled = 1;
						Arrays.fill(p.Password, (byte) 1);
						c.AddPrivilige(p);
						/*
						 * System.out.printf("向控制器添加权限:%#x, 结果:%b\n", cardno, bret);
						 */
						// 查询权限
						Privilige p1 = c.GetPrivilige(cardno);
						System.out.println(MessageFormat.format("控制器权限总数:{0}", c.GetPriviligeCnt()));
						/*
						 * System.out.printf("从控制器查询权限:%#x, 结果:%b, 与添加是否一致:%b\n",
						 * cardno, bret, p.Equals(p1));
						 */
						System.out.println("input ICCard"+ICcard);
					Thread.sleep(500);
			/*	} else {
					continue;
				}*/
				

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}
	/**
	 * 
	 * @Title: SetOpenDelay   
	 * @Description: TODO   
	 * @param:  
	 * @author: jianlinwei     
	 * @return: void      
	 * @throws
	 */
  public static void SetOpenDelay(int x){
	  ControlParam param = _controller.GetControlParam(1);
      param.OpenDuration = x;
	  
  }
	
  public static void SetPassword(int x){
	// 添加权限
		/*long cardno = Long.valueOf(x);
		Privilige p = new Privilige();
		p.CardNo = cardno;
		p.BeginTime = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		end.add(Calendar.MONTH, 1);
		p.EndTime = end;
		p.DoorEnabled = 1;
		_controller.AddPrivilige(p);Arrays.fill(p.Password, (byte) 1);
		*/
	  com.ygwit.DoorController.Password  p  = new com.ygwit.DoorController.Password() ;
	  p.workNo = 0 ;
	  p.count = 32767 ;
	  p.passwd = x ;
	  p.type = 0 ;
	  boolean  f  = false ;
	  if (_controller !=null){
		 f = _controller.SetPasswd(p);
	  }
	  if(f == true){
		  System.out.println("设置开门密码成功");
	  }else{
		  System.out.println("设置开门密码成功");
	  }
	  
	  
  }
}
