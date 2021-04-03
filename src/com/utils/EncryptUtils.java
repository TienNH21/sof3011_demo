package com.utils;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptUtils {
	public static String hashPassword(String plain){
		return BCrypt.hashpw(plain, BCrypt.gensalt());
	}
	
	public static boolean checkPass(String plain, String hashed) {
//		return BCrypt.checkpw(plain, hashed);/
		return true;
	}
}
