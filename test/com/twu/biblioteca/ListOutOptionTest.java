package com.twu.biblioteca;

import com.twu.biblioteca.command.ListOutOption;
import com.twu.biblioteca.model.Library1;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by abhinaym on 15/01/15.
 */
public class ListOutOptionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void checkListOfAvailableBooks()
    {
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book("book name", "author name", "1899");
        books.add(book1);
        Library1 library = new Library1(books,books);
        ListOutOption  listOutOption= new ListOutOption(library);
        String ExpectedListOfBooks = String.format("%-20d%-40s%-40s%s",1,book1.getName(),book1.getAuthorName(),book1.getYearOfPublication());

        listOutOption.displayListOfLibraryBooksWithDetails();
        assertEquals(outContent.toString().trim(),ExpectedListOfBooks.trim());
    }

    @Test
    public void checkListOfCustomersAlongWithTheCustomerWhoCheckedItOut()
    {
        HashMap<Customer,Book> customerBookMap = new HashMap<Customer,Book>();
        Customer customer1 = new Customer("Abhinaya", "abhinayacric@gmail.com", "1234567890", "abc-defg", "abhinayaTW");
        Book book1 = new Book("After Many a Summer Dies the Swan", "Aldous Huxley", "1765");

        customerBookMap.put(customer1,book1);



    }

}
