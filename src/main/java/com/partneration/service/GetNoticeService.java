package com.partneration.service;

import java.util.List;

import com.partneration.json.NoticeJson;

public interface GetNoticeService {

	/**
	 * 分页获取信息
	 * @param status 1为未读，2为已读。默认为1
	 * @param accessKey
	 * @param page
	 * @param perPage
	 * @return
	 */
	public List<NoticeJson> getNotice(int status, String accessKey, int page, int perPage);
}
