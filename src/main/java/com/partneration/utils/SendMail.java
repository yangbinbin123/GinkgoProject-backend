package com.partneration.utils;

import io.jstack.sendcloud4j.SendCloud;
import io.jstack.sendcloud4j.mail.Email;
import io.jstack.sendcloud4j.mail.Result;
import io.jstack.sendcloud4j.mail.Substitution;

public class SendMail {

	private static String apiUser = "partneration_user";
	private static String apiKey = "guNNme1CViXOqQhC";
	
	public static Result sendActiviteMailByTemplate(String name, String url, String mail){
		
		SendCloud webapi = SendCloud.createWebApi(apiUser, apiKey);
	
		@SuppressWarnings("rawtypes")
		Email email = Email.template("template_active_pic")
			    .from("partneration@sjhappy.cn")
			    .fromName("partneartion团队")
			    .substitutionVars(Substitution.sub()  // 模板变量替换
			            .set("name", name)
			            .set("url", url))
			    .to(mail);
		
		return webapi.mail().send(email);
	}
	
	
}
