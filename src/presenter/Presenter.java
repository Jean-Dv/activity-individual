package presenter;

import model.ServiceSale;
import model.ETypeProduct;
import model.Product;

public class Presenter {
    private ServiceSale serviceSale;

    public Presenter() {

    }

    public double addSale(String name, double value, int stock, boolean iva, ETypeProduct typeProduct, int cant) {
        try {
            serviceSale = new ServiceSale(new Product(name, value, stock, iva, typeProduct), cant);
            return serviceSale.getSale().getTotalAmount();
        } catch (Exception e) {
            return 0.0;
        }
    }

    public String showSale() {
        return String.format("\nTotal: %s\nDiscount: %s\nIva: %s\n",
                serviceSale.getSale().getTotalAmount(), serviceSale.getSale().calcDiscount(),
                serviceSale.getSale().calcIva());
    }

    public ServiceSale getServiceSale() {
        return serviceSale;
    }

    public void setServiceSale(ServiceSale serviceSale) {
        this.serviceSale = serviceSale;
    }
}
