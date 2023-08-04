package model;

/**
 * Class with the sale attributes
 * 
 * @version 1.0
 */
public class ServiceSale {
    /**
     * Attribute to store the sale
     */
    private Sale sale;

    /**
     * Creates a sale with the given parameters
     * 
     * @param product
     * @param cant
     * @throws Exception
     */
    public ServiceSale(Product product, int cant) throws Exception {
        product.setStock(cant);
        this.sale = new Sale(product, cant);
    }

    /**
     * Method to get the sale
     * 
     * @return
     */
    public Sale getSale() {
        return sale;
    }

    /**
     * Method to set the sale
     * 
     * @param sale
     */
    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
