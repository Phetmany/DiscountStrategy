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
public class ReceiptConsoleOutput implements ReceiptOutputStrategy {

    @Override
    public void printReceipt(String receipt) {
        System.out.println(receipt);
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
    
}
