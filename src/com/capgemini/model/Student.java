package com.capgemini.model;

public class Student {
	private int rollNum;
	private String name;
	private String[] courses;

	/*
	 * public Student(int rollNum, String name, String[] courses) { super();
	 * this.rollNum = rollNum; this.name = name; this.courses = courses; }
	 */
	public int getRollNum() {
		return rollNum;
	}
	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	

}
