package com.twu.biblioteca.command;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.model.Library1;

/**
 * Created by abhinaym on 15/01/15.
 */
public class ListOutOption {
    private Library1 library;

    public ListOutOption(Library1 library) {

        this.library = library;
    }

    public void displayListOfLibraryBooksWithDetails() {
        int ctr = 0;
        for (Book book : library.getAvailableBookList()) {

            System.out.printf("%-20d%-40s%-40s%s\n", ++ctr, book.getName(), book.getAuthorName(), book.getYearOfPublication());
        }
    }
}
