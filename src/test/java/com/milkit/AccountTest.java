package com.milkit;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);
        account.deposit(20);
        account.withdraw(20);
        
System.out.println("epsilon:"+epsilon);
System.out.println(account.getOverdraftLimit());

        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }
}

class Account {
    private double balance;
    private double overdraftLimit;
    
    public Account(double overdraftLimit) {
        this.balance = 0;
        this.overdraftLimit = overdraftLimit > 0 ? overdraftLimit : 0;
    }
    
    public boolean deposit(double amount) {
        if(amount >= 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(double amount) {
        if(this.balance - amount >= -this.overdraftLimit && amount >= 0) {
            this.balance -= amount;
            return true;
        }
        return false;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}