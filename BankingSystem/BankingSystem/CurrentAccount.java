package BankingSystem;

public class CurrentAccount extends BankAccount{
    
    public CurrentAccount(String accountNum,String accountHolder){
        super(accountNum, accountHolder);
    }
    public void withdraw(double amount){
        if(amount<=0){
            throw new BankingSystemException("Withdrawal amount must be greater than 0");
        }

        if(amount>balance){
            throw new BankingSystemException("Insufficient funds");
        }

        
        balance-=amount;

        getTransactions().add(new Transaction("WITHDRAW", amount));
    }
}
