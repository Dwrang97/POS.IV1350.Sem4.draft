package se.kth.iv1350.sem3.model;

/**
 *This class manages the balance in the register.
 */
public class Register {

private double amountInRegister;

    /**
     * Updates the balance in the register with the paid amount.
     * @param paidAmount the amount paid by the customer.
     */
    public void enterAmountPayed(double paidAmount){
        amountInRegister += paidAmount;
    }

    /**
     * Updates the balance in the register with the change the customer will receive.
     * @param change The change the customer will receive.
     */
    public void enterAmountChange(double change){
        amountInRegister -= change;
    }
}
