package com.partneration.dao;

import java.util.List;

import com.partneration.entity.User;

/**
 * �û���Dao
 * @author John
 *
 */
public interface UserDao extends BaseDao<User> {

	/**
	 * uuid��ȡ�û�
	 * @param uuid
	 * @return
	 */
	public User findUser(String uuid);
	
	/**
	 * @param accessKey
	 * @return
	 */
	public User findUsrByKey(String accessKey);
	
	/**
	 * ����һ���û�
	 * @param user
	 * @return
	 */
	public String postUser(User user);
	
	/**
	 * ��������������ȡ�û�
	 * @param email
	 * @param password
	 * @return
	 */
	public User findUser(String email, String password);
	
	/**
	 * �����Ƿ����
	 * @param email
	 * @return
	 */
	public boolean findEmail(String email);
	
	/**
	 * ��֤����
	 * @param email
	 * @param code
	 * @return
	 */
	public List<User> validateUser(String email, String code);
}
