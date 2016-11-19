package com.partneration.service;

import java.util.List;

import com.partneration.entity.Team;
import com.partneration.entity.User;

/**
 * �Ŷӷ�����
 * @author John
 *
 */
public interface TeamService {

	/**
	 * ��ȡ���е��Ŷ�(1���Ҵ����ġ�2���Ҳμӵģ�
	 * @param uuid �û���UUID
	 * @param status 1��ʾ�Ҵ������Ŷӣ�2��ʾ�Ҳμӵ��Ŷ�
	 * @return �Ŷӵ�List
	 */
	public List<Team> getTeams(String uuid, int status);
	
	/**
	 * �Ŷ�Id��ȡ�Ŷ���Ϣ
	 * @param teamId
	 * @return
	 */
	public Team getTeam(int teamId);
	
	/**
	 * ����һ�����Ŷ�
	 * @param user ������
	 * @param name �Ŷ�����
	 * @param description �Ŷ�����
	 * @param canGroup �Ƿ������
	 * @return �µ��Ŷ�
	 */
	public Team createTeam(User user, String name, String description, int canGroup);
}
