package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.Before;

public class ServiceSaleTest {
    Product ron;

    @Before
    public void setupProducts() {
        ron = new Product("Ron", 10000, 10, true, ETypeProduct.LICORES);
    }

    @Test
    public void ensureCreationSaleWithTenStock() {
        try {
            ServiceSale serviceSale = new ServiceSale(ron, 3);
            Sale sale = serviceSale.getSale();
            assertEquals("Ron", sale.getProduct().getName());
            assertEquals(3, sale.getCant());
            assertEquals(7, ron.getStock());
        } catch (Exception e) {
            fail("No expected exception " + e.getMessage());
        }
    }

    @Test
    public void saleInvalidInsufficientStock() {
        try {
            new ServiceSale(ron, 11);
            fail("Expected exception");
        } catch (Exception e) {
            assertEquals("Insufficient stock", e.getMessage());
            assertEquals(10, ron.getStock());
        }
    }

    @Test
    public void saleInvalidStockWithZero() {
        try {
            new ServiceSale(ron, 0);
            fail("Expected exception");
        } catch (Exception e) {
            assertEquals("Invalid stock", e.getMessage());
            assertEquals(10, ron.getStock());
        }
    }

    @Test
    public void saleInvalidStockWithNegative() {
        try {
            new ServiceSale(ron, -1);
            fail("Expected exception");
        } catch (Exception e) {
            assertEquals("Invalid stock", e.getMessage());
            assertEquals(10, ron.getStock());
        }
    }
}
