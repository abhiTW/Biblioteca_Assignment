package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by abhinaym on 14/01/15.
 */

public class LibraryTest {

    private static final String FILE_PATH = "/Users/abhinaym/Downloads/TWU_Biblioteca-master/out/textfiles";

    Book book1 = new Book("After Many a Summer Dies the Swan", "Aldous Huxley", "1765");
    Book book2 = new Book("All Passion Spent", "Vita Sackville-West", "1876");
    Book book3 = new Book("All the King's Men", "Robert Penn Warren", "1877");
    Book book4 = new Book("An Acceptable Time", "Madeleine L'Engle", "1865");
    Book book5 = new Book("Tale of Two Cities", "Charles Dickens", "1921");
    List<Book> bookList = new ArrayList<Book>(Arrays.asList(book1, book2, book3, book4, book5));

    private Library library1 = new Library(bookList);

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
    public void checkCheckOutOfBooksIfCheckedOutBookIsUnavailable() throws IOException {
        int book_no = 2;
        bookList.get(book_no - 1).setCheckedOut(true);
        library1.checkOutOfBooks(book_no);
        verifyOutputAfterFormatting(outContent.toString(), "bookdetailslist");

    }
    @Test
    public void checkReturnOfBooksIfReturnedBookIsAvailable() throws IOException {
        int book_no = 3;
        library1.checkOutOfBooks(book_no);
        outContent.reset();
        library1.returnOfBooks(book_no);
        bookList.get(book_no - 1).setCheckedOut(false);
        verifyOutputAfterFormatting(outContent.toString(), "bookdetailslist");
    }

    private void verifyOutputAfterFormatting(String actualValue, String fileName) throws IOException {
        BufferedReader actualStream = new BufferedReader(new StringReader(actualValue));
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH + '/' + fileName))) {
            String sCurrentLine;
            int ctr = 0;
            while ((sCurrentLine = br.readLine()) != null) {

                if (bookList.get(ctr).isCheckedOut())
                    continue;

                String[] bookName = sCurrentLine.split(",");
                ctr++;
                String fileInConsoleFormat = String.format("%-20d%-40s%-40s%s", ctr, bookName[0], bookName[1], bookName[2]);
                assertThat("in file: " + fileName, actualStream.readLine(), equalTo(fileInConsoleFormat));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
