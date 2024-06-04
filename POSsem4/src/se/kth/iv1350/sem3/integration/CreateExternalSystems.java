package se.kth.iv1350.sem3.integration;

/**
 * This class is used to create objects of the external systems.
 */
public class CreateExternalSystems {

    private final ExternalAccountingSystem externalAccountingSystem;
    private final ExternalInventorySystem externalInventorySystem;

    /**
     * Creates an object of the <code>ExternalInventorySystem</code> class.
     * Creates an object of the <code>ExternalAccountingSystem</code> class.
     */
    public CreateExternalSystems() {

        externalInventorySystem = new ExternalInventorySystem();
        externalAccountingSystem = new ExternalAccountingSystem();
    }

    /**
     * getter method for the object of type <code>externalInventorySystem</code>.
     * @return Returns an object of <code>externalInventorySystem</code>.
     */
    public ExternalInventorySystem getExternalInventorySystem() {
        return externalInventorySystem;
    }

    /**
     * Getter method for the object of type <code>ExternalAccountingSystem</code>.
     * @return Returns an object of <code>ExternalAccountingSystem</code>.
     */
    public ExternalAccountingSystem getExternalAccountingSystem() {
        return externalAccountingSystem;
    }
}
