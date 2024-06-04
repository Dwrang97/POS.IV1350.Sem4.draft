package se.kth.iv1350.sem3.integration;

/**
 * Thrown when an item identifier could not be found.
 */
public class IdentifierNotFoundException extends Exception{
    /**
     * Constructs a new IdentifierNotFoundException exception with a message containing the specified item identifier.
     * @param itemID the item identifier of the item that could not be found.
     */
    public IdentifierNotFoundException(int itemID){
        super("\nItem with itemID " + itemID + " could not be found");

    }
}
