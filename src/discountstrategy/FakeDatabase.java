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
public class FakeDatabase implements DatabaseStrategy {
    
    private final Customer[] customers = {
        new Customer("A0001", "Kayla", "Jones"),
        new Customer("A0002", "Catherine", "Evans"),
        new Customer("A0003", "John", "White")
    };
    
    private final Product[] products = {
        new Product("P0001", "Mudd Black Dress", 19.99, new QuantityDiscount(3, .30)),
        new Product("P0002", "Candie's White Sweater", 12.99, new PercentOffDiscount(.20)),
        new Product("P0003", "Levi's Blue Jeans", 24.99, new NoDiscount())
    };

    
    
    @Override
    public final Customer getCustomer(final String customerID) {
        Customer customer = null;
        for (Customer c : customers) {
            if (c.getCustomerID().equals(customerID)) {
                customer = c;
            }
        }
         return customer;
    }



    @Override
    public Product getProduct(String productId) {
        Product product = null;
        for (Product p : products) {
            if (productId.equals(p.getProductID())) {
                product = p;
            }
        }
        return product;
    }







}
    
    

