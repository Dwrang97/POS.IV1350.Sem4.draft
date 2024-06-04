package se.kth.iv1350.sem3.startup;

import se.kth.iv1350.sem3.controller.Controller;
import se.kth.iv1350.sem3.integration.CreateExternalSystems;
import se.kth.iv1350.sem3.integration.Printer;
import se.kth.iv1350.sem3.model.Receipt;
import se.kth.iv1350.sem3.model.Sale;
import se.kth.iv1350.sem3.view.View;

/**
 * <code>Main</code> serves as the entry point of the application.
 * <code>Main</code> starts the application and sets up the necessary components needed.
 */
public class Main {
    /**
     * The main method which serves as the entry point for the Java application.
     * This method initializes the necessary components for the application,
     *
     * @param args This application does not use command line arguments.
     */

    public static void main(String[] args) {
        CreateExternalSystems creator = new CreateExternalSystems();
        Printer printer = new Printer();
        Controller controller = new Controller(creator, printer);
        View view = new View(controller);

        view.makeSaleFLow();
    }
}