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
 * �Ŷӵķ�����
 * @author John
 *
 */
@Service("teamService")
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamDao teamDao;
	
	@Autowired
	private UserDao userDao;

	//��ȡ���е��Ŷ�(1���Ҵ����ġ�2���Ҳμӵģ�
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

	// �Ŷ�Id��ȡ�Ŷ���Ϣ
	@Override
	public Team getTeam(int teamId) {
		List<Team> teams = teamDao.findTeam(teamId);
		if (!BaseUtils.isNullOrEmpty(teams)){
			return teams.get(0);
		}
		return null;
	}

	//����һ�����Ŷ�
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
