package com.partneration.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partneration.dao.UserDao;
import com.partneration.entity.User;
import com.partneration.service.UserService;

/**
 * �û���Ϣά��
 * @author John
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	//�����û�uuid��ȡ�û���Ϣ
	@Override
	public User getUser(String uuid) {
		return userDao.findUser(uuid);
	}

	//accessKey��ȡ�û�
	@Override
	public User getUserByKey(String accessKey) {
		return userDao.findUsrByKey(accessKey);
	}

}
