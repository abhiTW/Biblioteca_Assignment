
package com.twu.biblioteca;


import com.twu.biblioteca.model.Library;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.*;


public class BibliotecaAppTest {

    private static final String FILE_PATH = "/Users/abhinaym/Downloads/TWU_Biblioteca-master/src/files/";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    Book book1 = new Book("After Many a Summer Dies the Swan", "Aldous Huxley", "1765");
    Book book2 = new Book("All Passion Spent", "Vita Sackville-West", "1876");
    Book book3 = new Book("All the King's Men", "Robert Penn Warren", "1877");
    Book book4 = new Book("An Acceptable Time", "Madeleine L'Engle", "1865");
    Book book5 = new Book("Tale of Two Cities", "Charles Dickens", "1921");
    List<Item> availableBookList = new ArrayList<Item>(Arrays.asList(book1, book2, book3, book4, book5));
    List<Item> bookList = new ArrayList<Item>(Arrays.asList(book1, book2, book3, book4, book5));

    Movie movie1 = new Movie("BloodDiamond","2006","Edward Zwick","8");
    Movie movie2 = new Movie("The Real Steel","2002","Edward Zwick","10");
    ArrayList<Item> movieList = new ArrayList<Item>(Arrays.asList(movie1,movie2));
    ArrayList<Item> availableMovieList = new ArrayList<Item>(Arrays.asList(movie1,movie2));

    private Library bookLibrary = new Library(availableBookList,bookList);
    private Library movieLibrary = new Library(availableMovieList,movieList);
    private BibliotecaApp testInstance = new BibliotecaApp(bookLibrary,movieLibrary);
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
    public void checkMainMenuInvalidMessage() throws IOException {
        int inValidMenuOption = 11;
        testInstance.choosingMainMenuOption(inValidMenuOption);
        assertTrue(outContent.toString().contains("Select a valid option!"));
    }

   /*@Test
    public void checkUnsuccessfulCheckOut() throws IOException
    {
        String bookNum = "10";
        ByteArrayInputStream inContent = new ByteArrayInputStream(bookNum.getBytes());
       // testInstance.displayListOfLibraryBooksForCheckingOut(inContent);
        assertTrue(outContent.toString().contains("Sorry ! That book is not available"));
    }*/

    /*@Test
    public void checkSuccessfulCheckOut() throws IOException
    {
        String bookNum = "2";
        ByteArrayInputStream inContent = new ByteArrayInputStream(bookNum.getBytes());
        testInstance.displayListOfLibraryBooksForCheckingOut(inContent);
        assertTrue(outContent.toString().contains("Thank you! Enjoy the book"));
    }
*/
  /* @Test
    public void checkUnsuccessfulReturn() throws IOException {
        String bookNum = "10";
        ByteArrayInputStream inContent = new ByteArrayInputStream(bookNum.getBytes());
        testInstance.displayForReturningTheLibraryBook(inContent);
        assertTrue(outContent.toString().contains("That is not a valid book to return"));
    }

    @Test
    public void checkSuccessfulReturn() throws IOException {

        String bookNumForCheckingOut = "2";
        ByteArrayInputStream inContentForCheckingOut = new ByteArrayInputStream(bookNumForCheckingOut.getBytes());
        testInstance.displayListOfLibraryBooksForCheckingOut(inContentForCheckingOut);

        String bookNumForReturn = "2";
        ByteArrayInputStream inContentReturn = new ByteArrayInputStream(bookNumForReturn.getBytes());
        testInstance.displayForReturningTheLibraryBook(inContentReturn, bookLibrary);
        assertTrue(outContent.toString().contains("Thank you for returning the book"));

    }
*/
    private void verifyOutputAfterFormatting(String actualValue, String fileName) throws IOException {

        BufferedReader actualStream = new BufferedReader(new StringReader(actualValue));
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH + '/' + fileName))) {
            String sCurrentLine;
            int ctr = 0;
            while ((sCurrentLine = br.readLine()) != null) {

                String[] bookName = sCurrentLine.split(",");
                ctr++;
                String fileInConsoleFormat = String.format("%-20d%-40s%-40s%s", ctr, bookName[0], bookName[1], bookName[2]);
                assertEquals(actualStream.readLine(),(fileInConsoleFormat));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

