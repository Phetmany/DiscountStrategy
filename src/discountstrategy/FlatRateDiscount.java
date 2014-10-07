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
    private double discountRate;

    //constructor
    public FlatRateDiscount(double discountRate) {
        
    }
    //setters and getters
    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    

    @Override
    public double getCalculatedDiscount(double unitPrice, int quantity) {
        return discountRate;
    }

}
