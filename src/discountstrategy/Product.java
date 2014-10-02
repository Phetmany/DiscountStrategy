/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author nok
 */
public class Product {
    private String productID;
    private String productName;
    private double unitPrice;
    private DiscountStrategy discounts;

    
    //constructor
    public Product(String productID, String productName, double unitPrice) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
    }
    
     public double getTotalDiscount() {
        return discounts.getCalculatedDiscount();
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
    public final void setProductID(final String productID) {
        if (productID == null || productID.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }


    
    
}
