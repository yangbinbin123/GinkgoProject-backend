package com.partneration.dao;

import java.util.List;

import com.partneration.entity.Team;

/**
 * 团队的Dao接口
 * @author John
 *
 */
public interface TeamDao extends BaseDao<Team> {

	/**
	 * 获取用户创建的团队
	 * @param uuid 用户的id
	 * @return
	 */
	public List<Team> findTeams(String uuid);
	

	/**
	 * 团队Id获取团队
	 * @param teamId
	 * @return
	 */
	public List<Team> findTeam(int teamId);
}
