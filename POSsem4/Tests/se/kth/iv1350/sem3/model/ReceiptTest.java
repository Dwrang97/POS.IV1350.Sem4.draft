package se.kth.iv1350.sem3.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.sem3.integration.ItemDTO;
import se.kth.iv1350.sem3.integration.Printer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    Receipt receipt = new Receipt();
    Printer printer = new Printer();

    @Test
    void testCreateReceipt(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime timeBeforeSale = LocalDateTime.now();
        Sale sale = new Sale();
        LocalDateTime timeAfterSale = LocalDateTime.now();
        //given
        ItemDTO itemDTO1 = new ItemDTO(5.0,0.06,1,"desc1", "name1");
        ItemDTO itemDTO2 = new ItemDTO(10.0,0.12,2,"desc2", "name2");
        ItemDTO itemDTO3 = new ItemDTO(7.5,0.25,3,"desc3", "name3");
        //when
        sale.updateSaleInfo(itemDTO1);
        sale.updateSaleInfo(itemDTO2);
        sale.updateSaleInfo(itemDTO3);

        receipt.setReceipt(sale, 100);
        //then

        assertNotNull(receipt.getReceipt());
        assertTrue(receipt.getReceipt().contains("Time of sale: " + sale.getTimeOfSale().format(formatter) + "\n"));
        assertTrue(receipt.getReceipt().contains("name1                    1  x 5.30  SEK  5.30 SEK"));
        assertTrue(receipt.getReceipt().contains("name2                    1  x 11.20 SEK 11.20 SEK\n"));
        assertTrue(receipt.getReceipt().contains("name3                    1  x 9.38  SEK  9.38 SEK\n"));
        assertTrue(receipt.getReceipt().contains("Total: 25.88 SEK\n"));
        assertTrue(receipt.getReceipt().contains("VAT:  3.38 SEK\n"));
        assertTrue(receipt.getReceipt().contains("Paid amount: 100.00 SEK\n"));
        assertTrue(receipt.getReceipt().contains("Change: 74.13 SEK"));
        assertTrue(!sale.getTimeOfSale().isBefore(timeBeforeSale) &&
                !sale.getTimeOfSale().isAfter(timeAfterSale));
    }
}
// assertequals med outputen