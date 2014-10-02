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
public class LineItem {
    private Product product;
    private int quantity;
    private FakeDatabase database;

    
    //constructor
    
    public LineItem(String productID, int quantity, FakeDatabase database) {
        this.product = database.getProduct(productID);
        this.quantity = quantity;
        this.database = database;
    }
    
    public LineItem() {
        
    }



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
   

    private double getSubtotal() {
        return (product.getUnitPrice() * quantity);
    }
    
    public double getDiscount() {
        return product.getTotalDiscount();
    }

    public double getSubtotalAfterDiscount() {
        return (product.getUnitPrice() * quantity) - getDiscount();
    }
}
  