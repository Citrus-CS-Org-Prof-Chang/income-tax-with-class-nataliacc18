package edu.pasadena.cs.cs03b;

import java.util.Scanner;

public class TaxTableTools { 

    private int[] salaryTable;
    private double[] taxRateTable;

    public TaxTableTools() {
        
        // matches tax
        this.salaryTable = new int[]{23201, 94301, 201051, 383901, 487451, 731201};
        this.taxRateTable = new double[]{0.12, 0.22, 0.24, 0.32, 0.35, 0.37};
    }


public double getTaxRate(double annualIncome) {
    
    for (int i = 0; i < salaryTable.length; i++) {
        if (annualIncome <= salaryTable [i]) {
            return taxRateTable[i];
        }
    }

    return taxRateTable[taxRateTable.length -1];

}

public double calculateTax(double annualIncome) { 
    double taxRate = getTaxRate(annualIncome);
    return annualIncome * taxRate;

}

public static void main(String[] args) {
    
    TaxTableTools taxTools = new TaxTableTools(); 
    Scanner scanner = new Scanner(System.in);

    // true = repeats until break; -1 stops program

    while (true) {
        System.out.println("Enter annual income (-1 to exit):");
        double income = scanner.nextDouble(); 

        if (income == -1) {
            System.out.println("Now exiting program...");
            break;
        }
        
        // rate and tax for input

        double taxRate = taxTools.getTaxRate(income); 
        double taxAmount = taxTools.calculateTax(income);

        System.out.printf("Annual Income: %.2f Tax Rate: %.2f%% Tax to pay: %.2f\n", income, taxRate * 100, taxAmount);

    }

    scanner.close();
}

}