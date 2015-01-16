package com.twu.biblioteca.command;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Customer;
import com.twu.biblioteca.model.Library1;
import java.util.Map;

/**
 * Created by abhinaym on 15/01/15.
 */

public class ListOutOption {
    private Library1 library;
    public ListOutOption(Library1 library) {
        this.library = library;
    }

    public void displayListOfLibraryBooksWithDetails() {
        int ctr = 0;
        for (Book book : library.getAvailableBookList()) {
            System.out.printf("%-20d%-40s%-40s%s\n", ++ctr, book.getName(), book.getAuthorName(), book.getYearOfPublication());
        }
    }

    public void displayListOfLibraryBooksWithTheCustomerWhoCheckedOut() {
        Map<Customer, Book> customerBookMap = library.getCustomerBookMap();
        if (customerBookMap.isEmpty()) {
            System.out.println("No customer has checked out a book!");
            return;
        }
        System.out.printf("%-20s%-20s\n", "Customer Name", "Book Name");
        System.out.println();

        for (Map.Entry<Customer, Book> entry : customerBookMap.entrySet()) {
            Customer customer = entry.getKey();
            Book book = entry.getValue();
            System.out.printf("%-20s%-40s\n", customer.getName(), book.getName());
        }
    }

    public void displayContactInformationOfTheLoggedInUser(Customer loggedInCustomer) {
        System.out.printf("%-20s%-40s%-40s\n", "Name", "Email Address", "PhoneNo");
        System.out.printf("%-20s%-40s%-40s\n", loggedInCustomer.getName(), loggedInCustomer.getEmailAddress(), loggedInCustomer.getPhoneNo());
    }
}
