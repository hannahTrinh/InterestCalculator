package com.clearent.CCInterest;

import java.util.ArrayList;
import java.util.List;

import com.clearent.CCInterest.configuration.AppConfiguration;

import exception.NullObjectException;

public class Person {
	List<Wallet> wallets = new ArrayList<>();
	
	public Person() {}
	
	public Person (List<Wallet> wallets) throws NullObjectException{
		if (wallets == null)
			throw new NullObjectException(AppConfiguration.WALLET_LIST_OBJECT_NULL);
		
		this.wallets = wallets;
	}
	
	public void addWallets(Wallet wallet) {
		this.wallets.add(wallet);
	}
	
	public List<Wallet> getWallets(){
		return wallets;
	}
}
