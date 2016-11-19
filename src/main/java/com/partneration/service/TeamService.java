package com.partneration.service;

import java.util.List;

import com.partneration.entity.Team;
import com.partneration.entity.User;

/**
 * 团队服务类
 * @author John
 *
 */
public interface TeamService {

	/**
	 * 获取所有的团队(1：我创建的、2：我参加的）
	 * @param uuid 用户的UUID
	 * @param status 1表示我创建的团队，2表示我参加的团队
	 * @return 团队的List
	 */
	public List<Team> getTeams(String uuid, int status);
	
	/**
	 * 团队Id获取团队信息
	 * @param teamId
	 * @return
	 */
	public Team getTeam(int teamId);
	
	/**
	 * 创建一个新团队
	 * @param user 创建者
	 * @param name 团队名称
	 * @param description 团队描述
	 * @param canGroup 是否能组队
	 * @return 新的团队
	 */
	public Team createTeam(User user, String name, String description, int canGroup);
}
