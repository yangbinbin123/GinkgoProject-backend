package com.partneration.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partneration.dao.UserDao;
import com.partneration.entity.User;
import com.partneration.service.UserService;

/**
 * 用户信息维护
 * @author John
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	//根据用户uuid获取用户信息
	@Override
	public User getUser(String uuid) {
		return userDao.findUser(uuid);
	}

	//accessKey获取用户
	@Override
	public User getUserByKey(String accessKey) {
		return userDao.findUsrByKey(accessKey);
	}

}
