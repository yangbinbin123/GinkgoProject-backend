package com.partneration.service;

import com.partneration.entity.User;

/**
 * �û�����Ϣά��
 * @author John
 *
 */
public interface UserService {
	
	/**
	 * ����uuid��ȡ�û�
	 * @param uuid 
	 * @return
	 */
	public User getUser(String uuid);

	/**
	 * ����accessKey��ȡ�û�
	 * @param accessKey
	 * @return
	 */
	public User getUserByKey(String accessKey);
}
