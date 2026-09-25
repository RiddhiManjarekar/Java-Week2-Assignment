package BankingSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Entry point for the Banking System application.
 * Provides a console-based menu for performing
 * banking operations.
 */

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        int choice = 0;

        do {

            System.out.println();
            System.out.println("***** BANKING SYSTEM *****");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Check Balance");
            System.out.println("7. View Account Statement");
            System.out.println("8. View All Accounts");
            System.out.println("9. Exit");
            

            try {

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Enter account holder name: ");
                        String savingsHolder = sc.nextLine();

                        BankAccount savingsAccount =
                                bank.createSavingsAccount(savingsHolder);

                        System.out.println(
                                "Savings account created successfully."
                        );
                        System.out.println(
                                "Account Number: "
                                        + savingsAccount.getAccountNum()
                        );
                        System.out.println(
                                "Account Holder: "
                                        + savingsAccount.getAccountHolder()
                        );

                        break;

                    case 2:

                        System.out.print("Enter account holder name: ");
                        String currentHolder = sc.nextLine();

                        BankAccount currentAccount =
                                bank.createCurrentAccount(currentHolder);

                        System.out.println(
                                "Current account created successfully."
                        );
                        System.out.println(
                                "Account Number: "
                                        + currentAccount.getAccountNum()
                        );
                        System.out.println(
                                "Account Holder: "
                                        + currentAccount.getAccountHolder()
                        );

                        break;

                    case 3:

                        System.out.print("Enter account number: ");
                        String depositAccount = sc.nextLine();

                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        sc.nextLine();

                        bank.deposit(depositAccount, depositAmount);

                        System.out.println(
                                "Amount deposited successfully."
                        );
                        System.out.printf(
                                "Current Balance: Rs.%.2f%n",
                                bank.getBalance(depositAccount)
                        );

                        break;

                    case 4:

                        System.out.print("Enter account number: ");
                        String withdrawAccount = sc.nextLine();

                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = sc.nextDouble();
                        sc.nextLine();

                        bank.withdraw(withdrawAccount, withdrawAmount);

                        System.out.println(
                                "Amount withdrawn successfully."
                        );
                        System.out.printf(
                                "Current Balance: Rs.%.2f%n",
                                bank.getBalance(withdrawAccount)
                        );

                        break;

                    case 5:

                        System.out.print("Enter sender account number: ");
                        String fromAccount = sc.nextLine();

                        System.out.print("Enter receiver account number: ");
                        String toAccount = sc.nextLine();

                        System.out.print("Enter transfer amount: ");
                        double transferAmount = sc.nextDouble();
                        sc.nextLine();

                        bank.transfer(
                                fromAccount,
                                toAccount,
                                transferAmount
                        );

                        System.out.println(
                                "Amount transferred successfully."
                        );

                        System.out.printf(
                                "Sender Balance: Rs.%.2f%n",
                                bank.getBalance(fromAccount)
                        );

                        System.out.printf(
                                "Receiver Balance: Rs.%.2f%n",
                                bank.getBalance(toAccount)
                        );

                        break;

                    case 6:

                        System.out.print("Enter account number: ");
                        String balanceAccount = sc.nextLine();

                        System.out.printf(
                                "Current Balance: Rs.%.2f%n",
                                bank.getBalance(balanceAccount)
                        );

                        break;

                    case 7:

                        System.out.print("Enter account number: ");
                        String statementAccount = sc.nextLine();

                        bank.getStatement(statementAccount);

                        break;

                    case 8:

                        bank.displayAllAccounts();

                        break;

                    case 9:

                        System.out.println("Exit..");

                        break;

                    default:

                        System.out.println(
                                "Invalid choice. Please choose between 1 and 9."
                        );
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input. Please enter a valid number."
                );

                sc.nextLine();

            } catch (BankingSystemException e) {

                System.out.println(
                        "Banking Error: " + e.getMessage()
                );
            }

        } while (choice != 9);

        sc.close();
    }
}