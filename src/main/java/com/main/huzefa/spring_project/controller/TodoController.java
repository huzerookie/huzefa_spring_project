package com.main.huzefa.spring_project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.main.huzefa.spring_project.service.TodoService;

@Controller
@SessionAttributes({"username","message"})
public class TodoController {
	
	@Autowired
	TodoService todoService;

	@RequestMapping(value = "/Add-Todo", method = RequestMethod.GET)
	public String routeAddTodo(ModelMap model) {
		System.out.println(model.get("username"));
		return "add-todo";
	}

	@RequestMapping(value = "/Add-Todo", method = RequestMethod.POST)
	public String addTodo(@RequestParam String desc, @RequestParam String datepicker, ModelMap model)
			throws ParseException {
		System.out.println("In addtodo post method:\ndesc:" + desc + "----" + "date:" + datepicker);
		todoService.addTodo((String) model.get("username"), desc, new SimpleDateFormat("MM/dd/yyyy").parse(datepicker),false); 
			model.put((String) model.get("message"), "");
			System.out.println("Todo Added Successfully");
			System.out.println(todoService.retrieveTodos((String) model.get("username")));
			return "todo-added";
	}
	
	@RequestMapping(value = "/Display-All-Todos", method = RequestMethod.GET)
	public String displayTodo(ModelMap model){
		
		model.put("todoList",todoService.retrieveTodos((String)model.get("username")));
		return "display-todo";
	}
	
	

	@RequestMapping("/home")
	public String routeHome(ModelMap model) {
		if(model.get("username")==null||((String) model.get("username")).isEmpty()) {
		System.out.println(model.get("username"));
		return "index_wname";
		}
		return "index";
	}
	

}
