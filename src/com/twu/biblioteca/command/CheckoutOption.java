package com.twu.biblioteca.command;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.model.Library;

public class CheckoutOption {
    private Library library;

    public CheckoutOption(Library library) {
        this.library = library;
    }

    public boolean checkout(String bookName, Customer customer) {
        Book book =(Book) library.find(bookName);
        if (book == null) {
            System.out.println("Sorry ! That book is not available");
            System.out.println();
            return false;
        }
        else {
            System.out.println("Thank you! Enjoy the book");
            library.checkOut(book);
            library.updateCustomerItemMap(customer,book);
            return true;
        }
    }

    public boolean checkoutAMovie(String movieName, Customer customer) {
        Movie movie = (Movie)library.find(movieName);
        if (movie == null) {
            System.out.println("Sorry ! That movie is not available");
            System.out.println();
            return false;
        }
        else {
            System.out.println("Thank you! Enjoy the Movie");
            library.checkOut((movie));
            library.updateCustomerItemMap(customer,movie);
            return true;
        }
    }

}
