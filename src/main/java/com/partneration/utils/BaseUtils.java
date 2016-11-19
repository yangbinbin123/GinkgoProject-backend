package com.partneration.utils;

import java.util.List;

/**
 * 基本工具類
 * @author John
 *
 */
public class BaseUtils {

	/**
	 * 判斷字符串是否為null或空
	 */
	public static boolean isNullOrEmpty(String string){
		if (string == null || string.trim().equals("")){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * 判斷List為null或空
	 */
	public static boolean isNullOrEmpty(List<?> list){
		if (list == null || list.size() == 0){
			return true;
		}
		else {
			return false;
		}
	}
}
