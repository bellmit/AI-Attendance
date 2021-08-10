package com.jian.ssm.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


 
public class MD5Util {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","x","y","z" };

	public  String  md5(String  change_befer  , String  encoding ) throws UnsupportedEncodingException{
		String  result = null ;
		
		
		try {
			result = change_befer ;
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			 
            messageDigest.update(result.getBytes(encoding));
       
            result = byteArrayToHexString(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		
		return result  ;
	}
	
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte tem : bytes) {
            stringBuilder.append(byteToHexString(tem));
        }
        return stringBuilder.toString();
    }
  
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

}
