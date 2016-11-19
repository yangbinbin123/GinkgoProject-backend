package com.partneration.utils;

import java.util.List;

/**
 * ���������
 * @author John
 *
 */
public class BaseUtils {

	/**
	 * �Д��ַ����Ƿ��null���
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
	 * �Д�List��null���
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
