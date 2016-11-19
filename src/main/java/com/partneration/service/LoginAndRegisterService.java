package com.partneration.service;

import com.partneration.entity.User;

/**
 * 登陆与注册
 * @author John
 *
 */
public interface LoginAndRegisterService {
	
	/**
	 * 用户登陆
	 * @param email
	 * @param password
	 * @return 登陆成功返回accessKey，失败返回null
 	 */
	public String login(String email, String password);
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public boolean register(User user);
	
	/**
	 * 邮箱是否已经注册
	 * @param email
	 * @return
	 */
	public boolean existEmail(String email);
	
	/**
	 * 邮箱验证
	 * @param email
	 * @param code
	 * @return
	 */
	public boolean validateEmail(String email, String code);

}
