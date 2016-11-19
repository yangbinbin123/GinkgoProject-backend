package com.partneration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partneration.dao.NoticeDao;
import com.partneration.dao.UserDao;
import com.partneration.entity.User;
import com.partneration.json.NoticeJson;
import com.partneration.service.GetNoticeService;

/**
 * 通知消息
 * @author John
 *
 */
@Service("getNoticeService")
public class GetNoticeServiceImpl implements GetNoticeService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public List<NoticeJson> getNotice(int status, String accessKey, int page, int perPage) {
		User user = userDao.findUsrByKey(accessKey);
		return noticeDao.findNotices(user.getUuid(), status, page, perPage);
	}

}
