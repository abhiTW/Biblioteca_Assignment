package com.twu.biblioteca.command;

import com.twu.biblioteca.LoginValidator;
import com.twu.biblioteca.model.Library;

/**
 * Created by abhinaym on 19/01/15.
 */
public class ViewCustomerInfoOption extends Command {

    public ViewCustomerInfoOption(LoginValidator loginValidator) {
        this.loginValidator = loginValidator;
    }

    private LoginValidator loginValidator;

    public void displayContactInformationOfTheLoggedInUser() {
        System.out.printf("%-20s%-40s%-40s\n", "Name", "Email Address", "PhoneNo");
        System.out.printf("%-20s%-40s%-40s\n", loginValidator.getLoggedInCustomer().getName(), loginValidator.getLoggedInCustomer().getEmailAddress(), loginValidator.getLoggedInCustomer().getPhoneNo());
    }

    @Override
    public void execute()  {
        displayContactInformationOfTheLoggedInUser();
    }
}
