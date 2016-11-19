package com.partneration.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.partneration.json.NoticeJson;
import com.partneration.service.GetNoticeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/*.xml")
public class TestNoticeService {

	@Autowired
	private GetNoticeService getNoticeService;
	
	@Test
	public void testGetUnread() {
		List<NoticeJson> noticeJsons = getNoticeService.getNotice(1, "", 1, 10);
		for (NoticeJson noticeJson : noticeJsons) {
			System.out.println(noticeJson.getName()+ " "+ noticeJson.getTitle());
		}
	}

}
