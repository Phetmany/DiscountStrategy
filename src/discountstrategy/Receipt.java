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
    private StoreMemberCustomer customer;
    private FakeDatabase database;
    
  public void addLineItems(String productID, int quantity) {
        LineItem[] temp = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        temp[temp.length-1] = new LineItem();
        lineItems = temp;
        
    }
  
  public Receipt() {
      
  }
    public Receipt(String customerID, FakeDatabase database) {
        customer = database.getCustomers(customerID);
    }
}

  