package com.partneration.controller;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.partneration.json.NoticeJson;

@Controller
@RequestMapping(value = "/notifications")
public class NoticeController {
	
	

	//获取通知列表
	@RequestMapping(method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody List<NoticeJson> getNotices(){
		
		return null;
	}
}
