package se.kth.iv1350.sem3.model;

import se.kth.iv1350.sem3.controller.Controller;

import java.time.format.DateTimeFormatter;

/**
 * <code>Receipt</code> creates a printable receipt.
 */
public class Receipt {

    private String output;



    private StringBuilder createReceipt(Sale sale, double payment){
    StringBuilder output = new StringBuilder();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    double totalVAT = 0;

    output.append("\nTime of sale: ").append(sale.getTimeOfSale().format(formatter));
    output.append("\n\n");
    for(ItemWithQuantity itemWithQuantity: sale.getItemsInSale()){
        output.append(String.format("%-25s", itemWithQuantity.getItemName()));
        output.append(String.format("%-2d",itemWithQuantity.getItemQuantity()));
        output.append(" x ");
        output.append(String.format("%-5.2f SEK", getTotalPriceForOneItem(itemWithQuantity)));
        output.append(String.format("%6.2f SEK",
                getTotalPriceForOneItem(itemWithQuantity)*itemWithQuantity.getItemQuantity())).append("\n");
        totalVAT += (calculateTotalVatForSale(itemWithQuantity)*itemWithQuantity.getItemQuantity());
    }
    output.append("\nTotal: ").append(String.format("%5.2f SEK", sale.getTotalPrice()));
    output.append(String.format("\nVAT: %5.2f SEK",totalVAT));
    output.append("\n\nPaid amount: ").append(String.format("%5.2f SEK",payment));
    output.append("\nChange: ").append(String.format("%5.2f SEK", sale.calculateChange(payment)));

    return output;
    }

    private double getTotalPriceForOneItem(ItemWithQuantity itemWithQuantity){
        return itemWithQuantity.getItemPrice()*(1+itemWithQuantity.getItemVAT());
    }

    private double calculateTotalVatForSale(ItemWithQuantity itemWithQuantity){
        return itemWithQuantity.getItemPrice()*itemWithQuantity.getItemVAT();
    }
    /**
     * This class calls the <code>createReceipt</code> method to create a printable receipt.
     * @param sale the sale details to be included in the receipt.
     * @param payment the payment details to be included in the receipt.
     */
    public void setReceipt(Sale sale, double payment){
        output = String.valueOf(createReceipt(sale, payment));
    }

    /**
     * Getter method for the created receipt.
     * @return Returns the created receipt.
     */
    public String getReceipt() {
        return output;
    }
}

