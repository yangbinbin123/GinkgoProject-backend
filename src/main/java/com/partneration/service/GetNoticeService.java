package com.partneration.service;

import java.util.List;

import com.partneration.json.NoticeJson;

public interface GetNoticeService {

	/**
	 * ��ҳ��ȡ��Ϣ
	 * @param status 1Ϊδ����2Ϊ�Ѷ���Ĭ��Ϊ1
	 * @param accessKey
	 * @param page
	 * @param perPage
	 * @return
	 */
	public List<NoticeJson> getNotice(int status, String accessKey, int page, int perPage);
}
