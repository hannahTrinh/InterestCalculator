package com.clearent.CCInterest.card;

import com.clearent.CCInterest.configuration.AppConfiguration;
/*
 * Open/Closed Principle - new card type (with more feature) could be introduced without changing the base class
 * Liskov Substitution Principle
 */
public class Master extends CreditCard {
	public Master() {
		interestRate = AppConfiguration.MASTER_INTEREST;
	}

}
