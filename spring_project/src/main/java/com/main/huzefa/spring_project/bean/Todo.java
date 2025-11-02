package com.main.huzefa.spring_project.bean;

import java.time.LocalDate;

public class Todo {
	private int id;
	private String course;
	private String candidateName;
	private LocalDate deadline;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public LocalDate getDeadline() {
		return deadline;
	}
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
	public Todo(int id, String course, String candidateName, LocalDate deadline) {
		super();
		this.id = id;
		this.course = course;
		this.candidateName = candidateName;
		this.deadline = deadline;
	}
	
}
