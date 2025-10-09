package model;


public class Order {
    @org.example.model.PrimaryKey private int orderId;
    private int clientId;

    /**
     *
     * @param orderId
     * @param clientId
     */
    public Order(int orderId, int clientId) {
        this.orderId = orderId;
        this.clientId = clientId;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getClientId() {
        return clientId;
    }
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    public Order() {
    }
}
