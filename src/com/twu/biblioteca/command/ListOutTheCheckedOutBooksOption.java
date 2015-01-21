package com.twu.biblioteca.command;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.LoginValidator;
import com.twu.biblioteca.model.Library;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by abhinaym on 18/01/15.
 */
public class ListOutTheCheckedOutBooksOption extends Command{

    public ListOutTheCheckedOutBooksOption(Library library,LoginValidator loginValidator) {
        this.library = library;
        this.loginValidator = loginValidator;
    }

    Library library;
    LoginValidator loginValidator;

    public void displayListOfLibraryBooksWithTheCustomerWhoCheckedOut() {
        Map<Item, Customer> customerBookMap = library.getCustomerItemMap();
        if (customerBookMap.isEmpty()) {
            System.out.println("No customer has checked out a book!");
            return;
        }
        System.out.printf("%-20s%-20s\n", "Customer Name", "Book Name");
        System.out.println();

        for (Map.Entry<Item, Customer> entry : customerBookMap.entrySet()) {
            Book book = (Book)entry.getKey();
            Customer customer = entry.getValue();
            System.out.printf("%-20s%-40s\n", customer.getName(), book.getName());
        }
    }

    @Override
    public void execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        if(loginValidator.getLoggedInCustomer()== null)
        {
            System.out.println("Sorry, you have to log in view the details");
        }

        else
        {
            displayListOfLibraryBooksWithTheCustomerWhoCheckedOut();

        }

    }
}
