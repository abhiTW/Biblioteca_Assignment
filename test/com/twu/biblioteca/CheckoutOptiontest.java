package com.twu.biblioteca;

import com.twu.biblioteca.command.CheckoutOption;
import com.twu.biblioteca.model.Library1;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by abhinaym on 14/01/15.
 */
public class CheckoutOptionTest {

    @Test
    public void shouldCheckoutABook() {

        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("book name", "", "");
        books.add(book);
        Library1 library = new Library1(books,books);

        CheckoutOption checkoutOption = new CheckoutOption(library);

        boolean checkoutStatus = checkoutOption.checkout("book name");

        assertThat(checkoutStatus, is(true));
        assertThat(books.size(), is(0));
    }

    @Test
    public void shouldNotCheckoutABookWhichIsNotInLibrary() {

        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("book name", "", "");
        books.add(book);
        Library1 library = new Library1(books,books);

        CheckoutOption checkoutOption = new CheckoutOption(library);

        assertThat(checkoutOption.checkout("blah"), is(false));
    }
}
