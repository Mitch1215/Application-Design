package StockMarket;

import java.util.Scanner;

public class Main {

    public static int getIntegerInput(Scanner in, boolean lowerLimitFlag, int lowerLimit, boolean upperLimitFlag, int upperLimit, String prompt, String errorMsg) {
        boolean validInput = false;
        int num = 0;

        while (validInput != true) {
            validInput = true;
            System.out.println(prompt);
            num = in.nextInt();
            
            try {
                if (num < 0) {}
            } catch (NumberFormatException nfe) {
                System.out.println(errorMsg);
            } // End try-catch block

            if (lowerLimitFlag && num < lowerLimit) {
                System.out.println(errorMsg);
                validInput = false;
            }

            if (upperLimitFlag && num > upperLimit) {
                System.out.println(errorMsg);
                validInput = false;
            }
        } // End while loop
        return num;
    } // End getDoubleInput

    public static double getDoubleInput(Scanner in, boolean lowerLimitFlag, int lowerLimit, boolean upperLimitFlag, int upperLimit, String prompt, String errorMsg) {
        boolean validInput = false;
        double num = 0;

        while (validInput != true) {
            validInput = true;
            System.out.println(prompt);
            num = in.nextDouble();
            
            try {
                if (num < 0) {}
            } catch (NumberFormatException nfe) {
                System.out.println(errorMsg);
            } // End try-catch block

            if (lowerLimitFlag && num < lowerLimit) {
                System.out.println(errorMsg);
                validInput = false;
            }

            if (upperLimitFlag && num > upperLimit) {
                System.out.println(errorMsg);
                validInput = false;
            }
        } // End while loop
        return num;
    } // End getDoubleInput

    public static void main(String[] args) {
        Main op = new Main();
    
       Scanner input = new Scanner(System.in);
       int userInput = 0;

       Stock[] stockArray = new Stock[10];
       String companyName;
       String stockSymbol;
       double current;
       double low;
       double high;
       int numStocks = 0;
       
       // Import the data of stocks from the spreadsheet

       while (userInput != 4) {
            userInput = getIntegerInput(input, true, 0, true, 4, "Enter 0 if you want to add a stock\nEnter 1 if you want stock statistics\nEnter 2 if you want to output stock data to file stockdata.txt\nEnter 3 if you want to delete a stock\nEnter 4 if you want to exit", "Invalid input. Please try again.");

            // Add or get stock information 
            if (userInput == 0) {
                if (stockArray.length == 10) {
                    System.out.println("Cannot add another stock - our list is full.");
                    continue;
                }

                companyName = input.nextLine();
                stockSymbol = input.nextLine();
                stockSymbol = stockSymbol.toUpperCase();
                low = getDoubleInput(input, true, 0, false, 1, "Please enter the 52 week low for " + companyName, "Invalid input, try again.");
                high = getDoubleInput(input, true, 0, false, 1, "Please enter the 52 week high for " + companyName, "Invalid input, try again.");
                current = getDoubleInput(input, true, 0, false, 1, "Please enter the current price for " + companyName, "Invalid input, try again.");

                Stock newStock = new Stock(companyName, stockSymbol, current, low, high);
                stockArray[numStocks] = newStock;
                numStocks++;
            } // End if userInput == 0

            // View stock statistics
            if (userInput == 1) {

            } // End if userInput == 1

            if (userInput == 2) {

            } // End if userInput == 2

            if (userInput == 3) {

            } // End if userInput == 3

       } // End while loop

    } // End main method
    
} // End Main class
