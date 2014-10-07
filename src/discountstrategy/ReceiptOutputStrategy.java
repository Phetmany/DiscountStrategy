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
public interface ReceiptOutputStrategy {
    public abstract void printReceipt(String receipt);
    public abstract void printMessage(String message);
}
