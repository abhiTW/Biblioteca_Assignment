package com.twu.biblioteca.command;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.model.Library;
import java.util.Map;

/**
 * Created by abhinaym on 15/01/15.
 */

public class ListOutOptionBook extends Command {
    private Library library;

    public ListOutOptionBook(Library library) {
        this.library = library;
    }

    public void displayListOfLibraryBooksWithDetails() {
        int ctr = 0;
        for (Item item : library.getAvailableItemList()) {

            Book book  = (Book)item;
            System.out.printf("%-20d%-40s%-40s%s\n", ++ctr, book.getName(), book.getAuthorName(), book.getYearOfPublication());
        }
    }



    @Override
    public void execute()  {
        displayListOfLibraryBooksWithDetails();
    }

}
