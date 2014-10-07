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
public class PercentOffDiscount implements DiscountStrategy {
    private double discountRate;

    //constructor

    public PercentOffDiscount(double discountRate) {
        setDiscountRate(discountRate);
    }
    
    
    //setters and getters
    public final double getDiscountRate() {
        return discountRate;
    }

    public final void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    

    @Override
    public final double getCalculatedDiscount(double unitPrice, int quantity) {
        return (unitPrice * quantity * discountRate);
    }


    
}
