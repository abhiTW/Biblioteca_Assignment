package com.twu.biblioteca.command;

import com.twu.biblioteca.LoginValidator;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.model.Library;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * Created by abhinaym on 19/01/15.
 */
public class ReturnOptionMovie extends Command{

    private Library library;
    private LoginValidator loginValidator;

    public ReturnOptionMovie(Library library, LoginValidator loginValidator) {
        this.library = library;
        this.loginValidator = loginValidator;
    }

    public boolean returnAMovie(String bookName)
    {
        Movie movie = (Movie)library.findForReturn(bookName);
        if(movie != null)
        {
            library.returnItem(movie);
            library.removeItemFromItemCustomerMap(movie);
            System.out.println("Thank you for returning the movie");
            return true;
        }
        else
        {
            System.out.println("That is not a valid movie to return");
            return false;
        }
    }

    @Override
    public void execute()  {

        if(loginValidator.getLoggedInCustomer()== null)
        {
            System.out.println("Sorry, you have to log in to return a movie!");
        }
        else
        {   Scanner input = new Scanner(System.in);
            System.out.println("Enter the name of the movie to return:");
            String movieName = input.nextLine();

            returnAMovie(movieName);
        }

    }
}
