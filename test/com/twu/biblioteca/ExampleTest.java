package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class ExampleTest {


    private static final String GOLD_PATH = "/Users/abhinaym/Downloads/TWU_Biblioteca-master/out/textfiles";
    private static final int NO_OF_FILES = 5;


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private BibliotecaApp testInstance = new BibliotecaApp();
    private Librarian librarian = new Librarian();

    Book book1 = new Book("After Many a Summer Dies the Swan", "Aldous Huxley", "1765");
    Book book2 = new Book("All Passion Spent", "Vita Sackville-West", "1876");
    Book book3 = new Book("All the King's Men", "Robert Penn Warren", "1877");
    Book book4 = new Book("An Acceptable Time", "Madeleine L'Engle", "1865");
    Book book5 = new Book("Tale of Two Cities", "Charles Dickens", "1921");

    List<Book> bookList = new ArrayList<Book>(Arrays.asList(book1, book2, book3, book4, book5));





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
    public void checkWelcomeConsoleMessage() {
        testInstance.displayWelcomeMessageInTheConsole();
        assertEquals("Welcome to Bibilioteca!!!", outContent.toString());
    }

    @Test
    public void checkMainMenuListingOfFilesOption() throws IOException {
        testInstance.choosingMainMenuOption(1);
        verifyOutputAfterFormatting(outContent.toString(), "bookdetailslist");

    }

    @Test
    public void checkMainMenuInvalidOption() throws IOException {
        testInstance.choosingMainMenuOption(10);
        verifyOutput(outContent.toString(), "invalid");
    }

    @Test
    public void checkMainMenuQuitOption() throws IOException {
        testInstance.choosingMainMenuOption(2);
        verifyOutput(outContent.toString(), "exit");

    }

    @Test
    public void checkCheckOutOfBooksIfCheckedOutBookIsUnavailable() throws IOException {
        int book_no = 2;
        bookList.get(book_no - 1).setCheckedOut(true);
        librarian.checkOutOfBooks(book_no);
        verifyOutputAfterFormatting(outContent.toString(), "bookdetailslist");
    }

    @Test
    public void checkUnsuccessfulCheckOut() throws IOException

    {
        librarian.checkOutOfBooks(10);
        verifyOutput(outContent.toString(), "failure_checkout");

    }

    @Test
    public void checkUnsuccessfulReturn() throws IOException {        // The other else part is not checked as it is unable to flush the console after it

        int book_no = 10;
        librarian.returnOfBooks(book_no);
        verifyOutput(outContent.toString(), "failure_return");


    }


    @Test
    public void checkReturnOfBooksIfReturnedBookIsAvailable() throws IOException {


        int book_no = 3;
        librarian.checkOutOfBooks(book_no);
        outContent.reset();
        librarian.returnOfBooks(book_no);
        bookList.get(book_no - 1).setCheckedOut(false);


        verifyOutputAfterFormatting(outContent.toString(), "bookdetailslist");

    }




    private void verifyOutputAfterFormatting(String actualValue, String fileName) throws IOException {

        BufferedReader actualStream = new BufferedReader(new StringReader(actualValue));

        try (BufferedReader br = new BufferedReader(new FileReader(GOLD_PATH + '/' + fileName))) {

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

    protected void verifyOutput(String actualValue, String fileName) throws IOException {


        BufferedReader file = new BufferedReader(new FileReader(GOLD_PATH + '/' + fileName));
        BufferedReader actualStream = new BufferedReader(new StringReader(actualValue));

        String thisFileLine;

        while ((thisFileLine = file.readLine()) != null) {


            assertThat("in file: " + fileName, actualStream.readLine(), equalTo(thisFileLine));


        }


    }


}
