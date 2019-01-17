package main.java.com;

import main.java.com.AccountBalance;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        System.out.println("Calculate account balance after one year");
        new AccountBalance().calculateAccountBalance(100, Optional.empty(), Optional.empty());
    }


}
