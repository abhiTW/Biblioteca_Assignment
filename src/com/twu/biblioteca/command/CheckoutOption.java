package com.twu.biblioteca.command;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.model.Library1;

/**
 * Created by abhinaym on 14/01/15.
 */
public class CheckoutOption {
    private Library1 library;

    public CheckoutOption(Library1 library) {

        this.library = library;
    }

    public boolean checkout(String bookName) {
        Book book = library.find(bookName);
        if(book == null) {
            return false;
        }

        System.out.println("The bookName is " + bookName);
        library.checkOut(book);
        return true;
    }
}
