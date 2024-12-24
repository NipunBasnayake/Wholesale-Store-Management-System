package Model;

/**
 *
 * @author nipun
 */
public class Order {
    private String orderId;
    private String orderDate;
    private String customerId;

    public Order() {
    }

    public Order(String orderId, String orderDate, String customerId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    
    @Override
    public String toString() {
       return orderId+","+orderDate+","+customerId;
    }
}
