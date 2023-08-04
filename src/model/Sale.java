package model;

public class Sale {
    private int cant;

    private Product product;

    public Sale(Product product, int cant) {
        this.product = product;
        this.cant = cant;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double calcDiscount() {
        double totalValue = product.getValue() * cant;
        double discount = 0.0;

        if (cant >= 5 || cant <= 10) {
            discount = (totalValue * 0.05);
        } else if (cant >= 11 || cant <= 20) {
            discount = (totalValue * 0.1);
        } else if (cant >= 21 || cant <= 50) {
            discount = (totalValue * 0.15);
        } else if (cant > 50) {
            discount = (totalValue * 0.3);
        }
        return Math.round(discount * 100.0) / 100.0;
    }

    public double calcIva() {
        double totalValue = product.getValue() * cant;
        double ivaValue = 0.0;
        if (product.isIva()) {
            ivaValue = switch (product.getTypeProduct()) {
                case ASEO -> totalValue * 0.14;
                case LICORES -> totalValue * 0.19;
                case RANCHO -> totalValue * 0.19;
                case VIVERES -> totalValue * 0.08;
                default -> 0.0;
            };
        }
        return Math.round(ivaValue * 100.0) / 100.0;
    }

    public double getTotalAmount() {
        double totalValue = product.getValue() * cant;
        totalValue -= calcDiscount();
        totalValue += calcIva();
        return Math.round(totalValue * 100.0) / 100.0;
    }
}
