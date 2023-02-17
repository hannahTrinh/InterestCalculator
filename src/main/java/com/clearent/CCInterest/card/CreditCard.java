package com.clearent.CCInterest.card;

import com.clearent.CCInterest.configuration.AppConfiguration;

import exception.IncorrectBalanceException;

/*
 * Single Responsible Principle - store card info
 * Open/Closed Principle - new card type (with more feature) could be introduced without changing the base class
 * Liskov Substitution Principle
 */
public abstract class CreditCard {
	double balance = 0;
	int interestRate;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) throws IncorrectBalanceException{
		if (balance < 0)
			throw new IncorrectBalanceException(AppConfiguration.NEGATIVE_CARD_BALANCE);
		
		this.balance = balance;
	}
	
	public int getInterestRate() {
		return interestRate;
	}
}
