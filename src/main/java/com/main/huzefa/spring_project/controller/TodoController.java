package com.main.huzefa.spring_project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(format,false) );
	}
	
	@RequestMapping(value = "/Add-Todo", method = RequestMethod.GET)
	public String routeAddTodo(ModelMap model) {
		model.addAttribute("todo", new Todo(0,(String)model.get("username"),"",new Date(),false));
		System.out.println(model.get("username"));
		return "add-todo";
	}

	@RequestMapping(value = "/Add-Todo", method = RequestMethod.POST)
//	public String addTodo(@RequestParam String desc, @RequestParam String datepicker, ModelMap model)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result)
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
	
	@RequestMapping(value = "/Update-Todo", method = RequestMethod.GET)
	public String updatePageTodo(Todo todo, ModelMap model){
		todo.setTargetDate(new Date());
		model.addAttribute("todo", todo);
		return "add-todo";
	}
	
	@RequestMapping(value = "/Update-Todo", method = RequestMethod.POST)
	public String updateTodoDisplay(ModelMap model, @Valid Todo todo, BindingResult result){
		System.out.println("todo.getId():"+todo.getId());
		todo.setUser((String)model.get("username"));
		if(result.hasErrors())
			return "add-todo";
		todoService.updateTodo(todo);
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
