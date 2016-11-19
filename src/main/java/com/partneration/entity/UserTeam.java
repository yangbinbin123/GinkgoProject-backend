package com.partneration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * �û��μ��Ŷӱ�
 * @author John
 *
 */
@Entity
@Table(name = "user_team")
public class UserTeam implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uTeam_id")
	private int userTeamId;

	//���ŶӶ�Ӧ���û�
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "uuid", referencedColumnName = "uuid")
	private User user;
	
	//�ó�Ա��Ӧ��һ���Ŷ�
	@ManyToOne(targetEntity = Team.class)
	@JoinColumn(name = "team_id", referencedColumnName = "team_id")
	private Team team;

	public int getUserTeamId() {
		return userTeamId;
	}

	public void setUserTeamId(int userTeamId) {
		this.userTeamId = userTeamId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
}
