package com.twu.biblioteca.command;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.model.Library;
import java.util.Map;

/**
 * Created by abhinaym on 15/01/15.
 */

public class ListOutOption {
    private Library library;
    public ListOutOption(Library library) {
        this.library = library;
    }

    public void displayListOfLibraryBooksWithDetails() {
        int ctr = 0;
        for (Item item : library.getAvailableItemList()) {

            Book book  = (Book)item;
            System.out.printf("%-20d%-40s%-40s%s\n", ++ctr, book.getName(), book.getAuthorName(), book.getYearOfPublication());
        }
    }


    public void displayListOfLibraryMoviesWithDetails() {
        int ctr = 0;
        for (Item item : library.getAvailableItemList()) {

           Movie movie  = (Movie)item;
            System.out.printf("%-20d%-40s%-40s%s\n", ++ctr,movie.getName(),movie.getDirector(),movie.getMovieRating());
        }
    }

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


    public void displayContactInformationOfTheLoggedInUser(Customer loggedInCustomer) {
        System.out.printf("%-20s%-40s%-40s\n", "Name", "Email Address", "PhoneNo");
        System.out.printf("%-20s%-40s%-40s\n", loggedInCustomer.getName(), loggedInCustomer.getEmailAddress(), loggedInCustomer.getPhoneNo());
    }
}
