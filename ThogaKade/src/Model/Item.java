package Model;

/**
 *
 * @author nipun
 */
public class Item {
    private String code;
    private String description;
    private double unitPrice;
    private int quantityOnHand;
    
    public Item() {
    }

    public Item(String code, String description, double unitPrice, int quantityOnHand) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantityOnHand = quantityOnHand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }
    
    @Override
    public String toString() {
        return code+","+description+","+unitPrice+","+quantityOnHand;
    }
    
    
}
