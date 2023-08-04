package model;

/**
 * Class with the product attributes
 * 
 * @version 1.0
 */
public class Product {
    /**
     * Attribute to store the name of the product
     */
    private String name;
    /**
     * Attribute to store the value of the product
     */
    private double value;
    /**
     * Attribute to store the stock of the product
     */
    private int stock;
    /**
     * Attribute to store if the product has iva
     */
    private boolean iva;
    /**
     * Attribute to store the type of product
     */
    private ETypeProduct typeProduct;
    /**
     * Constant to store the minimum stock
     */
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

    /**
     * Method to get the type of product
     * 
     * @return
     */
    public ETypeProduct getTypeProduct() {
        return typeProduct;
    }

    /**
     * Method to set the type of product
     * 
     * @param typeProduct
     */
    public void setTypeProduct(ETypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    /**
     * Method to get the name of the product
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the name of the product
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the value of the product
     * 
     * @return
     */
    public double getValue() {
        return value;
    }

    /**
     * Method to set the value of the product
     * 
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Method to get the stock of the product
     * 
     * @return
     */
    public int getStock() {
        return stock;
    }

    /**
     * Method to set the stock of the product
     * 
     * @param stock
     * @throws Exception
     */
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

    /**
     * Method to get the iva of the product
     * 
     * @return
     */
    public boolean isIva() {
        return iva;
    }

    /**
     * Method to set the iva of the product
     * 
     * @param iva
     */
    public void setIva(boolean iva) {
        this.iva = iva;
    }

    /**
     * Method to get the minimum stock of the product
     * 
     * @return
     */
    public static int getStockMin() {
        return STOCK_MIN;
    }
}
