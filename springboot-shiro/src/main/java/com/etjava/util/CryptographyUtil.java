package com.etjava.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author Administrator
 *
 */
public class CryptographyUtil {

	
	/**
	 * Md5加密
	 * @param str
	 * @param salt
	 * @return
	 */
	public static String md5(String str,String salt){
		return new Md5Hash(str,salt).toString();
	}
	
	public static void main(String[] args) {
		String password="123456";
		
		System.out.println("Md5:"+CryptographyUtil.md5(password, "etjava"));
	}
}