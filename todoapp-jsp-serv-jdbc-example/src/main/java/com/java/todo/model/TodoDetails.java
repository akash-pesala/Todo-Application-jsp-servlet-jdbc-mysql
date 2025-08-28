package com.java.todo.model;

import java.time.LocalDate;

public class TodoDetails {
	private int id;
	private String title;
	private String description;
	private LocalDate targetDate;
	private boolean status;
	public TodoDetails(int id, String title, String description, LocalDate targetDate, boolean status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.targetDate = targetDate;
		this.status = status;
	}
	public TodoDetails(String title, String description, LocalDate targetDate, boolean status) {
		super();
		this.title = title;
		this.description = description;
		this.targetDate = targetDate;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
