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
public class Customer {
    private String firstName;
    private String lastName;
    private String customerID;

    //constructor
    public Customer(String customerID, String firstName, String lastName) {
        setCustomerID(customerID);
        setFirstName(firstName);
        setLastName(lastName);
    }
    
    //getters and setters
    public String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
        if (firstName == null || firstName.length() <= 1) {
            throw new IllegalArgumentException("Name can't be null and "
                    + "length must be greater than 1");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {
        if (lastName == null || lastName.length() <= 1) {
            throw new IllegalArgumentException("Name can't be null and "
                    + "length must be greater than 1");
        }
        this.lastName = lastName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public final void setCustomerID(String customerID) {
        if (customerID == null || customerID.length() <= 0) {
            throw new IllegalArgumentException("ID cannot be null or 0 length");
        }
        this.customerID = customerID;
    }


    
}
