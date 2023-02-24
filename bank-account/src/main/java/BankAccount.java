import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {

    private final AtomicInteger balance = new AtomicInteger();
    private boolean opened = false;

    public BankAccount() {
    }

    public void open() {
        opened = true;
        balance.set(0);
    }

    public int getBalance() throws BankAccountActionInvalidException {
        if (!opened) throw new BankAccountActionInvalidException("Account closed");
        return balance.get();
    }

    public void deposit(int amount) throws BankAccountActionInvalidException {
        if (!opened) throw new BankAccountActionInvalidException("Account closed");
        if (amount < 0) throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        balance.addAndGet(amount);
    }

    public void withdraw(int amount) throws BankAccountActionInvalidException {
        if (!opened) throw new BankAccountActionInvalidException("Account closed");
        if (amount < 0) throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        if (balance.get() == 0)
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        if (balance.get() - amount < 0)
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");

        balance.addAndGet(-amount);

    }

    public void close() {
        opened = false;
        balance.set(0);
    }
}
