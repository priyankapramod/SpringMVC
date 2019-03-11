package com.npu.university.services;

import java.util.List;

import com.npu.university.domain.Course;
import com.npu.university.domain.Student;

public interface TutionCalculatorService {
	
	public double computeTution(Student student, List<Course> courses);
	

}
