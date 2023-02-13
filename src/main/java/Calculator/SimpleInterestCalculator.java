package Calculator;

import com.clearent.CCInterest.Person;
import com.clearent.CCInterest.Wallet;
import com.clearent.CCInterest.card.CreditCard;
import com.clearent.CCInterest.configuration.AppConfiguration;

import exception.NullObjectException;

public class SimpleInterestCalculator implements InterestCalculator {

	@Override
	public double calculateCardInterest(CreditCard card) throws NullObjectException{
		if (card == null)
			throw new NullObjectException(AppConfiguration.CREDIT_CARD_OBJECT_NULL);
		
		return card.getInterestRate()*card.getBalance()/100;
	}
	
	@Override
	public double calculateWalletInterest(Wallet wallet) throws NullObjectException {
		if (wallet == null)
			throw new NullObjectException(AppConfiguration.WALLET_OBJECT_NULL);
		
		return wallet.getCards().stream()
				.mapToDouble(c -> calculateCardInterest(c)).sum();
	}
	
	@Override
	public double calculatePersonInterest(Person person) throws NullObjectException{
		if (person == null)
			throw new NullObjectException(AppConfiguration.PERSON_OBJECT_NULL);
		
		return person.getWallets().stream().mapToDouble(w -> calculateWalletInterest(w)).sum();
	}

}
