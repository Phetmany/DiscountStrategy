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
public class FakeDatabase {
    
    private StoreMemberCustomer[] customers = {
        new StoreMemberCustomer("Kayla", "Jones", "A0001"),
        new StoreMemberCustomer("Catherine", "Evans", "A0002"),
        new StoreMemberCustomer("John", "White", "A0003")
    };
    
    private Product[] products = {
        new Product("P0001", "Mudd Black Dress", 19.99),
        new Product("P0002", "Candie's White Sweater", 12.99),
        new Product("P0003", "Levi's Blue Jeans", 24.99)
    };

    
    
    public StoreMemberCustomer getCustomers(String customerID) {
        StoreMemberCustomer customer = null;
        for (StoreMemberCustomer sc : customers) {
            if (sc.getCustomerID().equals(customerID)) {
                customer = sc;
            }
        }
         return customer;
    }



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
    
    

