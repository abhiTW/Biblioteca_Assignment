package com.twu.biblioteca;

import com.twu.biblioteca.command.CheckoutOption;
import com.twu.biblioteca.model.Library;
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

        ArrayList<Item> books = new ArrayList<>();
        Book book = new Book("book name", "", "");
        Customer customer1 = new Customer("Abhinaya", "abhinayacric@gmail.com", "1234567890", "abc-defg", "abhinayaTW");
        books.add(book);
        Library library = new Library(books,books);

        CheckoutOption checkoutOption = new CheckoutOption(library);

        boolean checkoutStatus = checkoutOption.checkout("book name", customer1);

        assertThat(checkoutStatus, is(true));
        assertThat(books.size(), is(0));
    }

    @Test
    public void shouldNotCheckoutABookWhichIsNotInLibrary() {

        ArrayList<Item> books = new ArrayList<>();
        Book book = new Book("book name", "", "");
        Customer customer1 = new Customer("Abhinaya", "abhinayacric@gmail.com", "1234567890", "abc-defg", "abhinayaTW");

        books.add(book);
        Library library = new Library(books,books);
        CheckoutOption checkoutOption = new CheckoutOption(library);

        assertThat(checkoutOption.checkout("blah", customer1), is(false));
    }
}
