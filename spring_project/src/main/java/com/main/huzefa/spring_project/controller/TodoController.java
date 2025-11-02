package com.main.huzefa.spring_project.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.main.huzefa.spring_project.bean.Todo;
import com.main.huzefa.spring_project.service.TodoService;

@RestController
@RequestMapping("/api/courses")
public class TodoController {
	private TodoService todoService;
	public TodoController(TodoService todoService) {
		this.todoService=todoService;
	}
	
	
	public ResponseEntity<List<Todo>> findAllTodo(){
		return ResponseEntity.ok(todoService.findAllTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Todo> findSingleTodo(@PathVariable int id){
		return ResponseEntity.ok(todoService.findTodoById(id));
	}
	
	public ResponseEntity<Todo> addTodo(@RequestBody Todo todo){
		Todo newTodo = todoService.addTodo(todo);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newTodo.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable int id){
		todoService.deleteTodo(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Todo> updateTodoById(@RequestBody Todo todo){
		return ResponseEntity.ok(todoService.updateTodo(todo));
	}
	
}
