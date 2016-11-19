package com.partneration.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.partneration.exception.ParametersException;
import com.partneration.json.TaskJson;

@Controller
public class TasksController {
	
	@RequestMapping(value = "/tasks", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8")
	public ResponseEntity<Map<String, Object>> createTask(@Valid TaskJson taskJson, BindingResult result) throws ParametersException{
		
		if (result.hasErrors()) {
			throw new ParametersException("参数不正确~", result);
		} else {
			if (taskJson.getTaskType().equals("person")){ //个人任务
				
			} else if (taskJson.getTaskType().equals("team")) { //小组任务
				
			}{
				
			}
		}
		return null;
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
