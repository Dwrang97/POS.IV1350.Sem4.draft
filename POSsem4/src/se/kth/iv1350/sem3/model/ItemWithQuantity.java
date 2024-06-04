package se.kth.iv1350.sem3.model;

import se.kth.iv1350.sem3.integration.ItemDTO;

/**
 * This class contains information about each item being sold, including quantity.
 */
public class ItemWithQuantity {
    private final String itemName;
    private final double itemPrice;
    private final double itemVAT;
    private final int itemID;
    private int itemQuantity;

    /**
     * Constructor for items that will be added to sale object <code>itemsInSale</code> array list.
     * @param itemInfo The DTO of an item being sold.
     */
    public ItemWithQuantity(ItemDTO itemInfo){
        this.itemName = itemInfo.getItemName();
        this.itemPrice = itemInfo.getItemPrice() >= 0?itemInfo.getItemPrice():0;
        this.itemVAT = itemInfo.getItemVAT() >= 0?itemInfo.getItemVAT():0;
        this.itemID = itemInfo.getItemID();
        this.itemQuantity = 1;
    }

    /**
     * This method increases the quantity of an item in the sale.
     */
    public void increaseItemQuantity(){
        itemQuantity++;
    }

    /**
     * Getter method for the name of an item.
     * @return Returns the name of an item.
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * Getter method for the price of an item.
     * @return Returns the price of an item.
     */
    public double getItemPrice(){
        return itemPrice;
    }

    /**
     * Getter method for the VAT-rate of an item.
     * @return Returns the VAT-rate of an item.
     */
    public double getItemVAT(){
        return itemVAT;
    }

    /**
     * Getter method for the ID of an item.
     * @return Returns the ID of an item.
     */
    public int getItemID(){
        return itemID;
    }

    /**
     * Getter method for the quantity of an item in the <code>itemsInSale</code> array list.
     * @return Returns the quantity of an item in the <code>itemsInSale</code> array list.
     */
    public int getItemQuantity() {
        return itemQuantity;
    }
}
