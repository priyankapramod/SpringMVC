package com.npu.university.domain;

import java.util.List;


public class Course {
	
	/**
	 * 
	 * @author Priyanka
	 * 
	 *
	 */
	
		private String courseName;
		private String deptName;
		private boolean isGradnotUndergrad;
		private int units;
		private int noOfStuPerCourse;
		
		public Course(String courseName, String deptName, boolean isGradnotUndergrad, int units, int noOfStuPerCourse){
			this.courseName = courseName;
			this.deptName = deptName;
			this.isGradnotUndergrad = isGradnotUndergrad;
			this.units = units;
			this.noOfStuPerCourse = noOfStuPerCourse;
			
		}

		public String getCourseName() {
			return courseName;
		}

		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}

		public String getDeptName() {
			return deptName;
		}

		public void setDeptName(String deptName) {
			this.deptName = deptName;
		}

		public boolean isGradOrUndergrad() {
			return isGradnotUndergrad;
		}

		public void setGradOrUndergrad(boolean isGradOrUndergrad) {
			this.isGradnotUndergrad = isGradOrUndergrad;
		}

		public int getUnits() {
			return units;
		}

		public void setUnits(int units) {
			this.units = units;
		}

		public int getNoOfStuPerCourse() {
			return noOfStuPerCourse;
		}
		
		public void incrementNoOfStuPerCourse(){
			noOfStuPerCourse++;
		}

		public void setNoOfStuPerCourse(int noOfStuPerCourse) {
			this.noOfStuPerCourse = noOfStuPerCourse;
		}

}
