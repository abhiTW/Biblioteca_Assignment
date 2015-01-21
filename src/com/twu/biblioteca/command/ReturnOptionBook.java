package com.twu.biblioteca.command;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.LoginValidator;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.model.Library;

import java.util.Scanner;

public class ReturnOptionBook extends Command{

    private Library library;
    private LoginValidator loginValidator;
    public ReturnOptionBook(Library library, LoginValidator loginValidator)
    {
        this.library = library;
         this.loginValidator = loginValidator;
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

    @Override
    public void execute() {

        if(loginValidator.getLoggedInCustomer()== null)
        {
            System.out.println("Sorry, you have to log in to return a book");
        }
        else
        {   Scanner input = new Scanner(System.in);
            System.out.println("Enter the name of the book to return:");
            String bookName = input.nextLine();

            returnABook(bookName);
        }

    }
}
