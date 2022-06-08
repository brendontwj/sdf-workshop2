package vttp2022.workshop2;

import java.util.*;
import java.time.LocalDateTime;

public class BankAccount {
    // Bank Account
    private final String name;
    // generated account id from the UUID classs
    private final String acctID = UUID.randomUUID().toString().substring(0,8);
    // holds the bank acc balance
    private float balance = 0f;
    // list of transaction history on the bank account object
    private List<String> transaction = new LinkedList<String>();
    // Whether account is closed or not
    private boolean isClosed = false;

    
    // Constructor with bank account name
    public BankAccount(String name) {
        this.name = name;
        this.balance = 0;
    }
    // Second constructor with bank account name and the initial balance
    public BankAccount(String name, float initialBal) {
        this.name = name;
        this.balance = initialBal;
    }

    // Getter and setter for the rest of the properties
    public String getName() {
        return name;
    }

    // public void setName(String name) {
    //     this.name = name;
    // }

    public String getAcctID() {
        return acctID;
    }

    // public void setAcctID(String acctID) {
    //     this.acctID = acctID;
    // }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<String> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    protected float withdraw(String withdrawalAmount) {
        Float withdrawalAmountF = null;
        try {
            withdrawalAmountF = Float.parseFloat(withdrawalAmount);
            if (withdrawalAmountF.floatValue() <= 0) {
                throw new IllegalArgumentException("Withdrawal amount cannot be negative or zero.");
            }

            if (withdrawalAmountF.floatValue() > this.balance) {
                throw new IllegalArgumentException("Cannot withdraw more than currently owned.");
            }

            if (this.isClosed) {
                throw new IllegalArgumentException("Account is closed.");
            }

            // update the withdraw amount
            this.balance = this.balance - withdrawalAmountF.floatValue();
            // Construct the transaction history event log
            StringBuilder txnStrBld = new StringBuilder();
            txnStrBld.append("Withdrawal $");
            txnStrBld.append(withdrawalAmountF.floatValue());
            txnStrBld.append(" at ");
            txnStrBld.append(LocalDateTime.now());
            System.out.println(txnStrBld.toString());
            // Save the event log into the transaction linkedlist
            transaction.add(txnStrBld.toString());
        } catch(NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Invalid deposit amount. ");
        }
        return this.balance;
    }

    protected void deposit(String depositAmount) {
        try {
            Float depositAmountF = Float.parseFloat(depositAmount);
            if (depositAmountF.floatValue() <= 0) {
                throw new IllegalArgumentException("Deposit amount cannot be negative or zero. ");
            }

            if (this.isClosed) {
                throw new IllegalArgumentException("Account is closed.");
            }

            // update the deposit amount
            this.balance = this.balance + depositAmountF.floatValue();
            // Construct the transaction history event log
            StringBuilder txnStrBld = new StringBuilder();
            txnStrBld.append("Deposit $");
            txnStrBld.append(depositAmountF.floatValue());
            txnStrBld.append(" at ");
            txnStrBld.append(LocalDateTime.now());
            System.out.println(txnStrBld.toString());
            // Save the event log into the transaction linkedlist
            transaction.add(txnStrBld.toString());
        } catch(NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Invalid deposit amount. ");
        }
    }
}
