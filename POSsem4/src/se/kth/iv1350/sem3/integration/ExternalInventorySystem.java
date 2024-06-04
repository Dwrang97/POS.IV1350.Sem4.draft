package se.kth.iv1350.sem3.integration;

import se.kth.iv1350.sem3.model.Sale;

import java.util.List;

/**
 * This class is a placeholder for the real external inventory system.
 * In this application it contains hardcoded inventory information and will distribute this information when called,
 * based on an item identifier.
 */
public class ExternalInventorySystem {

private double itemPrice;

private double itemVAT;

private String itemDescription;

private String itemName;

    /**
     * This method retrieves the information of an item using the Identifier of said item.
     * @param itemID Identifier of the item.
     * @return Returns a DTO containing information about the item.
     */
    public ItemDTO getItemInfo(int itemID) throws IdentifierNotFoundException {

        fakeDataBase(itemID);
    return new ItemDTO(itemPrice, itemVAT, itemID, itemDescription, itemName);
}
    //Placeholder for the real external inventory system//
    private void fakeDataBase(int itemID) throws IdentifierNotFoundException {
      switch(itemID){
          case 11:
              itemName = "Bread";
              itemDescription = "Loaf of whole wheat bread";
              itemPrice = 24.99;
              itemVAT = 0.06;
              break;
          case 12:
              itemName = "Eggs";
              itemDescription = "Dozen large eggs";
              itemPrice = 35.0;
              itemVAT = 0.12;
              break;
          case 13:
              itemName = "Milk";
              itemDescription = "Organic milk, 1 liter";
              itemPrice = 13.0;
              itemVAT = 0.25;
              break;
          case 14:
              throw new DatabaseAccessUnavailableException("The external inventory system could not be accessed");
          default:
              throw new IdentifierNotFoundException(itemID);
      }
    }

    /**
     * <code>sendSaleInformation</code> sends information about the sale to the external inventory system, but is not
     * implemented further then a method representing that part.
     * * @param sale is the sale object that will be sent to the external inventory system.
     */
    public void sendSaleInformation(Sale sale){

    }

}
