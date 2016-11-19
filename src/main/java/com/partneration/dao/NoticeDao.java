package com.partneration.dao;

import java.util.List;

import com.partneration.entity.Notice;
import com.partneration.json.NoticeJson;

public interface NoticeDao extends BaseDao<Notice> {
	
	/**
	 * 获取消息
	 * @param page
	 * @param perPage
	 * @return
	 */
	public List<NoticeJson> findNotices(String uuid, int status, int page, int perPage);

}
