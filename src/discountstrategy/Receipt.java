/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;
import java.text.NumberFormat;



/**
 *
 * @author nok
 */
public class Receipt {
    
    private LineItem[] lineItems = new LineItem[0];
    private Customer customer;
    private DatabaseStrategy database;
    private static int receiptNumber = 0;
    private ReceiptOutputStrategy receiptOutput;
    
    private final String CUSTOMER_ERROR = "Customer ID requires.";
    private final String INVALID_CUSTOMER = "Customer ID is invalid";
    //constructor

    public Receipt(String customerID, DatabaseStrategy database, ReceiptOutputStrategy receiptOutput) {
        this.customer = getCustomer(customerID);
        this.database = database;
        this.receiptOutput = receiptOutput;
        lineItems = new LineItem[0];
        receiptNumber++;
    }
    
  
    private final Customer getCustomer(final String customerID) {
        if (customerID == null || customerID.length() == 0) {
            receiptOutput.printMessage(CUSTOMER_ERROR);
        }
        Customer c = database.getCustomer(customerID);
        if (c == null) {
            receiptOutput.printMessage(CUSTOMER_ERROR);
        }
        return c;
    }
    
    public void setDatabase(DatabaseStrategy database) {
        this.database = database;
    }
    
    public void setReceiptOutput(ReceiptOutputStrategy receiptOutput) {
        this.receiptOutput = receiptOutput;
    }
    
    public final void addLineItem (final String productID, final int quantity) {
        LineItem lineItem = new LineItem(productID, quantity, database);
        addToArray(lineItem);
    }
    
    private void addToArray(final LineItem lineItem) {
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = lineItem;
        lineItems = tempItems;
    }

    public final double getSubtotalBeforeDiscount() {
        double total = 0.0;
        for (LineItem lineItem : lineItems) {
            total += lineItem.getSubtotal();
        }
        return total;
    }
    
    public final double getTotalDiscount() {
        double total = 0.0;
        for (LineItem lineItem : lineItems) {
            total += lineItem.getDiscount();
        }
        return total;
    }
    
    public final void printMessage(String message) {
        receiptOutput.printMessage(message); 
    }
    
    public final void printReceipt() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        
        //header
        StringBuilder receiptData = new StringBuilder("Thank you for shopping at Kohls!\n\n");
        receiptData.append("Customer: ").append(customer.getFirstName())
                .append(" " + customer.getLastName()).append("\n");
        receiptData.append("Receipt ID: ").append(receiptNumber).append("\n\n");
        
        
        // line item
        receiptData.append("ID\tItem\t\t\t\tPrice\tQuantity\tSubtotal\tDiscount")
                .append("\n\n");
        for(LineItem lineItem : lineItems) {
            receiptData.append(lineItem.getProduct().getProductID()).append("\t");
            receiptData.append(lineItem.getProduct().getProductName()).append("\t");
            receiptData.append(nf.format(lineItem.getProduct().getUnitPrice())).append("\t");
            receiptData.append(lineItem.getQuantity()).append("\t");
            receiptData.append(nf.format(lineItem.getSubtotal())).append("\t");
            receiptData.append(nf.format(lineItem.getDiscount())).append("\n\n");
        }
        
        //total
        double netTotal = getSubtotalBeforeDiscount();
        double discountTotal = getTotalDiscount();
        double total = netTotal - discountTotal;
        
        receiptData.append("Net Total: \t").append(nf.format(netTotal) + "\n");
        receiptData.append("Discount Total: \t").append(nf.format(discountTotal) + "\n");
        receiptData.append("Total: \t").append(nf.format(total) + "\n");
        

                
        
       receiptOutput.printReceipt(receiptData.toString());
    }
   
}

  