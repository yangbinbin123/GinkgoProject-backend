package com.partneration.service;

import com.partneration.entity.User;

/**
 * ��½��ע��
 * @author John
 *
 */
public interface LoginAndRegisterService {
	
	/**
	 * �û���½
	 * @param email
	 * @param password
	 * @return ��½�ɹ�����accessKey��ʧ�ܷ���null
 	 */
	public String login(String email, String password);
	
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	public boolean register(User user);
	
	/**
	 * �����Ƿ��Ѿ�ע��
	 * @param email
	 * @return
	 */
	public boolean existEmail(String email);
	
	/**
	 * ������֤
	 * @param email
	 * @param code
	 * @return
	 */
	public boolean validateEmail(String email, String code);

}
