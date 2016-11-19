package com.partneration.json;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class LoginJson {

	@NotNull
	@Email(message = "�����ʽ����")
	private String email;
	
	@NotNull(message = "���벻��Ϊ��")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
