package main.java.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;


public class AccountBalance {
    private BigDecimal balance = BigDecimal.ZERO;

    public AccountBalance(BigDecimal enteredBalance) {
        balance = enteredBalance;
    }

    public void calculateAccountBalanceAfterOneYear(BigDecimal percentage) {
        BigDecimal oneHundred = new BigDecimal(100);
        System.out.println("Balance: " + balance);
        BigDecimal x = percentage.add(oneHundred);
        BigDecimal y = x.divide(oneHundred);

        balance = balance.multiply(y);
        System.out.println("Calculated balance after a year: " + balance);
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
