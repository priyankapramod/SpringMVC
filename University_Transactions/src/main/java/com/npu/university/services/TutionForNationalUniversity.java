package com.npu.university.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.npu.university.domain.Course;
import com.npu.university.domain.Student;
/*
 * 1. For international students the cost is $500 per course unit; for other students the cost is $230
per course unit 

 */
@Component("tutionCalculatorServiceNU")
public class TutionForNationalUniversity implements TutionCalculatorService{
    double costPerUnit;
    double totalFees;
	
	public double computeTution(Student student, List<Course> courses) {
		
		
        int totalUnits = 0;
		
		for(Course course:courses){
			totalUnits = totalUnits  + course.getUnits();
		}
		
		
		if(student.isIntlStudent()){
			costPerUnit = 500;
		}
		else
			costPerUnit = 230;
		
		totalFees = totalUnits * costPerUnit;
		
		return totalFees;
	}
	

}
