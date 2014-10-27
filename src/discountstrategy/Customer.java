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
//    private final String NAME_ERROR = "Field cannot be empty or null";

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

    public final void setFirstName(String firstName) throws InvalidFieldException {
        if (firstName == null || firstName.length() <= 1) {
            throw new InvalidFieldException();
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) throws InvalidFieldException {
        if (lastName == null || lastName.length() <= 1) {
            throw new InvalidFieldException();
        }
        this.lastName = lastName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public final void setCustomerID(String customerID) throws InvalidFieldException {
        if (customerID == null || customerID.length() <= 0) {
            throw new InvalidFieldException();
        }
        this.customerID = customerID;
    }


}
