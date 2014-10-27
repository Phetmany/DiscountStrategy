/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author nok
 */
public class Receipt {

    private LineItem[] lineItems;
    private Customer customer;
    private DatabaseStrategy database;
    private static int receiptNumber = 0;
    private Date date;
    private String dateFormat = "M/d/yyyy hh:mm a";
    private ReceiptOutputStrategy receiptOutput;

    private final String CUSTOMER_ERROR = "Customer ID requires.";
    private final String DATABASE_ERROR = "Database not found.";
    private final String INVALID_CUSTOMER = "Customer ID is invalid";
    private final String OUTPUT_ERROR = "An output strategy is required";    
    //constructor

    public Receipt(String customerID, DatabaseStrategy database, ReceiptOutputStrategy receiptOutput) {
        setDatabase(database); 
        this.receiptOutput = receiptOutput;
        this.customer = getCustomer(customerID);
        lineItems = new LineItem[0];
        date = new Date();
        receiptNumber++;
    }

    public final void setDatabase(DatabaseStrategy database) {
        if (database == null) {
            receiptOutput.printMessage(DATABASE_ERROR);
        }
        this.database = database;
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

    public void setReceiptOutput(ReceiptOutputStrategy receiptOutput) throws InvalidFieldException {
        if (receiptOutput == null) {
            throw new InvalidFieldException();
        }
        this.receiptOutput = receiptOutput;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
    public final void addLineItem(final String productID, final int quantity) {
        LineItem lineItem = new LineItem(database, productID, quantity);
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
    
    public String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }
    
    public final void printMessage(String message) {
        receiptOutput.printMessage(message);
    }
    


    public final void printReceipt() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        final String CRLF = "\n";
        final String CRLF2 = "\n\n";
        
        //header
        StringBuilder receiptData = new StringBuilder("Thank you for shopping at Kohls!" + CRLF2);
        receiptData.append("Customer: ").append(customer.getFirstName())
                .append(" " + customer.getLastName()).append("\n");
        receiptData.append("Receipt ID: ").append(Receipt.receiptNumber).append(CRLF2);

        // line item
        receiptData.append("ID\tItem\t\t\tPrice\tQuantity\tSubtotal\tDiscount")
                .append(CRLF2);
        for (LineItem lineItem : lineItems) {
            receiptData.append(lineItem.getProduct().getProductID()).append("\t");
            receiptData.append(lineItem.getProduct().getProductName()).append("\t");
            receiptData.append(nf.format(lineItem.getProduct().getUnitPrice())).append("\t");
            receiptData.append(lineItem.getQuantity()).append("\t\t");
            receiptData.append(nf.format(lineItem.getSubtotal())).append("\t\t");
            receiptData.append(nf.format(lineItem.getDiscount())).append(CRLF2);
        }

        //total
        
        double netTotal = getSubtotalBeforeDiscount();
        double discountTotal = getTotalDiscount();
        double total = netTotal - discountTotal;

        receiptData.append("Net Total: ").append(nf.format(netTotal) + CRLF);
        receiptData.append("Discount Total: ").append(nf.format(discountTotal) + CRLF);
        receiptData.append("Total: ").append(nf.format(total) + CRLF);

        receiptOutput.printReceipt(receiptData.toString());
    }

}
