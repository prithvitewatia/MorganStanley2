package banking;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {

    private final LinkedHashMap<Long, Account> accounts;
    private final AtomicLong accountNumberGenerator = new AtomicLong();

    public Bank() {
        // complete the function
        accounts = new LinkedHashMap<>();
    }

    private Account getAccount(Long accountNumber) {
        // complete the function
        return accounts.get(accountNumber);
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        // complete the function
        Long accountNumber = accountNumberGenerator.incrementAndGet();
        Account account = new CommercialAccount(company, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, account);
        return accountNumber;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        Long accountNumber = accountNumberGenerator.incrementAndGet();
        Account account = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, account);
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
