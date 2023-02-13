package com.clearent.CCInterest.utility;

import java.util.function.Predicate;
import java.util.function.Supplier;

import com.clearent.CCInterest.Person;
import com.clearent.CCInterest.Wallet;
import com.clearent.CCInterest.card.CreditCard;
import com.clearent.CCInterest.card.Discover;
import com.clearent.CCInterest.card.Master;
import com.clearent.CCInterest.card.Visa;

public class CardUtility {

	public static double DEFAULT_CARD_BALANCE = 100;
	
	/*
	 * create and return a CreditCard object with default balance of $100 
	 * based on the constructor passed in, could be a Visa, Master or Discover
	 */
	public static CreditCard createCard(Supplier<CreditCard> f) {
		CreditCard c = f.get(); 
		try {
			c.setBalance(DEFAULT_CARD_BALANCE);
		}catch(Exception e) {
			
		}
		return c;
	}

	
	/*
	 * create a Wallet that hold 3 cards, 1 for each type Visa, Master and Discover, with default balance $100
	 */
	public static Wallet createWalletWith3Cards() {
		
		Wallet wallet = new Wallet();
		
		wallet.addCard(createCard(Visa::new));
		wallet.addCard(createCard(Master::new));
		wallet.addCard(createCard(Discover::new));
		
		return wallet;
	}

	/*
	 * create a Wallet that hold any cards passed in
	 */
	public static Wallet createWalletFromCards(CreditCard...cards) {
		
		Wallet wallet = new Wallet();
		
		for (CreditCard creditCard : cards) {
			wallet.addCard(creditCard);
		}
		
		return wallet;
	}
	
	/*
	 * create a Person that hold any wallets passed in
	 */
	public static Person createPersonWithWallets(Wallet...wallets) {
		
		Person person = new Person();
		
		for (Wallet wallet : wallets) {
			person.addWallets(wallet);
		}
		
		return person;
	}
	
	public static CreditCard getCardFromFirstPersonWalletByType(Person person, Predicate<CreditCard> p) {
		
		return person.getWallets().get(0).getCards().stream().filter(p).findFirst().orElse(null);
	}
	
}
