package com.partneration.dao;

import java.util.List;

import com.partneration.entity.Team;

/**
 * �Ŷӵ�Dao�ӿ�
 * @author John
 *
 */
public interface TeamDao extends BaseDao<Team> {

	/**
	 * ��ȡ�û��������Ŷ�
	 * @param uuid �û���id
	 * @return
	 */
	public List<Team> findTeams(String uuid);
	

	/**
	 * �Ŷ�Id��ȡ�Ŷ�
	 * @param teamId
	 * @return
	 */
	public List<Team> findTeam(int teamId);
}
