package test.java.com;

import main.java.com.AccountBalance;
import main.java.com.InterestFileReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Optional;

public class AccountBalanceTest {
    String csvFilePath = "../../../percentageDetails.csv";

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testCalculateRangeBelow10k() {
        BigDecimal balance = new BigDecimal(10000);
        AccountBalance accountBalance = new AccountBalance(balance);
        InterestFileReader fileReader = new InterestFileReader(csvFilePath, ",");
        accountBalance.calculateAccountBalanceAfterOneYear(fileReader.getRequiredPercentage(balance));
        Assert.assertTrue((accountBalance.getBalance().compareTo(new BigDecimal(10100)) == 0) ,
                "Incorrect calculation for range below 10k");

    }

    @Test
    public void testCalculateRangeBelow100k() {
        BigDecimal balance = new BigDecimal(100000);
        AccountBalance accountBalance = new AccountBalance(balance);
        InterestFileReader fileReader = new InterestFileReader(csvFilePath, ",");
        accountBalance.calculateAccountBalanceAfterOneYear(fileReader.getRequiredPercentage(balance));
        Assert.assertTrue((accountBalance.getBalance().compareTo(new BigDecimal(102000)) == 0) ,
                "Incorrect calculation for range below 100k");

    }

    @Test
    public void testCalculateRangeBelow1M() {
        BigDecimal balance = new BigDecimal(1000000);
        AccountBalance accountBalance = new AccountBalance(balance);
        InterestFileReader fileReader = new InterestFileReader(csvFilePath, ",");
        accountBalance.calculateAccountBalanceAfterOneYear(fileReader.getRequiredPercentage(balance));
         Assert.assertTrue((accountBalance.getBalance().compareTo(new BigDecimal(1030000)) == 0) ,
                 "Incorrect calculation for range below 1M");

    }
}