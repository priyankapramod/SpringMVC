package com.npu.university.dao.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.npu.university.dao.AccountDAO;
import com.npu.university.domain.Account;
import com.npu.university.domain.Course;
import com.npu.university.domain.Student;
import com.npu.university.services.StudentCheckoutServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.aspectj.lang.annotation.Before;
import org.junit.Assert;

@ContextConfiguration("classpath:/META-INF/spring/app-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class AccountDAOTest {
	
	@Autowired
	@Qualifier("accountDao")
	private AccountDAO accountDBTest;
    private Student  studentCS; 
    //private Student  studentMBA;
    //private Account  studAccount;
   
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
    
    
	@Test
    public void testStudentAccount(){
    	Account studAccount = accountDBTest.studentAccount(studentCS.getId()); 
    	Assert.assertNotNull("Account obj created", studAccount);
    	Assert.assertSame(studAccount, AccountMockedDaoImpl.accountMap.get(studAccount.getAccountID()));
    	AccountMockedDaoImpl.accountMap.get(studAccount.getAccountID());
    }
 
    @Test
    public void testShowAccBal(){
    	Account stuAccount = new Account(studentCS.getId(), 100.00, new Date());
    	AccountMockedDaoImpl.accountMap.put(stuAccount.getAccountID(), stuAccount);
    	Assert.assertEquals(stuAccount.getDueBal(), accountDBTest.showAccBal(stuAccount.getAccountID()),0);
    }
    
    
  @Test
  public void testUpdateToMyBal(){
	  Account stuAccount = new Account(studentCS.getId(), 100.00, new Date());
  	AccountMockedDaoImpl.accountMap.put(stuAccount.getAccountID(), stuAccount);
  	accountDBTest.updateToMyBal(stuAccount.getAccountID(),200.0);
  	Assert.assertEquals(stuAccount.getDueBal(),AccountMockedDaoImpl.accountMap.get(stuAccount.getAccountID()).getDueBal() ,0);
  }
   
  @Test 
  // which assert method to call of how to test
  public void testOverDueBal(){
	  //curr date(one day after the due date)
	  Date date = new Date();
	  long time = date.getTime() - 86400000;
	  date =  new Date(time);
	  
	  //current date is after the due date   there is over due bal
	  Account stuAccount1 = new Account("512345", 100.00, new Date());//duedt
	  Account stuAccount2 = new Account("612345", 150.00, date);
	  Account stuAccount3 = new Account("712345", 0.00, new Date());
	 
	  AccountMockedDaoImpl.accountMap.put(stuAccount1.getAccountID(), stuAccount1);
	  AccountMockedDaoImpl.accountMap.put(stuAccount2.getAccountID(), stuAccount2);
	  AccountMockedDaoImpl.accountMap.put(stuAccount3.getAccountID(), stuAccount3);
	  
	  //actual testing
	  List<String> studsWithDueBal = new ArrayList<String>();
	  studsWithDueBal =   accountDBTest.overDueBal(0.0, new Date());//curr dt
	  assertTrue(studsWithDueBal.size() == 2);
	  studsWithDueBal.contains(AccountMockedDaoImpl.accountMap.get(stuAccount1.getAccountID()));
	  studsWithDueBal.contains(AccountMockedDaoImpl.accountMap.get(stuAccount2.getAccountID()));
			  
  }
    
    
    
    
}

