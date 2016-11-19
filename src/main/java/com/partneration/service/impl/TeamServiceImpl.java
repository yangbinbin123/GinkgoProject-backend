package com.partneration.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partneration.dao.TeamDao;
import com.partneration.dao.UserDao;
import com.partneration.entity.Team;
import com.partneration.entity.User;
import com.partneration.entity.UserTeam;
import com.partneration.service.TeamService;
import com.partneration.utils.BaseUtils;

/**
 * 团队的服务类
 * @author John
 *
 */
@Service("teamService")
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamDao teamDao;
	
	@Autowired
	private UserDao userDao;

	//获取所有的团队(1：我创建的、2：我参加的）
	@Override
	public List<Team> getTeams(String uuid, int status) {
		if (status == 1){
			return teamDao.findTeams(uuid);
		} else if (status == 2){
			List<Team> teams = new ArrayList<>();
			User user = userDao.findUser(uuid);
			if (user != null){
				Set<UserTeam> userTeams = user.getUserTeam();
				for (UserTeam userTeam : userTeams) {
					teams.add(userTeam.getTeam());
				}
			}
			return teams;
		}
		return null;
	}

	// 团队Id获取团队信息
	@Override
	public Team getTeam(int teamId) {
		List<Team> teams = teamDao.findTeam(teamId);
		if (!BaseUtils.isNullOrEmpty(teams)){
			return teams.get(0);
		}
		return null;
	}

	//创建一个新团队
	@Override
	public Team createTeam(User user, String name, String description, int canGroup) {
		Team team = new Team();
		team.setCanGroup(canGroup);
		team.setTeamCreatedTime(new Date());
		team.setTeamDescription(description);
		team.setTeamName(name);
		team.setUser(user);
		teamDao.save(team);
		return team;
	}
}
