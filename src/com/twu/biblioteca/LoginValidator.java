package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by abhinaym on 15/01/15.
 */
public class LoginValidator {

    private ArrayList<Customer> customerList;
    private Customer loggedInCustomer;

    public Customer getLoggedInCustomer() {
        return loggedInCustomer;
    }
    public LoginValidator(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public Customer validate(String libraryNum, String password) {

            for(Customer customer: customerList)
            {
                if(customer.getNUMBER().equals(libraryNum) && customer.getPassword().equals(password)) {
                    loggedInCustomer = customer;
                    return customer;
                }
            }

        return null;
    }
}
