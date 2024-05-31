package com.felipeazsantos.springboot.todowebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "felipe", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "felipe", "Learn DevOps", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "felipe", "Learn Full Stack Development", LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findByUsername(String username) {
		return todos.stream().filter(todo -> todo.getUsername().equalsIgnoreCase(username)).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, Boolean done) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}
	
	public void deleteTodo(Integer id) {
		todos.removeIf(todo -> todo.getId().equals(id));
	}
	
	public Todo findById(Integer id) {
		return todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
	}
	
	public void updateTodo(@Valid Todo todo) {
		deleteTodo(todo.getId());
		todos.add(todo);
	}
	
}
