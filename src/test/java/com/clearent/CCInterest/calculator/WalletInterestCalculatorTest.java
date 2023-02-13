package com.clearent.CCInterest.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.clearent.CCInterest.Wallet;
import com.clearent.CCInterest.configuration.AppConfiguration;
import com.clearent.CCInterest.utility.CardUtility;

import Calculator.InterestCalculator;
import Calculator.SimpleInterestCalculator;
import exception.NullObjectException;

public class WalletInterestCalculatorTest {

	private InterestCalculator calculator = new SimpleInterestCalculator();
	
	
	/************************ Test Exception *************************/
	
	@DisplayName("Test Create New wallet with Null CardList")
	@Test
	void testCreateWalletNullCardList() {
		Exception exception = assertThrows(NullObjectException.class, () -> {
			new Wallet(null);
			});
		String expectedMessage = AppConfiguration.CREDIT_CARD_LIST_OBJECT_NULL;
		assertEquals( expectedMessage, exception.getMessage());
	}
	
	
	@DisplayName("Test Interest Calculation for Null Wallet ")
	@Test
	void testCalculateWalletInterestNullWallet() {
		Exception exception = assertThrows(NullObjectException.class, () -> {
			calculator.calculateWalletInterest(null);
			});
		String expectedMessage = AppConfiguration.WALLET_OBJECT_NULL;
		assertEquals( expectedMessage, exception.getMessage());
	}

	
	/******************* test calculation logic **************************/
	
	@DisplayName("Test Interest Calculation for empty Wallet")
	@Test
	public void testcalculateWalletInterestEmptyWallet() {
		Wallet wallet = new Wallet();
		assertTrue( calculator.calculateWalletInterest(wallet) == 0);
	}
	
	@DisplayName("Test Wallet Interest - wallet 1 card for each card type - calculate wallet interest")
	@Test
	public void testcalculateWalletInterestWith3cards() {
				
		Wallet wallet = CardUtility.createWalletWith3Cards();
		
		assertTrue(calculator.calculateWalletInterest(wallet) == AppConfiguration.VISA_INTEREST + AppConfiguration.MASTER_INTEREST + AppConfiguration.DISCOVER_INTEREST );
	}

}
