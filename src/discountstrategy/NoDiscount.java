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
public class NoDiscount implements DiscountStrategy {

    @Override
    public final double getCalculatedDiscount(double unitPrice, int quantity) {
        return 0;
    }
    
}
