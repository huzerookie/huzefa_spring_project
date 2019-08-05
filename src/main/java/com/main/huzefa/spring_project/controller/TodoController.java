package com.main.huzefa.spring_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoController {

	
	@RequestMapping(value="/Add-Todo",method=RequestMethod.GET)
	public String routeAddTodo() {
		return "add-todo";
	}
	
	@RequestMapping(value="/Add-Todo",method=RequestMethod.POST)
	public String addTodo() {
		return "";
	}
	
}
