package com.main.huzefa.spring_project.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.main.huzefa.spring_project.bean.Todo;
import com.main.huzefa.spring_project.service.TodoService;

@Controller
@SessionAttributes({"username","message"})
public class TodoController {
	
	@Autowired
	TodoService todoService;

	@RequestMapping(value = "/Add-Todo", method = RequestMethod.GET)
	public String routeAddTodo(ModelMap model) {
		model.addAttribute("todo", new Todo(0,(String)model.get("username"),"",null,false));
		System.out.println(model.get("username"));
		return "add-todo";
	}

	@RequestMapping(value = "/Add-Todo", method = RequestMethod.POST)
//	public String addTodo(@RequestParam String desc, @RequestParam String datepicker, ModelMap model)
	public String addTodo(Todo todo, ModelMap model)
			throws ParseException {
		//System.out.println("In addtodo post method:\ndesc:" + desc + "----" + "date:" + datepicker);
		todoService.addTodo((String) model.get("username"), todo.getDesc(), todo.getTargetDate(),false); 
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
	
	@RequestMapping(value = "/Delete-Todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam String id,ModelMap model){
		todoService.deleteTodo(Integer.parseInt(id));
		return "redirect:/Display-All-Todos";
	}
	
	

	@RequestMapping("/home")
	public String routeHome(ModelMap model) {
		if(StringUtils.isEmpty(model.get("username"))) {
		System.out.println(model.get("username"));
		return "index_wname";
		}
		return "index";
	}
	
	

}
