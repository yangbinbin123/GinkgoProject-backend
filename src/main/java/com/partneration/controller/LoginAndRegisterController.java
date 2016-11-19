package com.partneration.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.partneration.entity.User;
import com.partneration.exception.ParametersException;
import com.partneration.json.LoginJson;
import com.partneration.json.RegisterJson;
import com.partneration.service.LoginAndRegisterService;
import com.partneration.utils.ConfigInfo;

@Controller
public class LoginAndRegisterController {
	
	@Autowired
	private LoginAndRegisterService loginAndRegisterService;

	//用户登陆
	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> login(@Valid LoginJson loginJson, BindingResult result) 
			throws ParametersException{
		System.err.println("parameters:" + loginJson.getPassword()+"  "+loginJson.getEmail());
		Map<String, Object> map = new HashMap<>();
		
		if (result.hasErrors()){
			throw new ParametersException("参数不正确~", result);
		} else {
			if (!loginAndRegisterService.existEmail(loginJson.getEmail())){
				map.put("message", "该账号还未注册~");
			} else {
				String accessKey = loginAndRegisterService.login(loginJson.getEmail(), loginJson.getPassword());
				if (accessKey != null){
					if (accessKey.equals("unvalidate")){
						map.put("message", "请验证邮箱~");
					} else if (accessKey.equals("forbid")){
						map.put("message", "该用户已被禁用~");
					} else {
						map.put("access_key", accessKey);
					}
				}  
				else {
					map.put("message", "密码错误~");
				}
			}
		}
		return map;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> register(@Valid RegisterJson registerJson, BindingResult result) throws ParametersException{
		
		System.err.println(registerJson.getEmail());
		
		if (result.hasErrors()){
			throw new ParametersException();
		} else {
			User user = new User();
			
			user.setCollege(registerJson.getCollege());
			user.setEmail(registerJson.getEmail());
			user.setName(registerJson.getName());
			user.setPassword(registerJson.getPassword());
			user.setPhoneNum(registerJson.getPassword());
			user.setSchool(registerJson.getSchool());
			user.setSpecialty(registerJson.getSpecialty());
			user.setUserId(registerJson.getUserId());
			
			System.err.println(user.getPassword());
			System.err.println(user.getEmail());
			if (loginAndRegisterService.register(user)){
				return new ResponseEntity<>(null, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}
	}
	
	@RequestMapping(value = "/verification", method = RequestMethod.GET)
	public  void verification(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=utf8");
		PrintWriter out = response.getWriter();
		
		if (!email.trim().equals("") && !code.trim().equals("") && loginAndRegisterService.existEmail(email)){
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("<!DOCTYPE html><html><head><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>");
			stringBuilder.append("<link href=\"http://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\"><link rel=\"stylesheet\" href=\""+ConfigInfo.hostUrl+"/css/materialize.min.css\">");
			stringBuilder.append("<script src=\"http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js\"></script>");
			stringBuilder.append("<script src=\""+ConfigInfo.hostUrl+"/js/materialize.min.js\"></script></head>");
			stringBuilder.append("<body><div class=\"container\"><h3 class=\"header\"><font face=\"verdana\" color=\"grey\"><img src=\""+ConfigInfo.hostUrl+"/images/7.png\" />Partneration(伙伴任务管理系统)</font></h3>");
			stringBuilder.append("<div class=\"divider\"></div><div class=\"content\">");
   
			if (loginAndRegisterService.validateEmail(email, code)){
				stringBuilder.append("<p class=\"flow-text\">激活成功！</p>");
			} else {
				stringBuilder.append("<p class=\"flow-text\">激活失败！</p>");
			}
			
			stringBuilder.append("</div><div><a class=\"waves-effect waves-light btn\" href=\""+ConfigInfo.hostUrl+"/index.html\">确认</a></div></div>");
			stringBuilder.append("<script type=\"text/javascript\">$('.carousel.carousel-slider').carousel({full_width: true});");
			stringBuilder.append("$(\'.parallax\').parallax(); $(\'.modal-trigger\').leanModal(); $(\'select\').material_select();");
			stringBuilder.append("</script> </body></html>");
			
			out.write(stringBuilder.toString());
			response.getWriter().flush();
			response.getWriter().close();
		}
	}
	
	
	//参数错误
	@ExceptionHandler(ParametersException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody Map<String, Object> ParametersError(ParametersException parametersException){
		Map<String, Object> map = new HashMap<>();
		map.put("message", parametersException.getResult().getAllErrors());
		return map;
	}
}
