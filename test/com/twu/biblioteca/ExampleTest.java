package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class ExampleTest {


    private static final String GOLD_PATH = "/Users/abhinaym/Downloads/TWU_Biblioteca-master/out/textfiles";
    private static final int NO_OF_FILES = 5;

    private  int checkOutArray[] = new int[NO_OF_FILES];
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private BibliotecaApp testInstance = new BibliotecaApp();

    /*@Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
*/

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
    public void checkListOfLibraryBooks() throws IOException {

        testInstance.displayListOfLibraryBooks();
        verifyOutputAfterCheckOutOrReturn(outContent.toString(), "booklist");


    }

  /*  @Test
    public void checkListOfLibraryBooksWithDetails() throws IOException {

        testInstance.displayListOfLibraryBooksWithDetails();


        verifyOutput(outContent.toString().replaceAll(" \\s",",").replaceAll(",{2,}", ","),"bookdetailslist");



    }

*/


    @Test
    public void checkMainMenuListingOfFilesOption() throws IOException {


        testInstance.choosingMainMenuOption(1);

        verifyOutput(outContent.toString(), "booklist");


    }

    @Test
    public void checkMainMenuInvalidOption() throws IOException {

        testInstance.choosingMainMenuOption(10);
        verifyOutputAfterCheckOutOrReturn(outContent.toString(), "invalid");


    }


    @Test
    public void checkMainMenuQuitOption() throws IOException {


        testInstance.choosingMainMenuOption(2);
        verifyOutputAfterCheckOutOrReturn(outContent.toString(), "exit");

    }

   @Test
    public void checkCheckOutOfBooksIfCheckedOutBookIsUnavailable() throws IOException {


        int book_no = 2;
        checkOutArray[book_no - 1] = 1;
        testInstance.checkOutOfBooks(book_no);
        verifyOutputAfterCheckOutOrReturn(outContent.toString(), "booklist"); // Running to display only the list of books names and not details  ...


    }

    @Test
    public void checkUnsuccessfulCheckOut() throws IOException

    {
        testInstance.checkOutOfBooks(10);
        verifyOutputAfterCheckOutOrReturn(outContent.toString(), "failure_checkout");

    }

    @Test
    public void checkUnsuccessfulReturn() throws IOException {        // The other else part is not checked as it is unable to flush the console after it

        int book_no = 10;
        testInstance.returnOfBooks(book_no);
        verifyOutputAfterCheckOutOrReturn(outContent.toString(),"failure_return");


    }


   /*@Test
    public void checkReturnOfBooksIfReturnedBookIsAvailable() throws IOException {


        int book_no = 3;
        testInstance.checkOutOfBooks(book_no);
                                                        // Unable to flush the outContent after calling the checkOutOfBooks

        testInstance.returnOfBooks(book_no);
        checkOutArray[book_no - 1] = 0;


        verifyOutputAfterCheckOutOrReturn(outContent.toString(), "booklist");

    }
*/

    private void verifyOutputAfterCheckOutOrReturn(String actualValue, String fileName) throws IOException {

        BufferedReader file = new BufferedReader(new FileReader(GOLD_PATH + '/' + fileName));
        BufferedReader actualStream = new BufferedReader(new StringReader(actualValue));

        String thisFileLine;
        int ctr = 0;
        while ((thisFileLine = file.readLine()) != null && checkOutArray[ctr++] != 1) {


            assertThat("in file: " + fileName, actualStream.readLine(), equalTo(thisFileLine));


        }


    }


    protected void verifyOutput(String actualValue, String fileName) throws IOException {


        BufferedReader file = new BufferedReader(new FileReader(GOLD_PATH + '/' + fileName));
        BufferedReader actualStream = new BufferedReader(new StringReader(actualValue));

        String thisFileLine;
        assertEquals(0, checkOutArray[1]);
        while ((thisFileLine = file.readLine()) != null) {


            assertThat("in file: " + fileName, actualStream.readLine(), equalTo(thisFileLine));


        }


    }


}
