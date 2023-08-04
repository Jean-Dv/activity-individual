package model;

public class ServiceSale {
    private Sale sale;

    public ServiceSale(Product product, int cant) throws Exception {
        product.setStock(cant);
        this.sale = new Sale(product, cant);
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
