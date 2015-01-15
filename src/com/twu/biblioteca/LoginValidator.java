package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by abhinaym on 15/01/15.
 */
public class LoginValidator {

    private boolean loggedIn;
    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean validateCustomerLogin(ArrayList<Customer> customerList, String libraryNum, String password) {

            for(Customer customer: customerList)
            {
                System.out.println("The userName is" + customer.getLibNo() + customer.getPassword());
                System.out.println("The userName passed is" + libraryNum + password);

                if(customer.getLibNo().equals(libraryNum) && customer.getPassword().equals(password)) {

                    setLoggedIn(true);
                    return true;
                }
            }

        return false;
    }
}
