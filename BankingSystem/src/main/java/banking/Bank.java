package banking;

import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;

	public Bank() {
		// complete the function
    accounts=new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		Long accountNumber=(new SecureRandom()).nextLong();
		Account account=new CommercialAccount(company, accountNumber, pin,startingDeposit);
		accounts.put(accountNumber,account);
        return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		Long accountNumber=(new SecureRandom()).nextLong();
		Account account=new ConsumerAccount(person,accountNumber,pin,startingDeposit);
		accounts.put(accountNumber,account);
        return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
        return getAccount(accountNumber).validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		// complete the function
        return getAccount(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		getAccount(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
        return getAccount(accountNumber).debitAccount(amount);
	}
}
