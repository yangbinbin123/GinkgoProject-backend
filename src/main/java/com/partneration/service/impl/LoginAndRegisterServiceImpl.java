package com.partneration.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partneration.dao.UserDao;
import com.partneration.entity.User;
import com.partneration.service.LoginAndRegisterService;
import com.partneration.utils.BaseUtils;
import com.partneration.utils.ConfigInfo;
import com.partneration.utils.SendMail;

import io.jstack.sendcloud4j.mail.Result;

/**
 * µÇÂ½Óë×¢²á
 * @author John
 *
 */
@Service("loginAndRegisterService")
public class LoginAndRegisterServiceImpl implements LoginAndRegisterService {

	@Autowired
	private UserDao userDao;

	@Override
	public String login(String email, String password) {
		User user = userDao.findUser(email, password);
		if (user != null){
			if (user.getStatus() == 0){
				return userDao.postUser(user);
			} else if (user.getStatus() == 1){
				return "unvalidate";
			} else if (user.getStatus() == 2){
				return "forbid";
			}
		}
		return null;
	}

	@Override
	public boolean register(User user) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		user.setUuid(uuid);
		user.setCreatedTime(new Date());
		String code = UUID.randomUUID().toString().replace("-", "");
		user.setValidateCode(code);
		user.setStatus(1);
		
		userDao.save(user);
		
		StringBuilder url = new StringBuilder();
		url.append(ConfigInfo.hostUrl+"/partneration/verification?email=");
		url.append(user.getEmail());
		url.append("&code=");
		url.append(code);
		
		Result result = SendMail.sendActiviteMailByTemplate(user.getName(), url.toString(), user.getEmail());
		if (result.getStatusCode() == 200){
			return true;
		}
		System.out.println("ÓÊ¼þ·¢ËÍ´íÎó£º"+result.getMessage());
		return false;
	}

	@Override
	public boolean existEmail(String email) {
		return userDao.findEmail(email);
	}

	@Override
	public boolean validateEmail(String email, String code) {
		
		List<User> users = userDao.validateUser(email, code);
		if (!BaseUtils.isNullOrEmpty(users)){
			User user = users.get(0);
			user.setStatus(0);
			return true;
		} else {
			return false;
		}
	}
	
	
}
