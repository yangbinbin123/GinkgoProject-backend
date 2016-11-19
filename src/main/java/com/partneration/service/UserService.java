package com.partneration.service;

import com.partneration.entity.User;

/**
 * 用户的信息维护
 * @author John
 *
 */
public interface UserService {
	
	/**
	 * 根据uuid获取用户
	 * @param uuid 
	 * @return
	 */
	public User getUser(String uuid);

	/**
	 * 根据accessKey获取用户
	 * @param accessKey
	 * @return
	 */
	public User getUserByKey(String accessKey);
}
