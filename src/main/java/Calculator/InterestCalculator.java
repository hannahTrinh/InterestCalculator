package Calculator;

import com.clearent.CCInterest.Person;
import com.clearent.CCInterest.Wallet;
import com.clearent.CCInterest.card.CreditCard;

import exception.NullObjectException;

/*
 * Single Responsible Principle - this interface to handle interest calculation logic while CreditCard class store info related to card.  
 * Open / Closed Principle, Liskov Substitution Principle, and Dependency Inversion
 * if there's a change requirement in Interest Calculation logic, a new InterestCalculator implementation could be introduced
 */
 
public interface InterestCalculator {
	public double calculateCardInterest(CreditCard card) throws NullObjectException;
	public double calculateWalletInterest(Wallet wallet) throws NullObjectException;
	public double calculatePersonInterest(Person person) throws NullObjectException;
}
