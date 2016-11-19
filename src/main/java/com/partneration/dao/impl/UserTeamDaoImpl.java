package com.partneration.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.partneration.dao.UserTeamDao;
import com.partneration.entity.Team;
import com.partneration.entity.UserTeam;

/**
 * 用户参加团队Dao
 * @author John
 *
 */
@Repository("userTeamDao")
public class UserTeamDaoImpl extends BaseDaoImpl<UserTeam> implements UserTeamDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Team> findJoinedTeams(String uuid) {
		String sql = "select t.* from team as t right join user_team as ut on ut.team_id = t.team_id where ut.uuid = " + uuid;
		return (List<Team>) getSessionFactory().getCurrentSession().createSQLQuery(sql).addEntity(Team.class).list();
	}


}
