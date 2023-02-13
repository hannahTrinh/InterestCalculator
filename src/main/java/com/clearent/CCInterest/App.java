package com.clearent.CCInterest;

import com.clearent.CCInterest.factory.InterestCalculatorFactory;
import com.clearent.CCInterest.utility.CardUtility;

import Calculator.InterestCalculator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Calculate Interest" );
        
        InterestCalculator calculator = InterestCalculatorFactory.getInterestCalculator();
        
        Wallet wallet = CardUtility.createWalletWith3Cards();
		Person person = CardUtility.createPersonWithWallets(wallet);
		System.out.println("Interest for a person with 1 wallet containing 1 card type each, card balance $100 = " + calculator.calculatePersonInterest(person));	
    }
}
