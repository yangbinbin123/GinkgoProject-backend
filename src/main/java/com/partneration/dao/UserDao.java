package com.partneration.dao;

import java.util.List;

import com.partneration.entity.User;

/**
 * 用户表Dao
 * @author John
 *
 */
public interface UserDao extends BaseDao<User> {

	/**
	 * uuid获取用户
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
	 * 缓存一个用户
	 * @param user
	 * @return
	 */
	public String postUser(User user);
	
	/**
	 * 根据邮箱和密码获取用户
	 * @param email
	 * @param password
	 * @return
	 */
	public User findUser(String email, String password);
	
	/**
	 * 邮箱是否存在
	 * @param email
	 * @return
	 */
	public boolean findEmail(String email);
	
	/**
	 * 验证邮箱
	 * @param email
	 * @param code
	 * @return
	 */
	public List<User> validateUser(String email, String code);
}
