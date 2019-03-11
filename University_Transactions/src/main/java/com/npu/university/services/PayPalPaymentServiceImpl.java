package com.npu.university.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.npu.university.dao.AccountDAO;
import com.npu.university.domain.Account;
import com.npu.university.domain.Student;
//@Service("paymentServicePP")

public class PayPalPaymentServiceImpl implements PaymentService {
	
	
		public void makePayment(String creditCardNo, double amount, Student student) {
			System.out.println("Using the Wells Fargo credit card" +
	        " processor to process credit card number " +  creditCardNo +" for "+ student.getName() +" Payment of $" + amount);
			
		}
	
}
