package com.npu.university.domain;

import java.util.*;

/**
 * 
 * @author Priyanka
 *
 */
public class Student {
	private String name;
	private String id;
	private boolean intlStudent;
	private boolean isGraduate;
	private ArrayList<Course> courses; 
	
	public Student(String name, String id, boolean intlStudent, boolean isGraduate, ArrayList<Course> courses){
		this.name = name;
		this.id = id;
		this.intlStudent = intlStudent;
		this.isGraduate = isGraduate;
		this.courses = courses;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isIntlStudent() {
		return intlStudent;
	}

	public void setIntlStudent(boolean intlStudent) {
		this.intlStudent = intlStudent;
	}

	public boolean isGraduate() {
		return isGraduate;
	}

	public void setGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	

}
