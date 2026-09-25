package BankingSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class representing a bank account.
 * Provides common account information, balance management,
 * deposits, and transaction history.
 */

public abstract class BankAccount {

    private String accountNum;
    private String accountHolder;
    protected double balance;

    private List<Transaction> transactions;

    public BankAccount(String accountNum,String accountHolder){
        this.accountNum=accountNum;
        this.accountHolder=accountHolder;
        this.balance=0.0;
        this.transactions=new ArrayList<>();
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public abstract void withdraw(double amount);

    public void deposit(double amount){
        if(amount<=0){
            throw new BankingSystemException("Deposit amount must be greater than 0");
        }
        balance+=amount;

        transactions.add(new Transaction("DEPOSIT",amount));
    }
    
}
