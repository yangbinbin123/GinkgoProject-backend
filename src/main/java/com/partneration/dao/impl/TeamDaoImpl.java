package com.partneration.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.partneration.dao.TeamDao;
import com.partneration.entity.Team;

/**
 * 团队相关的Dao类
 * @author John
 *
 */
@Repository("teamDao")
public class TeamDaoImpl extends BaseDaoImpl<Team> implements TeamDao {

	@Override
	public List<Team> findTeams(String uuid) {
		String hql = "from Team as t where t.user.uuid = ? order by t.teamCreatedTime desc";
		return find(hql, uuid);
	}


	//团队Id获取团队
	@Override
	public List<Team> findTeam(int teamId) {
		String hql = "from Team as t where t.teamId = ?";
		return find(hql, teamId);
	}

	
}
