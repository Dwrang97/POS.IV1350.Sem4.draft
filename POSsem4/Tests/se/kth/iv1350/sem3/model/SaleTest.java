package se.kth.iv1350.sem3.model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.sem3.integration.ItemDTO;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testSaleTotalPriceStartOnZero(){
        //Given
        Sale sale = new Sale();
        // Then
        assertEquals(0.0, sale.getTotalPrice(), 0.0);
    }

    @Test
    void testSaleAddItemDTO(){
        //Given
        Sale sale = new Sale();
        ItemDTO itemDTO = new ItemDTO(1.0,0.0,1,"desc", "name");
        // When
        sale.updateSaleInfo(itemDTO);
        // Then
        assertEquals(1.0, sale.getTotalPrice(), 0.0);
    }

    @Test
    void testSaleAddMultipleItemDTO(){
        Sale sale = new Sale();
        //Given
        ItemDTO itemDTO1 = new ItemDTO(1.0,0.0,1,"desc1", "name1");
        ItemDTO itemDTO2 = new ItemDTO(2.0,0.0,2,"desc2", "name2");
        ItemDTO itemDTO3 = new ItemDTO(3.0,0.0,3,"desc3", "name3");
        // When
        sale.updateSaleInfo(itemDTO1);
        sale.updateSaleInfo(itemDTO2);
        sale.updateSaleInfo(itemDTO3);
        // Then
        assertEquals(6.0, sale.getTotalPrice(), 0.0);
    }

    @Test
    void testSaleAddSameItemDTO(){
        Sale sale = new Sale();
        //given
        ItemDTO itemDTO1 = new ItemDTO(1,0.5,1,"desc1","name1");
        //when
        sale.updateSaleInfo(itemDTO1);
        sale.updateSaleInfo(itemDTO1);
        //then
        assertEquals(3,sale.getTotalPrice());
    }

    @Test
    void testAddItemWithUnknownItemID(){
        Sale sale = new Sale();
        //given
        ItemDTO unknownItem = new ItemDTO(5.0,0.0,1,"","Unknown item");
        //when
        sale.updateSaleInfo(unknownItem);
        //then
        assertEquals(0,sale.getTotalPrice());
    }

    @Test
    void testCalculateTotalPriceOfSale(){
        Sale sale = new Sale();
        ItemDTO itemDTO1 = new ItemDTO(1,0.1,1,"desc1","name1");
        ItemDTO itemDTO2 = new ItemDTO(2,0.2,2,"desc2","name2");
        ItemDTO itemDTO3 = new ItemDTO(3,0.3,3,"desc3","name3");

        sale.updateSaleInfo(itemDTO1);
        sale.updateSaleInfo(itemDTO2);
        sale.updateSaleInfo(itemDTO3);

        assertEquals(7.4,sale.getTotalPrice());
    }

    @Test
    void testCalculateChangeCorrectly(){
        Sale sale = new Sale();
        //given
        ItemDTO itemDTO = new ItemDTO(5,0,1,"desc1","name1");
        //when
        sale.updateSaleInfo(itemDTO);
        //then
        double expectedChange = sale.calculateChange(10);
        assertEquals(5,expectedChange);

    }
}