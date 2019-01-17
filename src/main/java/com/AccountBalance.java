package main.java.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class AccountBalance {

    public double calculateAccountBalance(double enteredAmount, Optional<String> pathToFile, Optional<String> separator) {

        String csvFilePath  = pathToFile.isPresent() ? pathToFile.get() : "../../../percentageDetails.csv";
        String line = "";
        String csvSplitBy = separator.isPresent() ? separator.get() : ",";
        double requiredPercentage = 0;


        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            while ((line = br.readLine()) != null) {
                String[] fileData = line.split(csvSplitBy);
                int lineMinimum = Integer.parseInt(fileData[0]);
                int lineMaximum = Integer.parseInt(fileData[1]);
                double linePercentage = Double.parseDouble(fileData[2]);

                if (enteredAmount > lineMinimum && enteredAmount <= lineMaximum) {
                    requiredPercentage = linePercentage;
                }

                System.out.println("Percentage used for calculation: " + requiredPercentage);

            }

        } catch (IOException e) {
            System.out.println("Sciezka do pliku: " + csvFilePath + " nie zostala znaleziona");
            e.printStackTrace();
        }


        double percentage = (100 + requiredPercentage) / 100;

        double finalBalance = enteredAmount * percentage;
        System.out.println("Calculated final balance: " + finalBalance);

        return finalBalance;


    }
}
