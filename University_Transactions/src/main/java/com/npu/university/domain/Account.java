package com.npu.university.domain;
import java.util.Date;

/*
 a) Account id (for our purposes, we will use the student id as the account id)
b) Balance due
c) Date due (use the Date class)
 */


public class Account {
	
	private String accountID;
	private double dueBal;
	private Date dueDt = new Date();
	
	
	public Account(String accountID, double dueBal, Date dueDt){
		this.accountID = accountID;
		this.dueBal = dueBal;
		this.dueDt = dueDt;
	}


	public String getAccountID() {
		return accountID;
	}


	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}


	public double getDueBal() {
		return dueBal;
	}


	public void setDueBal(double dueBal) {
		this.dueBal = dueBal;
	}


	public Date getDueDt() {
		return dueDt;
	}


	public void setDueDt(Date dueDt) {
		this.dueDt = dueDt;
	}
	
	
	

}
