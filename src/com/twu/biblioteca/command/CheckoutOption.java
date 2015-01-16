package com.twu.biblioteca.command;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Customer;
import com.twu.biblioteca.model.Library1;

public class CheckoutOption {
    private Library1 library;

    public CheckoutOption(Library1 library) {
        this.library = library;
    }

    public boolean checkout(String bookName, Customer customer) {
        Book book = library.find(bookName);
        if (book == null) {
            System.out.println("Sorry ! That book is not available");
            System.out.println();
            return false;
        }
        else {
            System.out.println("Thank you! Enjoy the book");
            library.checkOut(book);
            library.updateCustomerBookMap(customer,book);
            return true;
        }
    }


}
