package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

/**
 * Created by abhinaym on 14/01/15.
 */

public class InputParserTest {

    private static final String FILE_PATH = "/Users/abhinaym/Downloads/TWU_Biblioteca-master/src/files/";
    Book book1 = new Book("After Many a Summer Dies the Swan","Aldous Huxley","1765");
    Book book2 = new Book("All Passion Spent","Vita Sackville-West","1876");
    Book book3 = new Book("All the King's Men","Robert Penn Warren","1877");
    Book book4 = new Book("An Acceptable Time","Madeleine L'Engle","1865");
    Book book5 = new Book("Tale of Two Cities","Charles Dickens","1921");

    @Test
    public void CheckUpdateBookListFromFile() {
        ArrayList<Book> bookListExpected = new ArrayList<Book>(Arrays.asList(book1, book2, book3, book4, book5));
        InputParser inputParser = new InputParser();
        ArrayList<Book> bookListActual = inputParser.updateBookListFromFile(FILE_PATH + '/' + "bookdetailslist");
        int ctr = 0;

        for(Book book : bookListExpected)
        assertEquals(bookListActual.get(ctr++),(book));

    }
}
