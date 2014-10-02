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
public class FlatRateDiscount implements DiscountStrategy {

    private double price;
    private int quantity;
    private double discountRate;

    //constructor
    public FlatRateDiscount(double price, int quantity, double discountRate) {
        this.price = price;
        this.quantity = quantity;
        this.discountRate = discountRate;
    }
    
    //setters and getters

    public double getPrice() {
        return price;
    }

    //type /** 
    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    
    
    
    @Override
    public double getCalculatedDiscount() {
        return discountRate;
    }

}
