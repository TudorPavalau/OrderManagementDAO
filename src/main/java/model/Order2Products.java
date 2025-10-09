package model;

public class Order2Products {
    @org.example.model.PrimaryKey private int productId;
    @org.example.model.PrimaryKey private int orderId;
    private int quantity;

    public Order2Products(int productId, int orderId, int quantity) {
        this.productId = productId;
        this.orderId = orderId;
        this.quantity = quantity;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Order2Products(){}
}
