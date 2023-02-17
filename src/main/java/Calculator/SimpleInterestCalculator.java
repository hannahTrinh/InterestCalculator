package Calculator;

import com.clearent.CCInterest.Person;
import com.clearent.CCInterest.Wallet;
import com.clearent.CCInterest.card.CreditCard;
import com.clearent.CCInterest.configuration.AppConfiguration;

import exception.NullObjectException;

public class SimpleInterestCalculator implements InterestCalculator {

	/*
	 * Calculate interest for a credit card
	 * Card Interest = balance * interestRate
	 */
	@Override
	public double calculateCardInterest(CreditCard card) throws NullObjectException{
		if (card == null)
			throw new NullObjectException(AppConfiguration.CREDIT_CARD_OBJECT_NULL);
		
		return card.getInterestRate()*card.getBalance()/100;
	}
	
	/*
	 * Calculate interest for a wallet
	 * by summing interest of all cards in the wallet
	 * */
	@Override
	public double calculateWalletInterest(Wallet wallet) throws NullObjectException {
		if (wallet == null)
			throw new NullObjectException(AppConfiguration.WALLET_OBJECT_NULL);
		
		return wallet.getCards().stream()
				.mapToDouble(c -> calculateCardInterest(c)).sum();
	}
	
	/*
	 * Calculate interest for a person
	 * by summing interest of all the wallets the person has
	 */
	@Override
	public double calculatePersonInterest(Person person) throws NullObjectException{
		if (person == null)
			throw new NullObjectException(AppConfiguration.PERSON_OBJECT_NULL);
		
		return person.getWallets().stream().mapToDouble(w -> calculateWalletInterest(w)).sum();
	}

}
