package Model;

/**
 *
 * @author nipun
 */
public class Customer {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;

    public Customer() {
    }

    public Customer(String customerId, String customerName, String customerAddress, double customerSalary) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }
    
    @Override
    public String toString() {
        return customerId+","+customerName+","+customerAddress+","+customerSalary;
    }
    
}
