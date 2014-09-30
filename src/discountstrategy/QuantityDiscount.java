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
public class QuantityDiscount implements DiscountStrategy {
    private int minQuantity = 3;
    private int quantity;
    private double price;
    private double discountRate;

    //constructor
    
    public QuantityDiscount(int minQuantity, int quantity, double price, double discountRate) {
        this.minQuantity = minQuantity;
        this.quantity = quantity;
        this.price = price;
        this.discountRate = discountRate;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {      
        this.minQuantity = minQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    

    @Override
    public double getCalculatedDiscount() {
        double discount = 0;
        if (quantity >= getMinQuantity()) {
            discount = price * quantity * discountRate;
        }
        return discount;
    }


    
    
}
