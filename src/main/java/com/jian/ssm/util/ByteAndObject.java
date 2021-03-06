package com.jian.ssm.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ByteAndObject {
	    /**
	     * 对象转Byte数组
	     * @param obj
	     * @return
	     */
	    public static byte[] objectToByteArray(Object obj) {
	        byte[] bytes = null;
	        ByteArrayOutputStream byteArrayOutputStream = null;
	        ObjectOutputStream objectOutputStream = null;
	        try {
	            byteArrayOutputStream = new ByteArrayOutputStream();
	            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
	            objectOutputStream.writeObject(obj);
	            objectOutputStream.flush();
	            bytes = byteArrayOutputStream.toByteArray();

	        } catch (IOException e) {
	          e.getMessage();
	        } finally {
	            if (objectOutputStream != null) {
	                try {
	                    objectOutputStream.close();
	                } catch (IOException e) {
	                    e.getMessage();
	                }
	            }
	            if (byteArrayOutputStream != null) {
	                try {
	                    byteArrayOutputStream.close();
	                } catch (IOException e) {
	                  e.getMessage();
	                }
	            }

	        }
	        return bytes;
	    }

	    /**
	     * Byte数组转对象
	     * @param bytes
	     * @return
	     */
	    public static Object byteArrayToObject(byte[] bytes) {
	        Object obj = null;
	        ByteArrayInputStream byteArrayInputStream = null;
	        ObjectInputStream objectInputStream = null;
	        try {
	            byteArrayInputStream = new ByteArrayInputStream(bytes);
	            objectInputStream = new ObjectInputStream(byteArrayInputStream);
	            obj = objectInputStream.readObject();
	        } catch (Exception e) {
	           e.getMessage();
	        } finally {
	            if (byteArrayInputStream != null) {
	                try {
	                    byteArrayInputStream.close();
	                } catch (IOException e) {
	                  e.getMessage();
	                }
	            }
	            if (objectInputStream != null) {
	                try {
	                    objectInputStream.close();
	                } catch (IOException e) {
	                   e.getMessage();
	                }
	            }
	        }
	        return obj;
	    }


}
