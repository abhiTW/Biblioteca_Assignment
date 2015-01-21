package com.twu.biblioteca.command;

import com.twu.biblioteca.Customer;
import com.twu.biblioteca.LoginValidator;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.model.Library;

import java.util.Scanner;

/**
 * Created by abhinaym on 19/01/15.
 */
public class CheckOutOptionMovie extends Command{

    private Library library;
    private LoginValidator loginValidator;
    public CheckOutOptionMovie(Library library, LoginValidator loginValidator) {
        this.library = library;
        this.loginValidator = loginValidator;
    }

    public boolean checkoutAMovie(String movieName) {
        Movie movie = (Movie)library.find(movieName);
        if (movie == null) {
            System.out.println("Sorry ! That movie is not available");
            System.out.println();
            return false;
        }
        else {
            System.out.println("Thank you! Enjoy the Movie");
            library.checkOut((movie));
            library.updateCustomerItemMap(loginValidator.getLoggedInCustomer(),movie);
            return true;
        }
    }

    @Override
    public void execute() {
        if(loginValidator.getLoggedInCustomer()== null)
        {
            System.out.println("Sorry, you have to log in to check out a movie!");
        }
        else
        {   Scanner input = new Scanner(System.in);
            System.out.println("Enter the name of the movie to check out:");
            String movieName = input.nextLine();

            checkoutAMovie(movieName);
        }
    }
}
