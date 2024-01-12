import org.junit.jupiter.api.Test;

import java.util.Random;

import org.assertj.core.api.Assertions;

public class BankAccountTest {
    private final BankAccount bankAccount = new BankAccount();

    @Test
    public void newlyOpenedAccountHasEmptyBalance() throws BankAccountActionInvalidException {
        bankAccount.open();

        Assertions.assertThat(bankAccount.getBalance()).isEqualTo(0);
    }

    @Test
    public void canDepositMoney() throws BankAccountActionInvalidException {
        bankAccount.open();

        bankAccount.deposit(10);

        Assertions.assertThat(bankAccount.getBalance()).isEqualTo(10);
    }

    @Test
    public void canDepositMoneySequentially() throws BankAccountActionInvalidException {
        bankAccount.open();

        bankAccount.deposit(5);
        bankAccount.deposit(23);

        Assertions.assertThat(bankAccount.getBalance()).isEqualTo(28);
    }

    @Test
    public void canWithdrawMoney() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(10);

        bankAccount.withdraw(5);

        Assertions.assertThat(bankAccount.getBalance()).isEqualTo(5);
    }

    @Test
    public void canWithdrawMoneySequentially() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(23);

        bankAccount.withdraw(10);
        bankAccount.withdraw(13);

        Assertions.assertThat(bankAccount.getBalance()).isEqualTo(0);
    }

    @Test
    public void cannotWithdrawMoneyFromEmptyAccount() {
        bankAccount.open();

        Assertions.assertThatExceptionOfType(BankAccountActionInvalidException.class)
                .isThrownBy(() -> bankAccount.withdraw(5))
                .withMessage("Cannot withdraw money from an empty account");
    }

    @Test
    public void cannotWithdrawMoreMoneyThanYouHave() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(6);

        Assertions.assertThatExceptionOfType(BankAccountActionInvalidException.class)
                .isThrownBy(() -> bankAccount.withdraw(7))
                .withMessage("Cannot withdraw more money than is currently in the account");
    }

    @Test
    public void cannotDepositNegativeAmount() {
        bankAccount.open();

        Assertions.assertThatExceptionOfType(BankAccountActionInvalidException.class)
                .isThrownBy(() -> bankAccount.deposit(-1))
                .withMessage("Cannot deposit or withdraw negative amount");
    }

    @Test
    public void cannotWithdrawNegativeAmount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(105);

        Assertions.assertThatExceptionOfType(BankAccountActionInvalidException.class)
                .isThrownBy(() -> bankAccount.withdraw(-5))
                .withMessage("Cannot deposit or withdraw negative amount");
    }

    @Test
    public void cannotGetBalanceOfClosedAccount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(10);
        bankAccount.close();

        Assertions.assertThatExceptionOfType(BankAccountActionInvalidException.class)
                .isThrownBy(bankAccount::getBalance)
                .withMessage("Account closed");
    }

    @Test
    public void cannotDepositMoneyIntoClosedAccount() {
        bankAccount.open();
        bankAccount.close();

        Assertions.assertThatExceptionOfType(BankAccountActionInvalidException.class)
                .isThrownBy(() -> bankAccount.deposit(5))
                .withMessage("Account closed");
    }

    @Test
    public void cannotWithdrawMoneyFromClosedAccount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(20);
        bankAccount.close();

        Assertions.assertThatExceptionOfType(BankAccountActionInvalidException.class)
                .isThrownBy(() -> bankAccount.withdraw(5))
                .withMessage("Account closed");
    }

    @Test
    public void bankAccountIsClosedBeforeItIsOpened() {
        Assertions.assertThatExceptionOfType(BankAccountActionInvalidException.class)
                .isThrownBy(bankAccount::getBalance)
                .withMessage("Account closed");
    }

    @Test
    public void canAdjustBalanceConcurrently() throws BankAccountActionInvalidException, InterruptedException {
        bankAccount.open();
        bankAccount.deposit(1000);

        for (int i = 0; i < 10; i++) {
            adjustBalanceConcurrently();
            Assertions.assertThat(bankAccount.getBalance()).isEqualTo(1000);
        }
    }

    @Test
    public void canAdjustBalanceConcurrently1() throws BankAccountActionInvalidException, InterruptedException {
        bankAccount.open();
        bankAccount.deposit(1000);

        for (int i = 0; i < 10; i++) {
            adjustBalanceConcurrently();
            Assertions.assertThat(bankAccount.getBalance()).isEqualTo(1000);
        }
    }

    private void adjustBalanceConcurrently() throws InterruptedException {
        Random random = new Random();

        Thread[] threads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(() -> {
                try {
                    bankAccount.deposit(5);
                    Thread.sleep(random.nextInt(10));
                    bankAccount.withdraw(5);
                } catch (BankAccountActionInvalidException e) {
                    fail("Exception should not be thrown: " + e.getMessage());
                } catch (InterruptedException ignored) {
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
