package com.partneration.dao;

import java.util.List;

import com.partneration.entity.Team;
import com.partneration.entity.UserTeam;

/**
 * 用户参加的团队
 * @author John
 *
 */
public interface UserTeamDao extends BaseDao<UserTeam> {


	/**
	 * 获取用户参加的团队
	 * @param uuid 用户Id
	 * @return
	 */
	public List<Team> findJoinedTeams(String uuid);
}
