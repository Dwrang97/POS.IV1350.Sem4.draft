package se.kth.iv1350.sem3.controller;

import se.kth.iv1350.sem3.integration.*;
import se.kth.iv1350.sem3.model.Register;
import se.kth.iv1350.sem3.model.Sale;

/**
 * <code>Controller</code> handles method calls from the <code>View</code> to the packages
 * <code>model</code> and <code>integration</code>.
 */
public class Controller {


    private final Printer printer;
    private final ExternalInventorySystem externalInventorySystem;
    private final ExternalAccountingSystem externalAccountingSystem;
    private Sale currentSale;
    private final Register register;
    /**
     * creates an object of the class <code>Controller</code>
     * @param creator gives the <code>Controller</code> class a reference to the
     *                <code>CreateExternalSystems</code> class
     * @param printer gives the <code>Controller</code> class a reference to the <code>Printer</code> class
     */
    public Controller(CreateExternalSystems creator, Printer printer) {
        externalInventorySystem = creator.getExternalInventorySystem();
        externalAccountingSystem = creator.getExternalAccountingSystem();
        this.printer = printer;
        register = new Register();

    }



    /**
     * Creates a new object of <code>sale</code>
     */
    public void startNewSale(){
        currentSale = new Sale();
    }

    /**
     * This method passes an itemDTO to the <code>currentSale</code> object to update the current sale,
     * and also returns the itemDTO to the <code>View</code> so it can be displayed.
     * @param itemID The itemID of an item being sold.
     * @return Returns an itemDTO of the item.
     */
    public ItemDTO enterItemID(int itemID) throws IdentifierNotFoundException, FailedSystemOperationException {
        try {
            ItemDTO itemInfo = externalInventorySystem.getItemInfo(itemID);
            currentSale.updateSaleInfo(itemInfo);
            return itemInfo;

        }catch (DatabaseAccessUnavailableException databaseAccessUnavailableException) {
            //log to text file
            throw new FailedSystemOperationException
                    ("Could not enter item to sale", databaseAccessUnavailableException);
        }

    }

    /**
     * Getter This method gets the running total price of the current sale and passes it to the <code>View</code>.
     * @return Returns the running total price of the current sale.
     */
    public double getRunningTotal(){
        return currentSale.getTotalPrice();

    }

    /**
     * This method is called when the sale is done
     * and passes information needed in the <code>View</code> when the sale is finished.
     * @return Returns the total cost of the sale.
     */
    public double endSale(){
        return currentSale.getTotalPrice();
    }

    /**
     * This method passes the amount paid for the sale to the register.
     * @param paidAmount The amount paid for the sale.
     */
    public double pay(double paidAmount) {
        sendSaleInformationToExternalSystems();
        register.enterAmountPayed(paidAmount);
        register.enterAmountChange(currentSale.calculateChange(paidAmount));
        return currentSale.calculateChange(paidAmount);
    }

    private void sendSaleInformationToExternalSystems(){
        externalAccountingSystem.sendSaleInformation(currentSale);
        externalInventorySystem.sendSaleInformation(currentSale);
    }

}
