package main.java.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;

public class InterestFileReader {
    private String csvFilePath = "";
    private String line = "";
    private String csvSplitBy = "";
    private int balanceBeforeCalculation = 0;
    private int requiredPercentage = 0;

    public InterestFileReader(String path, String separator) {
        csvFilePath = path;
        csvSplitBy = separator;
    }

    public BigDecimal getRequiredPercentage(BigDecimal balance) {
        int percentageForCalculation = 0;

        try ( BufferedReader br = new BufferedReader(new java.io.FileReader(csvFilePath))) {
            while ((line = br.readLine()) != null) {
                String[] fileData = line.split(csvSplitBy);
                int lineMinimum = Integer.parseInt(fileData[0]);
                int lineMaximum = Integer.parseInt(fileData[1]);
                int linePercentage = Integer.parseInt(fileData[2]);

                if (balance.intValue() > lineMinimum && balance.intValue() <= lineMaximum) {
                    percentageForCalculation = linePercentage;
                    System.out.println("Percentage used for calculation: " + percentageForCalculation);
                }
            }

        } catch (IOException e) {
            System.out.println("Sciezka do pliku: " + csvFilePath + " nie zostala znaleziona");
            e.printStackTrace();
        }

        return new BigDecimal(percentageForCalculation);
    }
}
