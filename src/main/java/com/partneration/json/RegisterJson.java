package com.partneration.json;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class RegisterJson {

	@NotNull(message = "学号或职工号不能为空")
	private String userId;
	
	@NotNull(message = "密码不能为空")
	private String password;
	
	@NotNull(message = "邮箱不能为空")
	@Email(message = "邮箱格式不正确")
	private String email;
	
	@NotNull(message = "姓名不能为空")
	private String name;
	
	@NotNull(message = "电话号码不能为空")
	private String phoneNum;
	
	//@NotNull(message = "学校不能为空")
	private String school;
	
	//@NotNull(message = "学院不能为空")
	private String college;
	
	//@NotNull(message = "专业不能为空")
	private String specialty;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
}
