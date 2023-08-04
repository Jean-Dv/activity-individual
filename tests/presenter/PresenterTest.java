package presenter;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.BeforeClass;

import model.ETypeProduct;

public class PresenterTest {
    static Presenter presenter;

    @BeforeClass
    public static void setup() {
        presenter = new Presenter();
    }

    @Test
    public void testAddSale() {
        assertEquals(0.0, presenter.addSale("King Soap", 2300, 30, true, ETypeProduct.ASEO, 10), 0.1);
    }

    @Test
    public void testShowSale() {
        assertEquals(String.format("\nTotal: %s\nDiscount: %s\nIva: %s\n", 25070.0, 1150.0, 3220.0),
                presenter.showSale());
    }
}
