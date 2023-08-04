package presenter;

import model.ServiceSale;
import model.ETypeProduct;
import model.Product;

/**
 * Class with the presenter attributes
 * 
 * @version 1.0
 */
public class Presenter {
    /**
     * Attribute to store the service sale
     */
    private ServiceSale serviceSale;

    /**
     * Creates a presenter
     */
    public Presenter() {

    }

    /**
     * Method to add a sale
     * 
     * @param name
     * @param value
     * @param stock
     * @param iva
     * @param typeProduct
     * @param cant
     * @return
     */
    public double addSale(String name, double value, int stock, boolean iva, ETypeProduct typeProduct, int cant) {
        try {
            serviceSale = new ServiceSale(new Product(name, value, stock, iva, typeProduct), cant);
            return serviceSale.getSale().getTotalAmount();
        } catch (Exception e) {
            return 0.0;
        }
    }

    /**
     * Method to show the sale
     * 
     * @return
     */
    public String showSale() {
        return String.format("\nTotal: %s\nDiscount: %s\nIva: %s\n",
                serviceSale.getSale().getTotalAmount(), serviceSale.getSale().calcDiscount(),
                serviceSale.getSale().calcIva());
    }

    /**
     * Method to get the service sale
     * 
     * @return
     */
    public ServiceSale getServiceSale() {
        return serviceSale;
    }

    /**
     * Method to set the service sale
     * 
     * @param serviceSale
     */
    public void setServiceSale(ServiceSale serviceSale) {
        this.serviceSale = serviceSale;
    }
}
