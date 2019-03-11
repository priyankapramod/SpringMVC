package com.npu.university.services;

import com.npu.university.domain.Student;


public interface PaymentService {
	
	public void makePayment(String creditCardNo, double amount, Student student);
}



