package BankingSystem;

public class SavingsAccount extends BankAccount {

    private static final double MINIMUM_BALANCE=1000.00;

    public SavingsAccount(String accountNum,String accountHolder){
        super(accountNum, accountHolder);
    }

    public void withdraw(double amount){
        if(amount<=0){
            throw new BankingSystemException("Withdrawal amount must be greater than 0");
        }

        if(amount>balance){
            throw new BankingSystemException("Insufficient funds");
        }

        if(balance-amount<MINIMUM_BALANCE){
            throw new BankingSystemException("Can't withdraw..Minimum balance of Rs. "+MINIMUM_BALANCE+" is required");
        }

        balance-=amount;

        getTransactions().add(new Transaction("WITHDRAW", amount));
    }

    public double getMinimumBalance(){
        return MINIMUM_BALANCE;
    }

    
}
