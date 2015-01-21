package com.twu.biblioteca.command;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.LoginValidator;
import com.twu.biblioteca.model.Library;

import java.util.Scanner;

public class CheckoutOptionBook extends Command {
    private Library library;
    private LoginValidator loginValidator;

    public CheckoutOptionBook(Library library, LoginValidator loginValidator) {
        this.library = library;
        this.loginValidator = loginValidator;
    }

    public boolean checkoutABook(String bookName) {
        Book book = (Book) library.find(bookName);
        if (book == null) {
            System.out.println("Sorry ! That book is not available");
            System.out.println();
            return false;
        } else {
            System.out.println("Thank you! Enjoy the book");
            library.checkOut(book);
            library.updateCustomerItemMap(loginValidator.getLoggedInCustomer(), book);
            return true;
        }
    }

    @Override
    public void execute() {
        if(loginValidator.getLoggedInCustomer()== null)
        {
            System.out.println("Sorry, you have to log in to check out a book!");
        }
    else
        {   Scanner input = new Scanner(System.in);
            System.out.println("Enter the name of the book to check out:");
            String bookName = input.nextLine();

            checkoutABook(bookName);
        }

    }
}
