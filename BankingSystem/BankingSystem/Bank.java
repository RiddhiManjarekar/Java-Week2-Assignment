package BankingSystem;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages bank accounts and provides banking operations
 * such as account creation, deposits, withdrawals,
 * transfers, and account statements.
 */

public class Bank {

    private Map<String, BankAccount> accounts;

    private long newAccountNum = 11101;

    public Bank() {
        accounts = new HashMap<>();
    }

    public BankAccount createSavingsAccount(String accountHolder) {
        String accountNum = generateAccountNumber();

        BankAccount account = new SavingsAccount(accountNum, accountHolder);

        accounts.put(accountNum, account);

        return account;
    }

    public BankAccount createCurrentAccount(String accountHolder) {
        String accountNum = generateAccountNumber();

        BankAccount account = new CurrentAccount(accountNum, accountHolder);
        accounts.put(accountNum, account);
        return account;
    }

    private String generateAccountNumber() {
        return String.valueOf(newAccountNum++);
    }

    public BankAccount getAccount(String accountNum) {
        BankAccount account = accounts.get(accountNum);

        if (account == null) {
            throw new BankingSystemException("Account not found: " + accountNum);
        }
        return account;
    }

    public void deposit(String accountNum, double amount) {
        BankAccount account = getAccount(accountNum);
        account.deposit(amount);
    }

    public void withdraw(String accountNum, double amount) {
        BankAccount account = getAccount(accountNum);
        account.withdraw(amount);
    }

    public void transfer(String fromAcc, String toAcc, double amount) {
        if (fromAcc.equals(toAcc)) {
            throw new BankingSystemException(
                    "Source and destination accounts cannot be the same");
        }

        BankAccount fromAccount = getAccount(fromAcc);
        BankAccount toAccount = getAccount(toAcc);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    public double getBalance(String accountNum) {
        return getAccount(accountNum).getBalance();
    }

    public void getStatement(String accountNum) {
        BankAccount account = getAccount(accountNum);
        System.out.println("*****Account Statement*****");

        System.out.println("Account Number: " + account.getAccountNum());

        System.out.println("Account Holder: " + account.getAccountHolder());

        System.out.println("Balance :Rs." + String.format("%.2f", account.getBalance()));

        System.out.println("---------");
        if (account.getTransactions().isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction transaction : account.getTransactions()) {
                System.out.println(transaction);
            }
        }
        System.out.println("--------");
        System.out.println("Current Balance: Rs." + String.format("%.2f", account.getBalance()));
        System.out.println("========");
    }

    public void displayAllAccounts() {
        System.out.println("===All Accounts===");
        if (accounts.isEmpty()) {
            System.out.println("No accounts found");
            return;
        }

        for (BankAccount account : accounts.values()) {
            System.out.println(
                    account.getAccountNum()
                            + " | "
                            + account.getAccountHolder()
                            + " | Rs."
                            + String.format("%.2f", account.getBalance()));
        }
        System.out.println("======");
    }

}
