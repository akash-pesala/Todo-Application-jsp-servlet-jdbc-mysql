package com.java.todo.dao;

import java.util.List;

import com.java.todo.model.TodoDetails;

public interface TodocreateDao {
	List<TodoDetails> selectAll();
	TodoDetails selecttodo(int id);
	void inserttodo(TodoDetails td);
	boolean deletetodo(int id);
	boolean updatetodo(TodoDetails td);
}
