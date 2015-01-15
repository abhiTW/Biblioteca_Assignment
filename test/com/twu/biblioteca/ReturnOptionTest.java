package com.twu.biblioteca;

import com.twu.biblioteca.command.CheckoutOption;
import com.twu.biblioteca.command.ReturnOption;
import com.twu.biblioteca.model.Library1;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Created by abhinaym on 14/01/15.
 */
public class ReturnOptionTest {


    @Test
    public void shouldReturnABook() {

        ArrayList<Book> availableBooks = new ArrayList<>();
        Book book = new Book("book name", "", "");


        ArrayList<Book> totalBooks = new ArrayList<>();
        totalBooks.add(book);

        Library1 library1 = new Library1(availableBooks,totalBooks);
        ReturnOption returnOption = new ReturnOption(library1);

        boolean returnStatus = returnOption.returnABook("book name");

        assertThat(returnStatus, is(true));
        assertThat(totalBooks.size(), is(1));
    }

    @Test
    public void shouldNotReturnABookWhichIsNotPartOfTheLibrary()
    {
        Book sampleBook1 = new Book("mybook", "", "");
        Book sampleBook2 = new Book("somebook", "", "");
        ArrayList<Book> availableBooks = new ArrayList<>();
        ArrayList<Book> totalBooks = new ArrayList<>();

        totalBooks.add(sampleBook2);
        Library1  library1 = new Library1(availableBooks,totalBooks);
        ReturnOption returnOption = new ReturnOption(library1);

        boolean returnStatus = returnOption.returnABook("mybook");

        assertFalse(returnStatus);


    }
}
