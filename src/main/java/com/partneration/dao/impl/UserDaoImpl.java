package com.partneration.dao.impl;


import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.partneration.dao.UserDao;
import com.partneration.entity.User;
import com.partneration.utils.BaseUtils;
import com.partneration.utils.UserCache;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	//uuid获取用户
	@Override
	public User findUser(String uuid) {
		String hql = "from User u where u.uuid = ?";
		List<User> uList = find(hql, uuid);
		if (!BaseUtils.isNullOrEmpty(uList)){
			return uList.get(0);
		}
		return null;
	}

	@Override
	public User findUsrByKey(String accessKey) {
		return UserCache.get(accessKey);
	}

	@Override
	public String postUser(User user) {
		String accessKey = UUID.randomUUID().toString().replace("-", "");
		UserCache.put(accessKey, user);
		return accessKey;
	}

	@Override
	public User findUser(String email, String password) {
		String hql = "from User as u where u.email = ? and u.password = ?";
		List<User> users = find(hql, email, password);
		if (!BaseUtils.isNullOrEmpty(users)){
			return users.get(0);
		}
		return null;
	}

	@Override
	public boolean findEmail(String email) {
		String hql = "from User as u where u.email = ?";
		List<User> users = find(hql, email);
		if (BaseUtils.isNullOrEmpty(users)){
			return false;
		}
		return true;
	}

	@Override
	public List<User> validateUser(String email, String code) {
		String hql = "from User as u where u.email = ? and u.validateCode = ?";
		return find(hql, email, code);
	}

	
}
