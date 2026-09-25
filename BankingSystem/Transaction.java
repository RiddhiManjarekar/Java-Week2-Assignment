package BankingSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a banking transaction containing
 * its type, amount, and date/time.
 */

public class Transaction {

    private String transactionType;
    private double amount;
    private LocalDateTime date;

    public Transaction(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return transactionType
                + " | Rs."
                + String.format("%.2f", amount)
                + " | " +
                date.format(formatter);

    }

}
