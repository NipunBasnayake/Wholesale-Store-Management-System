package model;

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

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the quantityOnHand
     */
    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    /**
     * @param quantityOnHand the quantityOnHand to set
     */
    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }
 
}
