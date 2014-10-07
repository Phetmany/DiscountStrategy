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
    private double discountRate;

    //constructor  
    public QuantityDiscount(int minQuantity, double discountRate) {
        setMinQuantity(minQuantity);
        setDiscountRate(discountRate);
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public final void setMinQuantity(int minQuantity) {      
        this.minQuantity = minQuantity;
    }

    
    public double getDiscountRate() {
        return discountRate;
    }

    public final void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    

    @Override
    public double getCalculatedDiscount(double unitPrice, int quantity) {
        double discount = 0;
        if (quantity >= getMinQuantity()) {
            discount = unitPrice * quantity * discountRate;
        }
        return discount;
    }


    
    
}
