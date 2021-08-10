package com.jian.ssm.util;

import java.text.SimpleDateFormat;


/**
 * 
 * @ClassName:  RandomTimeUtil   
 * @Description:TODO   
 * @author: JianLinWei
 * @date:   2018年9月6日 下午1:48:23   
 *
 */
public class RandomTimeUtil {
         
	
	 public static String  upWorkDate_new(String uPwork){
		 String new_str = null ;
		 try{
		 SimpleDateFormat  format  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         SimpleDateFormat  format2 = new SimpleDateFormat("yyyy-MM-dd");	
         String[] newTime ={" 08:29:30", " 08:08:10" ," 08:23:00" ," 08:15:34" ," 08:22:34" ," 08:02:22" ," 08:45:20",
        		         " 08:34:12" ," 08:18:23" ," 08:10:05"};
         int ran  = (int) (Math.random()*10);
         new_str =  format2.format(format.parse(uPwork)) + newTime[ran];
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return new_str;
	 }
	 
	 
	 public static String downWorkDate_new(String downWork){
		 String new_str = null ;
		 try{
		 SimpleDateFormat  format  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         SimpleDateFormat  format2 = new SimpleDateFormat("yyyy-MM-dd");	
         String[] newTime ={" 18:29:30", " 18:08:10" ," 18:23:00" ," 18:15:34" ," 18:22:34" ," 18:02:22" ," 18:45:20",
        		         " 18:34:12" ," 18:18:23" ," 18:10:05"};
         int ran  = (int) (Math.random()*10);
         new_str =  format2.format(format.parse(downWork)) + newTime[ran];
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return new_str;
	 }
}
