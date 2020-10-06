package com.org.controller;

import java.util.List;
import java.util.Scanner;

import com.org.exception.AccountDoesNotExist;
import com.org.model.beans.Account;
import com.org.model.service.AccountService;
import com.org.model.util.ObjectFactory;

public class MainViewController {

	public static void main(String[] args) {
		int option = 0;
		Scanner scanner = new Scanner(System.in);
		AccountService service = ObjectFactory.getAccountServiceInstance();
		do {
			System.out.println("1: Create Account 2: Check Balance");
			System.out.println("3: Transfer Amount 4: Sort Accounts by name 5: Sort Accounts by account number 6: Delete Account"
					+ "0: Exit");
			option = scanner.nextInt();
			List<Account> list = null;
			switch(option) {
			case 1: 
				System.out.println("Enter name");
				Account account = new Account(scanner.next());
				Account createdAccount = service.createAccount(account);
				System.out.println(createdAccount);
				break;
			case 2:
				System.out.println("Enter Account Number");
				int accountNumber =  scanner.nextInt();
				double balance;
				try {
					balance = service.getBalance(accountNumber);
					System.out.println("The balance for "+ accountNumber + " is " + balance);
				} catch (AccountDoesNotExist e1) {
					 
					e1.getMessage("Account does not exist");
					 
				}
				
				 break; 
			case 3: 
				System.out.println("Enter Source Account Number");
				int sAcc = scanner.nextInt();
				
				System.out.println("Enter Amount to be transfered");
				int amount = scanner.nextInt();
				
				System.out.println("Enter Destination Account Number");
				int dAcc = scanner.nextInt();
				
				service.transfer(sAcc, dAcc, amount);
				
				double bal;
				try {
					bal = service.getBalance(sAcc);
					System.out.println("The balance for "+ sAcc + " is " + bal);
				} catch (AccountDoesNotExist e) {
					  e.printStackTrace();
				}
				
				break; 
			
			case 4: 
				list = service.getAccountsSortedByName(); // HttpSession -> setAttribute("key", list) -> ${ }
				list.forEach(acc -> System.out.println(acc));
				break;
			case 5:
				list = service.getAccountsSortedByAccountNumber(); 
				list.forEach(acc -> System.out.println(acc));
				break;
			 
			}
		} while(option != 0);
		
		scanner.close();
	}

}

