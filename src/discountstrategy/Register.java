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
public class Register {
    private Receipt receipt;

    public void startNewSale(String customerID, DatabaseStrategy database, 
            ReceiptOutputStrategy receiptOutput) {
        
        receipt = new Receipt(customerID, database, receiptOutput);
     
    }
    
    public final void addItem(String productID, int quantity) {
        receipt.addLineItem(productID, quantity);
    }
    
    public final void endSale() {
        receipt.printReceipt();
    }
}

