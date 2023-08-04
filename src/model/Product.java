package model;

public class Product {
    private String name;
    private double value;
    private int stock;
    private boolean iva;
    private ETypeProduct typeProduct;
    public static final int STOCK_MIN = 10;

    public Product() {
    }

    public Product(String name, double value, int stock, boolean iva, ETypeProduct typeProduct) {
        this.name = name;
        this.value = value;
        this.stock = stock;
        this.iva = iva;
        this.typeProduct = typeProduct;
    }

    public ETypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(ETypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) throws Exception {
        int newStock = this.stock - stock;
        if (newStock < 0) {
            throw new Exception("Insufficient stock");
        }
        if (stock <= 0) {
            throw new Exception("Invalid stock");
        }
        this.stock = newStock;
    }

    public boolean isIva() {
        return iva;
    }

    public void setIva(boolean iva) {
        this.iva = iva;
    }

    public static int getStockMin() {
        return STOCK_MIN;
    }

}
