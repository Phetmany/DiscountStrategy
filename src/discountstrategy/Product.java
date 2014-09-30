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
    private DiscountStrategy[] discounts = new DiscountStrategy[0];

    
    //constructor
    public Product(String productID, String productName, double unitPrice) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
    }
    //setters and getters
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
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

    public DiscountStrategy[] getDiscounts() {
        return discounts;
    }

    public void setDiscounts(DiscountStrategy[] discounts) {
        this.discounts = discounts;
    }
    
    
}
