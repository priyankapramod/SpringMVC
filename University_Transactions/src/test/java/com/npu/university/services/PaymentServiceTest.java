package com.npu.university.services;
/*
 * b) Tests that failures in the PaymentService are properly handled (exceptions thrown)
c) Tests for a successful payment in the PaymentService properly updates the student’s account
 */

import com.npu.university.dao.AccountDAO;
import com.npu.university.domain.Account;
import com.npu.university.domain.Course;
import com.npu.university.domain.Student;
import com.npu.university.services.WellsFargoPaymentServiceImpl;
import org.junit.Test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

import org.aspectj.lang.annotation.Before;
import org.junit.Assert;

@ContextConfiguration("classpath:/META-INF/spring/app-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class PaymentServiceTest {
	@Autowired
	@Qualifier("paymentServiceWF")
	private WellsFargoPaymentServiceImpl creditCarWF;
	@Autowired
	@Qualifier("accountDao")
	private AccountDAO accountDAO;
   private Student studentCS;
    //private Account stuAccount;
	
	@org.junit.Before
    public void init(){
    	ArrayList<Course> courses = new ArrayList<Course>();
		Course course1 = new Course("chemistry", "CS111", true, 3, 0 );
		Course course2 = new Course("physics", "CS112", true, 5, 0 );
		Course course3 = new Course("maths", "CS113", true, 3, 0 );
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		studentCS = new Student("Mickey", "12345", true, true, courses );
    }
    
  
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgException(){
		creditCarWF.makePayment("222333444111777s", 100.0, studentCS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgExceptionForLength(){
		creditCarWF.makePayment("222333444111", 100.0, studentCS);
		creditCarWF.makePayment("222333444111777666", 100.0, studentCS);
	}
	
	@Test(expected = InputMismatchException.class)
	public void testInputMismatchException(){
		creditCarWF.makePayment("522333444111777", 100.0, studentCS);
	}
	
    @Test
	public void testPassCreditCard(){
    	Account accStu =  accountDAO.studentAccount(studentCS.getId());
    	accountDAO.updateToMyBal(accStu.getAccountID(), 100.0);
		creditCarWF.makePayment("222333444111777", 100.0, studentCS);
		double amt = accountDAO.showAccBal(accStu.getAccountID());
		Assert.assertEquals(0.0, amt,0);
		 
	}
	
}
