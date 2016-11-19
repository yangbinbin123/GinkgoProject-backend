package com.partneration.json;

import java.util.List;

import javax.validation.constraints.NotNull;

public class TaskJson {
	
	@NotNull(message = "�Ŷӱ�Ų���Ϊ��")
	private int groupId;
	
	@NotNull(message = "����������Ϊ��")
	private String taskName;
	private String taskDescription;
	
	@NotNull(message = "�������Ͳ���Ϊ��")
	private String taskType;
	private List<String> acceptIds;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public List<String> getAcceptIds() {
		return acceptIds;
	}
	public void setAcceptIds(List<String> acceptIds) {
		this.acceptIds = acceptIds;
	}
	
}
