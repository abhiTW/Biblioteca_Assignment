package com.twu.biblioteca;
import com.twu.biblioteca.command.CheckoutOptionBook;
import com.twu.biblioteca.model.Library;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by abhinaym on 14/01/15.
 */

public class CheckoutOptionBookTest {

    @Test
    public void shouldCheckoutABook() {

        ArrayList<Item> books = new ArrayList<>();
        Book book1 = new Book("abhinaya","abh","1992");
        books.add(book1);
        ArrayList<Item> movies = new ArrayList<>(books);
        Customer customer1 = new Customer("Abhinaya", "abhinayacric@gmail.com", "1234567890", "abc-defg", "abhinayaTW");
        Customer customer2 = new Customer("Anu", "anucric@gmail.com", "1236567890", "dfg-hjkl", "anusuyaTW");
        ArrayList<Customer> customerList = new ArrayList<Customer>(Arrays.asList(customer1, customer2));
        LoginValidator loginValidator = new LoginValidator(customerList);
        Library library = new Library(books,movies);

        CheckoutOptionBook checkoutOptionBook = new CheckoutOptionBook(library, loginValidator);
        boolean checkoutStatus = checkoutOptionBook.checkoutABook("abhinaya");

        assertThat(checkoutStatus, is(true));
        assertThat(books.size(), is(0));
    }

    @Test
    public void shouldNotCheckoutABookWhichIsNotInLibrary() {

        ArrayList<Item> books = new ArrayList<>();
        Book book1 = new Book("abhinaya","abh","1992");
        books.add(book1);
        ArrayList<Item> movies = new ArrayList<>(books);

        Customer customer1 = new Customer("Abhinaya", "abhinayacric@gmail.com", "1234567890", "abc-defg", "abhinayaTW");
        Customer customer2 = new Customer("Anu", "anucric@gmail.com", "1236567890", "dfg-hjkl", "anusuyaTW");
        ArrayList<Customer> customerList = new ArrayList<Customer>(Arrays.asList(customer1, customer2));
        LoginValidator loginValidator = new LoginValidator(customerList);
        Library library = new Library(books,movies);

        CheckoutOptionBook checkoutOptionBook = new CheckoutOptionBook(library, loginValidator);
        assertThat(checkoutOptionBook.checkoutABook("blah"), is(false));
    }

}

