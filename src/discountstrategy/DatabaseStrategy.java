/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package discountstrategy;

/**
 *
 * @author psent_000
 */
public interface DatabaseStrategy {
    public abstract Customer getCustomer(String customerID);
    public abstract Product getProduct(String productID);
}
