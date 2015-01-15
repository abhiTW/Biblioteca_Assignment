package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by abhinaym on 15/01/15.
 */
public class LoginValidatorTest {


    @Test
    public void shouldReturnTrueWhenValidUserNameAndPasswordIsPassedForLoginAuthentication() {
        Customer customer1 = new Customer("Abhinaya", "abhinayacric@gmail.com", "1234567890", "abc-defg", "abhinayaTW");
        Customer customer2 = new Customer("Anu", "anucric@gmail.com", "1236567890", "dfg-hjkl", "anusuyaTW");
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        customerList.add(customer1);
        customerList.add(customer2);

        String libraryNum = "abc-defg";
        String password = "abhinayaTW";
        LoginValidator loginValidator = new LoginValidator();


        assertTrue(loginValidator.validateCustomerLogin(customerList, libraryNum, password));
    }

    @Test
    public void shouldReturnFalseWhenInCorrectUserNameAndPasswordIsPassedForLoginAuthentication() {
        Customer customer1 = new Customer("Abhinaya", "abhinayacric@gmail.com", "1234567890", "abc-defg", "abhinayaTW");
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        customerList.add(customer1);

        String libraryNum = "xyz";
        String password = "somethingTW";
        LoginValidator loginValidator = new LoginValidator();


        assertFalse(loginValidator.validateCustomerLogin(customerList, libraryNum, password));
    }


}
