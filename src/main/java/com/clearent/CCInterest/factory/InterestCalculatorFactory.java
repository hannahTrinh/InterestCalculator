package com.clearent.CCInterest.factory;

import Calculator.InterestCalculator;
import Calculator.SimpleInterestCalculator;

public class InterestCalculatorFactory {

	/*
	 * Return an implementation class for InteresCalculator
	 * */
	public static InterestCalculator getInterestCalculator() {
		return new SimpleInterestCalculator();
	}
}
