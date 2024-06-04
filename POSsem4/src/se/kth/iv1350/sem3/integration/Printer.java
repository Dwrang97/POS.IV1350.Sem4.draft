package se.kth.iv1350.sem3.integration;

import se.kth.iv1350.sem3.model.Receipt;

/**
 * This class is a placeholder for a real printer, it's used to print the receipt to the console.
 */
public class Printer {

    private Printer printer;

    /**
     * Prints the receipt to the console.
     * @param receipt The receipt of the sale
     */
    public void printReceipt(Receipt receipt){
        System.out.print(receipt.getReceipt());
    }

}
