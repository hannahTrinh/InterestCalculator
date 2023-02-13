package com.clearent.CCInterest.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.clearent.CCInterest.Person;
import com.clearent.CCInterest.Wallet;
import com.clearent.CCInterest.configuration.AppConfiguration;
import com.clearent.CCInterest.utility.CardUtility;

import Calculator.InterestCalculator;
import Calculator.SimpleInterestCalculator;
import exception.NullObjectException;

public class PersonInterestCalculatorTest {
	private InterestCalculator calculator = new SimpleInterestCalculator();
	
	/************************** Test Exception *********************************************/
	
	@DisplayName("Test Interest Calculation for Null Person ")
	@Test
	void testCalculatePersonInterestNullPerson() {
		Exception exception = assertThrows(NullObjectException.class, () -> {
			calculator.calculatePersonInterest(null);
			});
		String expectedMessage = AppConfiguration.PERSON_OBJECT_NULL;
		assertEquals( expectedMessage, exception.getMessage());
	}
	
	@DisplayName("Test creating new Person with NULL Wallet List")
	@Test
	void testNewPersonNullWallets() {
		Exception exception = assertThrows(NullObjectException.class, () -> {
			new Person(null);
			});
		String expectedMessage = AppConfiguration.WALLET_LIST_OBJECT_NULL;
		assertEquals( expectedMessage, exception.getMessage());
	}
	
	/************************* Test calculation logic ***************************************/
	
	@DisplayName("Test Interest for persons with no wallet")
	@Test
	public void testCalculatePersonInterestPersonWithNoWallets() {
		Person person = new Person();
		assertTrue( calculator.calculatePersonInterest(person) == 0);
	}
	
	
	@DisplayName("Test Person Interest - person has 1 wallet with 1 card for each card type")
	@Test
	public void testCalculatePersonInterest1WalletWith3cards() {
				
		Wallet wallet = CardUtility.createWalletWith3Cards();
		Person person = new Person ();
		person.addWallets(wallet);
		
		assertTrue(calculator.calculatePersonInterest(person) == AppConfiguration.VISA_INTEREST + AppConfiguration.MASTER_INTEREST + AppConfiguration.DISCOVER_INTEREST );
	}
}
