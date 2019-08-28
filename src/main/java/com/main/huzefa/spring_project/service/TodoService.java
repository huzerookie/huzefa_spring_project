package com.main.huzefa.spring_project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.main.huzefa.spring_project.bean.Todo;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;

	static {
		todos.add(new Todo(1, "Huzefa", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "Huzefa", "Learn Struts", new Date(), false));
		todos.add(new Todo(3, "Huzefa", "Learn Hibernate", new Date(), false));
	}

	public List<Todo> retrieveTodos(String user) {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getUser().equals(user)) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public Todo retrieveSingleTodo(int id) {
		return (Todo)todos.stream().filter(c->c.getId()==id).findAny().orElse(null);
	}
	
	public boolean addTodo(String name, String desc, Date targetDate, boolean isDone) {
		Date date = new Date();
		System.out.println(targetDate+"------"+date+"------"+targetDate.compareTo(date));
		if(targetDate.compareTo(date) > 0)
			return todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
		return false;
	}

	public void deleteTodo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public void updateTodo(Todo todoNew) {
		Iterator<Todo> iterator = todos.iterator();
		System.out.println("todonew:"+todoNew);
		while (iterator.hasNext()) {
			
			if (iterator.next().getId() == todoNew.getId()) {
				iterator.remove();
				todos.add(todoNew);
				break;
				
				
			}
		}
	}
	
	
	
}
