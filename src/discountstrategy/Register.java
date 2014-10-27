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
    private static final String ITEM_ERROR = "Item is invalid.";
    private static final String ERROR = "error";
    private Receipt receipt;

    public void startNewSale(String customerID, DatabaseStrategy database, 
            ReceiptOutputStrategy receiptOutput) {
        if (customerID == null || customerID.length() == 0 || database == null || receiptOutput == null) {
            receipt.printMessage(ERROR);
            return;
        }
        receipt = new Receipt(customerID, database, receiptOutput);
     
    }
    
    public final void addItem(String productID, int quantity) {
        if(productID == null || productID.length() == 0 || quantity < 1) {
            receipt.printMessage(ITEM_ERROR);
            return;
        }
        receipt.addLineItem(productID, quantity);
    }
    
    public final void endSale() {
        receipt.printReceipt();
    }
}

