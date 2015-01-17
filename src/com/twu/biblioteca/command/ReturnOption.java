package com.twu.biblioteca.command;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.model.Library;

public class ReturnOption {

    private Library library;

    public ReturnOption(Library library)
    {
        this.library = library;
    }

    public boolean returnABook(String bookName)
    {
       Book book =(Book)library.findForReturn(bookName);
        if(book != null)
        {
            library.returnItem(book);
            library.removeItemFromItemCustomerMap(book);
            System.out.println("Thank you for returning the book");
            return true;
        }
        else
        {
            System.out.println("That is not a valid book to return");
            return false;
        }
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
}
