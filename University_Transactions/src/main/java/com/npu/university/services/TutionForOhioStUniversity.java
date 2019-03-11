package com.npu.university.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.npu.university.domain.Course;
import com.npu.university.domain.Student;

/*
 * TuitionCalculator for Ohio State University:
1. For undergraduate students the cost is $100 per course unit; for graduate students the cost is
$120 per course unit
2. An extra $50 “lab fee” is added to every course from the Chemistry department
3. A 10% surcharge is added to the above cost for international students 

 */

public class TutionForOhioStUniversity implements TutionCalculatorService{

	double costPerUnit;
	double totalFees;
	
	public double computeTution(Student student, List<Course> courses) {
		
		int totalUnits = 0;
		
		for(Course course:courses){
			totalUnits = totalUnits  + course.getUnits();
		}
		
		
		if(student.isGraduate())
		{
			costPerUnit = 120;
		}
		else
			costPerUnit = 100;
		
		totalFees = totalUnits * costPerUnit;
		
		for(Course course:courses){
		     if(course.getDeptName() == "Chemistry"){
		    	 totalFees = totalFees + 50;
		    }
		}
		
		if(student.isIntlStudent()){
			totalFees = totalFees + (totalFees * (10 /100));
		}
		return totalFees;
	}

}
