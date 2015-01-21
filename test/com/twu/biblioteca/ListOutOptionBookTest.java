package com.twu.biblioteca;

import com.twu.biblioteca.command.ListOutOptionBook;
import com.twu.biblioteca.model.Library;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ListOutOptionBookTest {
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
    public void checkListOfAvailableBooks() {
        ArrayList<Item> books = new ArrayList<>();
        Book book1 = new Book("book name", "author name", "1899");
        books.add(book1);
        Library library = new Library(books, books);
        ListOutOptionBook listOutOptionBook = new ListOutOptionBook(library);
        String ExpectedListOfBooks = String.format("%-20d%-40s%-40s%s", 1, book1.getName(), book1.getAuthorName(), book1.getYearOfPublication());

        listOutOptionBook.displayListOfLibraryBooksWithDetails();
        assertEquals(outContent.toString().trim(), ExpectedListOfBooks.trim());
    }
}

