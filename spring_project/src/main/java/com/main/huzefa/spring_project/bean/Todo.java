package com.main.huzefa.spring_project.bean;

public class Todo {
	private int id;
	private String course;
	private String candidateName;
	private String deadline;
	
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public Todo(int id, String course, String candidateName, String deadline) {
		super();
		this.id = id;
		this.course = course;
		this.candidateName = candidateName;
		this.deadline = deadline;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", course=" + course + ", candidateName=" + candidateName + ", deadline=" + deadline
				+ "]";
	}
	
	
}
