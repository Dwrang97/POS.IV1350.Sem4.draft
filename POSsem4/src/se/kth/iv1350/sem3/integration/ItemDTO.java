package se.kth.iv1350.sem3.integration;

/**
 * This class contains info about the items and is used to transfer that information.
 */
public class ItemDTO {

    private final double itemPrice;
    private final double itemVAT;
    private final int itemID;
    private final String itemDescription;
    private final String itemName;

    /**
     * Constructs a new item with the specified details.
     * @param itemPrice THe price of the item.
     * @param itemVAT The VAT-rate of the item.
     * @param itemID The ID of the item.
     * @param itemDescription The description of the item.
     * @param itemName The name of the item.
     */
    public ItemDTO(double itemPrice, double itemVAT, int itemID, String itemDescription, String itemName){
        this.itemPrice = itemPrice;
        this.itemVAT = itemVAT;
        this.itemID = itemID;
        this.itemDescription = itemDescription;
        this.itemName = itemName;
    }

    /**
     * Getter method for the price of an item.
     * @return Returns the price of an item.
     */
    public double getItemPrice() {
        return itemPrice;
    }

    /**
     * Getter method for the VAT-rate of an item.
     * @return Returns the VAT-rate of an item.
     */
    public double getItemVAT() {
        return itemVAT;
    }

    /**
     * Getter method for the ID of an item.
     * @return Returns the ID of an item.
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * Getter method for the description of an item.
     * @return Returns the description of an item.
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Getter method for the name of an item.
     * @return Returns the name of an item.
     */
    public String getItemName() {
        return itemName;
    }
}
