package com.twu.biblioteca;

import com.twu.biblioteca.command.ReturnOptionBook;
import com.twu.biblioteca.model.Library;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReturnOptionBookTest {

    @Test
    public void shouldReturnABook() {

        ArrayList<Item> totalBooks = new ArrayList<>();
        Book book = new Book("book name", "", "");
        totalBooks.add(book);
        ArrayList<Item> availableBooks = new ArrayList<>(totalBooks);
        Customer customer1 = new Customer("Abhinaya", "abhinayacric@gmail.com", "1234567890", "abc-defg", "abhinayaTW");
        Customer customer2 = new Customer("Anu", "anucric@gmail.com", "1236567890", "dfg-hjkl", "anusuyaTW");
        ArrayList<Customer> customerList = new ArrayList<Customer>(Arrays.asList(customer1, customer2));
        LoginValidator loginValidator = new LoginValidator(customerList);

        Library library = new Library(availableBooks, totalBooks);
        ReturnOptionBook returnOptionBook = new ReturnOptionBook(library, loginValidator);
        boolean returnStatus = returnOptionBook.returnABook("book name");

        assertThat(returnStatus, is(true));
        assertThat(totalBooks.size(), is(1));
    }

    @Test
    public void shouldNotReturnABookWhichIsNotPartOfTheLibrary() {
        ArrayList<Item> totalBooks = new ArrayList<>();
        Book book = new Book("book name", "", "");
        totalBooks.add(book);
        ArrayList<Item> availableBooks = new ArrayList<>(totalBooks);
        Customer customer1 = new Customer("Abhinaya", "abhinayacric@gmail.com", "1234567890", "abc-defg", "abhinayaTW");
        Customer customer2 = new Customer("Anu", "anucric@gmail.com", "1236567890", "dfg-hjkl", "anusuyaTW");
        ArrayList<Customer> customerList = new ArrayList<Customer>(Arrays.asList(customer1, customer2));
        LoginValidator loginValidator = new LoginValidator(customerList);

        Library library = new Library(availableBooks, totalBooks);
        ReturnOptionBook returnOptionBook = new ReturnOptionBook(library, loginValidator);

        boolean returnStatus = returnOptionBook.returnABook("mybook");

        assertFalse(returnStatus);


    }
}

