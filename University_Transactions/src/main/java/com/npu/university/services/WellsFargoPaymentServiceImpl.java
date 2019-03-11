package com.npu.university.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.npu.university.dao.AccountDAO;
import com.npu.university.domain.Student;
import java.util.Date;
import java.util.InputMismatchException;

@Service("paymentServiceWF")
public class WellsFargoPaymentServiceImpl implements PaymentService {
	@Autowired 
	private AccountDAO accountDao;
	
	public void makePayment(String creditCardNo, double amount, Student student) {
		int length = creditCardNo.length();
		
		    if (!(creditCardNo.matches("[0-9]+")) ||  length !=  15) {
		    	throw new IllegalArgumentException("invalid credit card number");
		    }
		    
		    if(creditCardNo.startsWith("5"))
		    	throw new InputMismatchException();
		    
		    //NVZ accountDB.studentAccount(student.getId());
		    //Look up the student's account (use the AccountDao to get back an Account object using only the student id  
		    // Now that we have the account object, update the new balance
		    
		    
		    double netBal =  accountDao.showAccBal(student.getId()) - amount;
		    accountDao.updateToMyBal(student.getId(), netBal);
		if(netBal == 0){
			System.out.println("paid successfully.");
		}else{
			System.out.println(netBal + "is due");
		}
		
		System.out.println("Using the WellsFargo credit card" +
        "processor to process credit card number" +  creditCardNo +"for "+ student.getName() +" Payment of $" + amount);
	}
	
}

	


