package com.twu.biblioteca.command;

import com.twu.biblioteca.Customer;
import com.twu.biblioteca.LoginValidator;

import java.util.Scanner;

/**
 * Created by abhinaym on 15/01/15.
 */
public class LogInOption {

    private LoginValidator loginValidator;

    public LogInOption(LoginValidator loginValidator) {
        this.loginValidator = loginValidator;
    }

    public Customer getUserInputForAuthentication() {
        Customer customer = null;
 while (customer == null) {

            Scanner input = new Scanner(System.in);
            System.out.println("Enter your username:");
            String userName = input.nextLine();
            System.out.println("Enter your password :");
            String password = input.nextLine();

            customer = loginValidator.validate(userName, password);

        }

        return customer;
    }


}
