package se.kth.iv1350.sem3.view;

import se.kth.iv1350.sem3.controller.Controller;
import se.kth.iv1350.sem3.integration.IdentifierNotFoundException;
import se.kth.iv1350.sem3.integration.ItemDTO;
import se.kth.iv1350.sem3.controller.FailedSystemOperationException;

/**
 * This class handles interactions with the user. The class is a placeholder for the user interface.
 */
public class View {

    private final Controller controller;

    /**
     *  Constructor method for initializing the <code>view</code> with an object of <code>Controller</code>.
      * @param controller The <code>Controller</code> that manages the operations of the <code>view</code>.
     */
    public View(Controller controller){
        this.controller = controller;
    }

    /**
     * This method simulates a run of the application as it is intended in real use,
     * by calling methods in the controller.
     */
    public void makeSaleFLow(){
        controller.startNewSale();
        double totalPrice;
        ItemDTO itemInfo;
        System.out.println("A new sale has been started");
        try {
            itemInfo = controller.enterItemID(11);
            totalPrice = controller.getRunningTotal();

            displayItem(itemInfo, totalPrice);
        }catch (IdentifierNotFoundException identifierNotFoundException) {
            System.out.println(identifierNotFoundException.getMessage());

        } catch (FailedSystemOperationException e) {
            System.out.println("\nCould not perform system operation, please try again");
        }
        try{
            itemInfo = controller.enterItemID(12);
            totalPrice = controller.getRunningTotal();

            displayItem(itemInfo, totalPrice);
        }catch (IdentifierNotFoundException identifierNotFoundException) {
            System.out.println(identifierNotFoundException.getMessage());

        } catch (FailedSystemOperationException e) {
            System.out.println("\nCould not perform system operation, please try again");
        }
         try{
            itemInfo = controller.enterItemID(13);
            totalPrice = controller.getRunningTotal();

            displayItem(itemInfo, totalPrice);
         }catch (IdentifierNotFoundException identifierNotFoundException) {
             System.out.println(identifierNotFoundException.getMessage());

         } catch (FailedSystemOperationException e) {
             System.out.println("\nCould not perform system operation, please try again");
         }
          try{
            itemInfo = controller.enterItemID(22);
            totalPrice = controller.getRunningTotal();

            displayItem(itemInfo,totalPrice);
          }catch (IdentifierNotFoundException identifierNotFoundException) {
              System.out.println(identifierNotFoundException.getMessage());

          } catch (FailedSystemOperationException e) {
              System.out.println("\nCould not perform system operation, please try again");
          }
           try{
            itemInfo = controller.enterItemID(14);
            totalPrice = controller.getRunningTotal();

            displayItem(itemInfo,totalPrice);
        }catch (IdentifierNotFoundException identifierNotFoundException) {
            System.out.println(identifierNotFoundException.getMessage());

        } catch (FailedSystemOperationException e) {
            System.out.println("\nCould not perform system operation, please try again");
        }

           totalPrice = controller.endSale();
           System.out.println("\nEnd sale:");
           System.out.printf("Total cost(incl VAT): %2.2f SEK", totalPrice);

        double payment = 100;
        System.out.println("\n\nAmount paid by customer: " + payment + " SEK");
        System.out.println("Sale information sent to accounting and inventory system.");
        System.out.println("Inventory system updates the quantity of sold items.");
        System.out.println("The balance in register is updated");

        double change = controller.pay(payment);
        System.out.printf("\nThe customer will receive %2.2f Sek in change", change);
    }

    private void displayItem(ItemDTO itemInfo, double totalPrice){
        System.out.println("\nAdd 1 item with item ID " + itemInfo.getItemID());
        System.out.println("Item ID: " + itemInfo.getItemID());
        System.out.println("Item name: " + itemInfo.getItemName());
        System.out.printf("Item price: %2.2f SEK%n",itemInfo.getItemPrice());
        System.out.println("VAT: " + itemInfo.getItemVAT() + "%");
        System.out.println("Item Description: " + itemInfo.getItemDescription());

        System.out.printf("\nTotal cost (incl VAT): %2.2f SEK%n", totalPrice);


    }
}
