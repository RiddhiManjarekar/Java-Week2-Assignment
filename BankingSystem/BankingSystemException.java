package BankingSystem;

/**
 * Custom runtime exception used for banking-related
 * validation and account errors.
 */

public class BankingSystemException extends RuntimeException{
   public BankingSystemException(String msg){
    super(msg);
   }
}