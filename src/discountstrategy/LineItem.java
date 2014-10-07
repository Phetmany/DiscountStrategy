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
    private DatabaseStrategy database;

    
    //constructor
    
    public LineItem(String productID, int quantity, DatabaseStrategy database) {
        this.product = database.getProduct(productID);
        setQuantity(quantity);
        this.database = database;
    }


    public final Product findProduct(final String productID) {
        return database.getProduct(productID);
    }

    public final double getSubtotal() {
        return product.getUnitPrice() * quantity;
    }
    
    public final double getDiscount() {
        return product.getDiscountStrategy().getCalculatedDiscount(product.getUnitPrice(), quantity);
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

    public final void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
  