package com.org.model.service;

import java.util.List;
import java.util.stream.Collectors;

import com.org.exception.AccountDoesNotExist;
import com.org.model.beans.Account;
import com.org.model.dao.AccountDao;
import com.org.model.util.ObjectFactory;

public class AccountServiceImpl implements AccountService {

	
	private AccountDao accountDao = null;
	public AccountServiceImpl() {
		accountDao = ObjectFactory.getAccountDaoInstance();
	}
	
	
	@Override
	public Account createAccount(Account account) {
		return accountDao.createAccount(account);
	}

	@Override
	public double getBalance(int accountNumber) throws AccountDoesNotExist {
		 
			Account a1 = accountDao.getAccount(accountNumber);
		 
		
		
		return a1.getBalance();
	}

	@Override
	public void transfer(int sourceAccount, int destincationAccount, double amount) {
		 
		 
		accountDao.debit(sourceAccount, amount);

		accountDao.credit(destincationAccount, amount);
		
		 
	}

	@Override
	public List<Account> getAccountsSortedByName() {
		List<Account> accounts = accountDao.getAccounts();
		List<Account> sortedAccount = accounts.stream()
		.sorted((account1, account2) -> account1.getCustomerName().compareTo(account2.getCustomerName()))
		.collect(Collectors.toList());
		
		return sortedAccount;
	}

	@Override
	public List<Account> getAccountsSortedByAccountNumber() {
		List<Account> accounts = accountDao.getAccounts();
		List<Account> sortedAccount = accounts.stream()
		.sorted((account1, account2) -> account2.getAccountNumber()- account1.getAccountNumber())
		.collect(Collectors.toList());
		
		
		return sortedAccount;
	}

}
