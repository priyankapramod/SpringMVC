package com.npu.university.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.npu.university.client.StudentApplication;
import com.npu.university.dao.AccountDAO;
import com.npu.university.domain.Course;
import com.npu.university.domain.Student;


@Service
public class StudentCheckoutServiceImpl {
	private static final Log log = LogFactory.getLog(StudentCheckoutServiceImpl.class);
	@Autowired
	//@Resource(name = "tutionCalculatorServiceNU")
	private TutionCalculatorService tutionCalculatorServiceNU;
	@Autowired
	private PaymentService paymentServiceWF;
	@Value("111222555666888")//not prefered ..better get it from property file
	private String creditCardNo;
	@Autowired
	private AccountDAO accountDB;
	/*
	public void setcreditCardpay(PaymentService creditCardpay){
		this.creditCardpay = creditCardpay;
	}
	
	public void setTutionFee(TutionCalculatorService tutionFee){
		this.tutionFee = tutionFee;
	}
	
	public void setCreditCardNo(int creditCardNo){
		this.creditCardNo = creditCardNo;
	}
	
	*/
	public void checkout(Student student, ArrayList<Course> courses, double amtToBepaid){
		student.setCourses(courses);
		
		
		for(Course course: courses){
			course.incrementNoOfStuPerCourse();
		}
		
		double fees = tutionCalculatorServiceNU.computeTution(student, courses);
		log.info(fees);
		accountDB.updateToMyBal(student.getId(), fees);
		paymentServiceWF.makePayment(creditCardNo, amtToBepaid, student);
		//System.out.println(tutionFeeOU.toString());
		
	}

}
