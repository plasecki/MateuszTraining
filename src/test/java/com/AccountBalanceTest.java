package test.java.com;

import main.java.com.AccountBalance;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

public class AccountBalanceTest {
    AccountBalance accountBalance = new AccountBalance();

    @org.testng.annotations.BeforeMethod
    public void setUp() {
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() {
    }

    @Test
    public void testCalculateRangeOne() {
        double balance = accountBalance.calculateAccountBalance(10000, Optional.empty(), Optional.empty());
        Assert.assertEquals(balance, 10100.0 , "Incorrect calculation for range below 10k");
    }

    @Test
    public void testCalculateRangeTwo() {
        double balance = accountBalance.calculateAccountBalance(100000, Optional.empty(), Optional.empty());
        Assert.assertEquals(balance, 102000.0 , "Incorrect calculation for range from 10k to 100k");
    }

    @Test
    public void testCalculateRangeThree() {
        double balance = accountBalance.calculateAccountBalance(1000000, Optional.empty(), Optional.empty());
        Assert.assertEquals(balance, 1030000.0 , "Incorrect calculation for range from 100k to 1 milion");
    }
}