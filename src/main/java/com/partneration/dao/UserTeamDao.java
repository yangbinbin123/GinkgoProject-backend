package com.partneration.dao;

import java.util.List;

import com.partneration.entity.Team;
import com.partneration.entity.UserTeam;

/**
 * �û��μӵ��Ŷ�
 * @author John
 *
 */
public interface UserTeamDao extends BaseDao<UserTeam> {


	/**
	 * ��ȡ�û��μӵ��Ŷ�
	 * @param uuid �û�Id
	 * @return
	 */
	public List<Team> findJoinedTeams(String uuid);
}
