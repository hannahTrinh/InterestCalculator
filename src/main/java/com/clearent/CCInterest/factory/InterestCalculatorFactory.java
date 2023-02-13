package com.clearent.CCInterest.factory;

import Calculator.InterestCalculator;
import Calculator.SimpleInterestCalculator;

public class InterestCalculatorFactory {

	public static InterestCalculator getInterestCalculator() {
		return new SimpleInterestCalculator();
	}
}
