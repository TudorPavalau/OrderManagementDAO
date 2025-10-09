package model;

public class Product {
    @org.example.model.PrimaryKey private int productId;
    private String productName;
    private int stock;
    public double price;

    public Product() {
    }

    /**
     *
     * @param productId
     * @param productName
     * @param stock
     * @param price
     */
    public Product(int productId, String productName, int stock,double price) {
        this.productId = productId;
        this.productName = productName;
        this.stock = stock;
        this.price = price;
    }

    public Product(String productName, int stock,double price) {
        this.productName = productName;
        this.stock = stock;
        this.price = price;
        this.productId = -1;
    }

    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }


}
