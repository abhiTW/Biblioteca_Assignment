package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by abhinaym on 15/01/15.
 */
public class LoginValidatorTest {

    @Test
    public void shouldReturnTrueWhenValidUserNameAndPasswordIsPassedForLoginAuthentication() {
        Customer customer1 = new Customer("Abhinaya", "abhinayacric@gmail.com", "1234567890", "abc-defg", "abhinayaTW");
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        customerList.add(customer1);
        String libraryNum = "abc-defg";
        String password = "abhinayaTW";

        LoginValidator loginValidator = new LoginValidator(customerList);
        Customer customer = loginValidator.validate(libraryNum,password);

        assertThat("@LoginValidatorTest",customer.getName(),is("Abhinaya"));
    }

    @Test
    public void shouldReturnFalseWhenInCorrectUserNameAndPasswordIsPassedForLoginAuthentication() {
        Customer customer1 = new Customer("Abhinaya", "abhinayacric@gmail.com", "1234567890", "abc-defg", "abhinayaTW");
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        customerList.add(customer1);

        String libraryNum = "xyz";
        String password = "somethingTW";
        LoginValidator loginValidator = new LoginValidator(customerList);
        Customer customer = loginValidator.validate(libraryNum,password);

        assertNull(customer);
    }


}
