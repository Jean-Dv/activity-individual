package model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class SaleTest {
    private Sale sale;
    Product soap;
    Product rice;
    Product whisky;
    Product pancake;

    @Before
    public void setup() {
        soap = new Product("King Soap", 2300, 30, true, ETypeProduct.ASEO);
        rice = new Product("Arrox x lb", 4600, 80, false, ETypeProduct.VIVERES);
        whisky = new Product("Old par x lt", 180000, 18, true, ETypeProduct.LICORES);
        pancake = new Product("Pancake", 1500, 342, false, ETypeProduct.RANCHO);
    }

    @Test
    public void testCalcDiscount() {
        sale = new Sale(soap, 10);
        assertEquals(1150.0, sale.calcDiscount(), 0.1);
    }

    @Test
    public void testCFalcIva() {
        sale = new Sale(soap, 10);
        assertEquals(3220.0, sale.calcIva(), 0.1);
        soap.setIva(false);
        assertEquals(0.0, sale.calcIva(), 0.1);
    }

    @Test
    public void testGetTotalAmount() {
        sale = new Sale(soap, 10);
        assertEquals(25070.0, sale.getTotalAmount(), 0.1);
        sale.setProduct(pancake);
        assertEquals(14250.0, sale.getTotalAmount(), 0.1);
    }
}
