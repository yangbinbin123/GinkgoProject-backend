package com.partneration.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.partneration.dao.NoticeDao;
import com.partneration.entity.Notice;
import com.partneration.json.NoticeJson;

@Repository("noticeDao")
public class NoticeDaoImpl extends BaseDaoImpl<Notice>implements NoticeDao {

	@Override
	public List<NoticeJson> findNotices(String uuid, int status, int page, int perPage) {
		int start = (page - 1) * perPage;
		String sql = "select n.notice_id, n.notice_time, n.notice_content, n.notice_title, u.name from notice as n, user_notice as un, user as u " + 
				"where n.notice_id = un.notice_id and un.uuid = u.uuid and un_status = ? and un.uuid = ? ORDER BY n.notice_time desc limit ?, ?";
		
		List<?> list = getSessionFactory().getCurrentSession().createSQLQuery(sql).setInteger(0, status).setString(1, uuid)
				.setInteger(2, start).setInteger(3, perPage).list();
		
		List<NoticeJson> noticeJsons = new ArrayList<>();
		for (Object object : list) {
			Object[] notice = (Object[])object;
			NoticeJson noticeJson = new NoticeJson();
			noticeJson.setNotice_id((int)notice[0]);
			noticeJson.setTime((Date)notice[1]);
			noticeJson.setContent((String)notice[2]);
			noticeJson.setTitle((String)notice[3]);
			noticeJson.setName((String)notice[4]);
			noticeJsons.add(noticeJson);
		}
		return noticeJsons;
	}

}
