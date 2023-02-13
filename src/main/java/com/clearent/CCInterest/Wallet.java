package com.clearent.CCInterest;

import java.util.ArrayList;
import java.util.List;

import com.clearent.CCInterest.card.CreditCard;
import com.clearent.CCInterest.configuration.AppConfiguration;

import exception.NullObjectException;

public class Wallet {
	
	//Liskov Substitution Principle - subtypes could substitute base class CreditCard
	private List<CreditCard> cards = new ArrayList<>();
	
	public Wallet() {}
	
	public Wallet(List<CreditCard> cards) throws NullObjectException{
		if (cards == null)
			throw new NullObjectException(AppConfiguration.CREDIT_CARD_LIST_OBJECT_NULL);
		
		this.cards = cards;
	}
	
	public void addCard(CreditCard card) {
		cards.add(card);
	}
	
	public List<CreditCard> getCards(){
		return this.cards;
	}
}
