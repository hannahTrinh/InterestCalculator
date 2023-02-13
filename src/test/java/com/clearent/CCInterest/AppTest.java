package com.clearent.CCInterest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import com.clearent.CCInterest.card.Discover;
import com.clearent.CCInterest.card.Master;
import com.clearent.CCInterest.card.Visa;
import com.clearent.CCInterest.configuration.AppConfiguration;
import com.clearent.CCInterest.utility.CardUtility;

import Calculator.InterestCalculator;
import Calculator.SimpleInterestCalculator;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private InterestCalculator calculator = new SimpleInterestCalculator();
	
	
    @DisplayName("Test Case 1 - 1 person has 1 wallet and 3 cards")
    @Test
    public void testCase1()
    {
    	Wallet wallet = CardUtility.createWalletWith3Cards();
		Person person = CardUtility.createPersonWithWallets(wallet);
				
		assertAll("test each card interest and person interest"
				, () -> assertTrue("test Visa interest", calculator.calculateCardInterest(CardUtility.getCardFromFirstPersonWalletByType(person, card -> card instanceof Visa)) == AppConfiguration.VISA_INTEREST)
				, () -> assertTrue("test Master interest", calculator.calculateCardInterest(CardUtility.getCardFromFirstPersonWalletByType(person, card -> card instanceof Master)) == AppConfiguration.MASTER_INTEREST)
				, () -> assertTrue("test Discover interest", calculator.calculateCardInterest(CardUtility.getCardFromFirstPersonWalletByType(person, card -> card instanceof Discover)) == AppConfiguration.DISCOVER_INTEREST)
				, () -> assertTrue("test Person interest", calculator.calculatePersonInterest(person) == 16)
				);
    }
    
    @DisplayName("Test Case 2 - 1 person has 2 wallets, wallet 1 has Visa and Discover, wallet 2 has Master")
    @Test
    public void testCase2()
    {
    	Wallet w1 = CardUtility.createWalletFromCards(CardUtility.createCard(Visa::new), CardUtility.createCard(Discover::new));
		Wallet w2 = CardUtility.createWalletFromCards(CardUtility.createCard(Master::new));
		
		Person p = CardUtility.createPersonWithWallets(w1, w2);
				
		assertAll("test person and each wallet interest"
				, () -> assertTrue("test wallet1 interest", calculator.calculateWalletInterest(w1) == AppConfiguration.VISA_INTEREST + AppConfiguration.DISCOVER_INTEREST)
				, () -> assertTrue("test wallet2 interest", calculator.calculateWalletInterest(w2) == AppConfiguration.MASTER_INTEREST)
				, () -> assertTrue("test Person interest", calculator.calculatePersonInterest(p) == 16)
				);
    }
    
    @DisplayName("Test Case 3 - 2 person has 1 wallet each, person 1 wallet with 2 cards MC & Visa, person 2 wallet has 1 Visa and 1MC")
    @Test
    public void testCase3()
    {		
    	Wallet w1 = CardUtility.createWalletFromCards(CardUtility.createCard(Visa::new), CardUtility.createCard(Master::new));
    	Person p1 = CardUtility.createPersonWithWallets(w1);
		
		Wallet w2 = CardUtility.createWalletFromCards(CardUtility.createCard(Visa::new), CardUtility.createCard(Master::new));
		Person p2 = CardUtility.createPersonWithWallets(w2);
		
				
		ArrayList<Person> persons = new ArrayList<Person>(Arrays.asList(new Person[]{p1, p2}));
		
		persons.forEach(person ->
		assertAll("test 2 person has 1 wallet each, person 1 wallet has 2 cards MC & Visa, person 2 wallet has 1 Visa and 1 MC"
				, () -> assertTrue("test person wallet interest", calculator.calculateWalletInterest(person.getWallets().get(0)) == AppConfiguration.VISA_INTEREST + AppConfiguration.MASTER_INTEREST)
				, () -> assertTrue("test person interest", calculator.calculatePersonInterest(person) == AppConfiguration.VISA_INTEREST + AppConfiguration.MASTER_INTEREST)
				)
		);
    }
    

}
