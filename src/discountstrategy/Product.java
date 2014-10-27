/*
 * 
 */
package discountstrategy;

/**
 *
 * @author Phetmany Senthavy
 * @version 1.00
 */
public class Product {
    private String productID;
    private String productName;
    private double unitPrice;
    private DiscountStrategy discount;

    
    //constructor
    public Product(String productID, String productName, double unitPrice, DiscountStrategy discountStrategy) {
        setProductID(productID);
        setProductName(productName);
        setUnitPrice(unitPrice);
        setDiscountStrategy(discountStrategy);
    }
    
    
    //setters and getters
    public final String getProductID() {
        return productID;
    }
    
    /**
     * 
     * @param productID - product identifier, is validated for null
     * and empty String
     * @throws IllegalArgumentException 
     */
    public final void setProductID(final String productID) throws InvalidFieldException {
        if (productID == null || productID.isEmpty()) {
            throw new InvalidFieldException();
        }
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public final void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public DiscountStrategy getDiscountStrategy() {
        return discount;
    }
    
    public final void setDiscountStrategy(DiscountStrategy discount) {
        this.discount = discount;
    }

    
    
}
