package com.partneration.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.partneration.entity.Team;
import com.partneration.entity.User;
import com.partneration.service.TeamService;
import com.partneration.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/*.xml")
public class TeamServiceTest {
	
	@Autowired
	private UserService userService;

	@Autowired
	private TeamService teamService;
	
	@Test
	public void testCreatedTeams() {
		List<Team> teams = teamService.getTeams("aaaaaaaaaa", 1);
		if (teams != null){
			System.out.println(teams.get(0).getTeamName());
		}
	}
	
	@Test
	public void testJoinedTeams() {
		List<Team> teams = teamService.getTeams("bbbbbb", 2);
		if (teams != null){
			System.out.println(teams.get(0).getTeamName());
		} else {
			System.out.println("没有参加任何团队");
		}
	}
	
	@Test
	public void testGetTeam() {
		Team team = teamService.getTeam(1);
		if (team != null){
			System.out.println(team.getTeamName());
		}
	}
	
	
	@Test
	public void testCreatTeam(){
		User user = userService.getUser("bbbbbb");
		teamService.createTeam(user, "计算机网络", "学网络编程了", 1);
	}
}
