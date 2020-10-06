package com.org.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.org.exception.AccountDoesNotExist;
import com.org.model.beans.Account;

public class CollectionBackedAccountDaoImpl implements AccountDao {

	private static List<Account> database = new ArrayList<>();
	@Override
	public Account createAccount(Account account) {
		database.add(account);
		return account;
	}

//	@Override
//	public Account updateBalance(int accountNumber, double amount) {
//		// TODO Auto-generated method stub
//		return null;
//	}



	@Override
	public Account debit(int accountNumber, double amount) {
		Account acc = database.stream().filter(item -> item.getAccountNumber() == accountNumber)
				.findAny()
				 .orElse(null);
		double bal = acc.getBalance();
		bal = bal - amount;
		acc.setBalance(bal);
		return acc;
	}

	@Override
	public Account credit(int accountNumber, double amount) {
		Account acc = database.stream().filter(item -> item.getAccountNumber() == accountNumber)
				.findAny()
				 .orElse(null);
		double bal = acc.getBalance();
		bal = bal + amount;
		acc.setBalance(bal);
		return acc;
	}

	@Override
	public void deleteAccount(int accountNumber) {
		// TODO Auto-generated method stub
	}


	@Override
	public Account getAccount(int accountNumber) throws AccountDoesNotExist{
		
		Account acc = database.stream()
				  .filter(Account -> Account.getAccountNumber() == accountNumber)
				  .findAny()
				  .orElse(null);
		if(acc.equals(null)) {
			throw new AccountDoesNotExist("Account does not exist for " + accountNumber);
		}
		
		  return acc;
	}

	@Override
	public List<Account> getAccounts() {
		 
		return database;

	}

}
