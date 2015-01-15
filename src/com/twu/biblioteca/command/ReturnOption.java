package com.twu.biblioteca.command;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.model.Library1;

public class ReturnOption {

    private Library1 library;

    public ReturnOption(Library1 library)
    {
        this.library = library;
    }

    public boolean returnABook(String bookName)
    {
       Book book =library.findForReturn(bookName);
        if(book != null)
        {

            library.returnBook(book);
            System.out.println("Thank you for returning the book");
            return true;
        }
        else
        {
            System.out.println("That is not a valid book to return");
            return false;
        }
    }
}
