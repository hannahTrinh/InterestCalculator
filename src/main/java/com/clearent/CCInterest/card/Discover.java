package com.clearent.CCInterest.card;

import com.clearent.CCInterest.configuration.AppConfiguration;


/*
 * Open/Closed Principle - new card type (with more feature) could be introduced without changing the base class
 * Liskov Substitution Principle
 */
public class Discover extends CreditCard {
	public Discover() {
		interestRate = AppConfiguration.DISCOVER_INTEREST;
	}

}
