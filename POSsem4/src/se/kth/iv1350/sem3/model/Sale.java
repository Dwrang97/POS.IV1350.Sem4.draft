package se.kth.iv1350.sem3.model;

import se.kth.iv1350.sem3.integration.IdentifierNotFoundException;
import se.kth.iv1350.sem3.integration.ItemDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This class creates and updates the sale with want the customer want to buy.
 */
public class Sale {


    private LocalDateTime timeOfSale;
    private final List<ItemWithQuantity> itemsInSale;
    private double totalPrice;

    /**
     * This class initializes a sale.
     */
    public Sale() {
        setTimeOfSale();
        itemsInSale = new ArrayList<>();
        double totalPrice = 0;

    }

    private void setTimeOfSale() {
        timeOfSale = LocalDateTime.now();
    }

    /**
     * This method checks if the item identifier is valid.
     * This method is also used to update the <code>itemsInSale</code> arraylist of the sale object.
     *
     * @param itemInfo The DTO of an item.
     */
    public void updateSaleInfo(ItemDTO itemInfo)  {
        if (checkIfValidID(itemInfo)) {
            if (!itemAlreadyInSale(itemInfo)) {
                addNewItemToSale(itemInfo);
                increaseTotalPrice(itemInfo);
            }
        }
    }


    private boolean itemAlreadyInSale(ItemDTO itemInfo) {
        int itemBeingSoldID = itemInfo.getItemID();

        for (ItemWithQuantity itemwithQuantity : itemsInSale) {
            if (itemBeingSoldID == itemwithQuantity.getItemID()) {
                itemwithQuantity.increaseItemQuantity();
                increaseTotalPrice(itemInfo);
                return true;
            }
        }
        return false;
    }

    private void addNewItemToSale(ItemDTO itemInfo) {
        itemsInSale.add(new ItemWithQuantity(itemInfo));
    }

    private boolean checkIfValidID(ItemDTO itemInfo) {
        return !itemInfo.getItemName().equalsIgnoreCase("Unknown item");
    }

    private double calculateTotalPrice(ItemDTO itemInfo) {
        return itemInfo.getItemPrice() * (1 + itemInfo.getItemVAT());
    }

    private void increaseTotalPrice(ItemDTO itemInfo) {
        totalPrice += calculateTotalPrice(itemInfo);
    }

    /**
     * Getter method for the total price of the sale.
     *
     * @return Returns the total price of the sale.
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Calculates the change the customer will receive.
     *
     * @param paidAmount The amount paid by the customer for the sale.
     * @return Returns the change the customer will receive.
     */
    public double calculateChange(double paidAmount) {
        return paidAmount - totalPrice;
    }

    /**
     * Getter method for the list of items in the sale.
     *
     * @return Returns a list of the items in the sale.
     */
    public List<ItemWithQuantity> getItemsInSale() {
        return itemsInSale;
    }

    /**
     * Getter method for the time of the sale.
     *
     * @return Returns the time of the sale.
     */
    public LocalDateTime getTimeOfSale() {
        return timeOfSale;
    }

}
