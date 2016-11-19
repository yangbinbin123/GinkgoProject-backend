package com.partneration.service.impl;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.partneration.entity.College;
import com.partneration.service.LoginAndRegisterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/*.xml")
public class TestLoginAndRegister {

	@Autowired
	private LoginAndRegisterService loginAndRegisterService;
	

}
