package com.npu.university.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.npu.university.config.UniversityAppConfig;
import com.npu.university.dao.AccountDAO;
import com.npu.university.dao.jdbc.AccountMockedDaoImpl;
import com.npu.university.domain.Course;
import com.npu.university.domain.Student;
import com.npu.university.services.StudentCheckoutServiceImpl;


/*
 * Write a method (different from main()) that will create a Student object
3. Write a method (different from main()) that will create a list of Course objects
4. Call the checkout() method of the student checkout service by providing the student object, a
list of courses and a credit card number.
5. Experiment with changing to a different payment service and a different tuition calculator. Can
you do so without changing your Java code?
 */

public class StudentApplication {
	private static final Log log = LogFactory.getLog(StudentApplication.class);
	public static void main(String args[]) {
		//ApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
		
		ApplicationContext container = new AnnotationConfigApplicationContext(UniversityAppConfig.class);
		StudentCheckoutServiceImpl studentRegistered = (StudentCheckoutServiceImpl) container.getBean("studentCheckout");
		AccountDAO accountDAO = (AccountDAO) container.getBean("accountDao");
		ArrayList<Course> cour = createCour();
		
		Student stu = createStu(cour);
		accountDAO.studentAccount(stu.getId());
		double amtToBepaid = 5500.0;
		
		studentRegistered.checkout(stu, cour, amtToBepaid);
		//accountDAO.showAccBal(stu.getId());
		log.info(accountDAO.showAccBal(stu.getId()));
	}
	private static Student createStu(ArrayList<Course> cour){
		
		 return new Student("Mickey", "12345", true, true, cour);
	}
	
	private static ArrayList<Course> createCour(){
		ArrayList<Course> courses = new ArrayList<Course>();
		Course course1 = new Course("chemistry", "CS111", true, 3, 0 );
		Course course2 = new Course("physics", "CS112", true, 5, 0 );
		Course course3 = new Course("maths", "CS113", true, 3, 0 );
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		
		return courses;
	}
	
}