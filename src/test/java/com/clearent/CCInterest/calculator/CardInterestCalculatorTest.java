package com.clearent.CCInterest.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.clearent.CCInterest.card.Visa;
import com.clearent.CCInterest.configuration.AppConfiguration;
import com.clearent.CCInterest.utility.CardUtility;
import com.clearent.CCInterest.Wallet;
import com.clearent.CCInterest.card.CreditCard;
import com.clearent.CCInterest.card.Discover;
import com.clearent.CCInterest.card.Master;

import Calculator.InterestCalculator;
import Calculator.SimpleInterestCalculator;
import exception.IncorrectBalanceException;
import exception.NullObjectException;



public class CardInterestCalculatorTest {
	
	private InterestCalculator calculator = new SimpleInterestCalculator();
	
	
	/************************ Test Exception *************************/
	
	
	@DisplayName("Test setting negative balance for Visa ")
	@Test
	void testVisaSetBalanceNegative() {
		Exception exception = assertThrows(IncorrectBalanceException.class, () -> {
			new Visa().setBalance(-1);
			});
		String expectedMessage = AppConfiguration.NEGATIVE_CARD_BALANCE;
		assertEquals( expectedMessage, exception.getMessage());
	}
	
	@DisplayName("Test setting negative balance for Master ")
	@Test
	void testMasterSetBalanceNegative() {
		Exception exception = assertThrows(IncorrectBalanceException.class, () -> {
			new Master().setBalance(-1);
			});
		String expectedMessage = AppConfiguration.NEGATIVE_CARD_BALANCE;
		assertEquals( expectedMessage, exception.getMessage());
	}
	
	@DisplayName("Test setting negative balance for Discover ")
	@Test
	void testDiscoverSetBalanceNegative() {
		Exception exception = assertThrows(IncorrectBalanceException.class, () -> {
			new Discover().setBalance(-1);
			});
		String expectedMessage = AppConfiguration.NEGATIVE_CARD_BALANCE;
		assertEquals( expectedMessage, exception.getMessage());
	}
	
	@DisplayName("Test Interest Calculation for Null CreditCard ")
	@Test
	void testcalculateCardInterestNullCard() {
		Exception exception = assertThrows(NullObjectException.class, () -> {
			calculator.calculateCardInterest(null);
			});
		String expectedMessage = AppConfiguration.CREDIT_CARD_OBJECT_NULL;
		assertEquals( expectedMessage, exception.getMessage());
	}
	

	/**************************** test caluclation logic *****************************************/
	
	@DisplayName("Test Interest for Visa Card balance 100 - pass in abstract class")
	@Test
	void testcalculateCardInterestVisaASCC() {
		CreditCard visa = CardUtility.createCard(Visa::new);
        assertTrue( calculator.calculateCardInterest(visa) == AppConfiguration.VISA_INTEREST);
	}
	
	@DisplayName("Test Interest for Visa Card balance 100 - pass in subclass")
	@Test
	void testcalculateCardInterestASVisa() {
		Visa visa = new Visa();
		try {
			visa.setBalance(AppConfiguration.DEFAULT_CARD_BALANCE);
		}catch(IncorrectBalanceException e) {
			
		}
        assertTrue( calculator.calculateCardInterest(visa) == AppConfiguration.VISA_INTEREST);
	}
	
	@DisplayName("Test Interest for Master Card balance 100 ")
	@Test
	void testcalculateCardInterestMaster() {
		CreditCard master = CardUtility.createCard(Master::new);
        assertTrue( calculator.calculateCardInterest(master) == AppConfiguration.MASTER_INTEREST);
	}
	
	@DisplayName("Test Interest for Discover Card balance 100 ")
	@Test
	void testcalculateCardInterestDiscover() {
		CreditCard visa = CardUtility.createCard(Discover::new);
        assertTrue( calculator.calculateCardInterest(visa) == AppConfiguration.DISCOVER_INTEREST);
	}
	
	@DisplayName("Test Interest for Visa Card balance 0 ")
	@Test
	void testcalculateCardInterestVisaDefaultBalance() {
		CreditCard visa = new Visa();
        assertTrue( calculator.calculateCardInterest(visa) == 0);
	}
	
	@DisplayName("Test Interest for Master Card balance 0 ")
	@Test
	void testcalculateCardInterestMasterDefaultBalance() {
		CreditCard master = new Master();
        assertTrue( calculator.calculateCardInterest(master) == 0);
	}
	
	@DisplayName("Test Interest for Discover Card balance 0 ")
	@Test
	void testcalculateCardInterestDiscoverDefaultBalance() {
		CreditCard visa = new Discover();
        assertTrue( calculator.calculateCardInterest(visa) == 0);
	}
	
	
	
	
}
