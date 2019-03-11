package com.npu.university.dao.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.npu.university.dao.AccountDAO;
import com.npu.university.domain.Account;
/*
 * 
 * 1. A method to create a new Account for a student (the student id should be a parameter). The
initial balance should be set to $0.00. In a real database implementation, this method would
insert a new row in the Account table and return an Account object representing what is stored
in the table. For the Mocked DAO, create a new Account object in your data structure and
return the Account object that you have created.
2. A method that given an account id, retrieves the balance
3. A method that adds an amount to the current balance -- Given an account id and an amount to
add
4. A method that retrieves a list of account ids that have overdue balances (an overdue balance is
one where the balance is greater than 0.00 and the current date is after the due date
 */
@Repository("accountDao")
public class AccountMockedDaoImpl implements AccountDAO{
	private Account stuAccount;
	static Map<String, Account> accountMap = new HashMap<String, Account>();

	
	public Account studentAccount(String studentID) {
		stuAccount = new Account(studentID, 0.00, new Date());
		accountMap.put(studentID, stuAccount);
		return stuAccount;
	}

	public double showAccBal(String accountID) {
		return	(accountMap.get(accountID)).getDueBal();
	}

	public void updateToMyBal(String accountID, double netBal) {
		accountMap.get(accountID).setDueBal(netBal);
	}

	public List<String> overDueBal(double dueBal, Date currDate) {
		List<String> studentsOverDueIDs = new ArrayList<String>();
		for(Account account: accountMap.values()){
			if((account.getDueBal() > 0.00) && (account.getDueDt().getTime() < currDate.getTime())){
				studentsOverDueIDs.add(account.getAccountID());
			}
		}
		return studentsOverDueIDs;
	}

	

}
