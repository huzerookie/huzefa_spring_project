package com.main.huzefa.spring_project.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.main.huzefa.spring_project.bean.Todo;

@Service
	public class TodoService {
	    private static List<Todo> todos = new ArrayList<Todo>();
	    private static int todoCount = 0;

	    static {
	    	IntStream.range(0, 10).forEach(e->todos.add(new Todo(++todoCount,  "Learn Spring MVC", "Huzefa",LocalDate.now().plusYears(e).toString())));
	    }

	    public List<Todo> findAllTodos() {
	    	return todos;
	    }

	    public Todo addTodo(Todo todo) {
	    	todo.setId(++todoCount);
	        todos.add(todo);
	        System.out.println(todo.toString());
	        return todo;
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
	    
	    public Todo findTodoById(int id) {
	    	return todos.stream().filter(e->e.getId()==id).findFirst().orElse(null);
	    }
	    
	    public Todo updateTodo(Todo todo) {
	    	Todo oldTodo = findTodoById(todo.getId());
	    	if(oldTodo == null) {
	    		return null;
	    	}
	    	todos.remove(oldTodo);
	    	todos.add(todo);
	    	return todo;
	    }
	}
