package com.twu.biblioteca;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Librarian {


    private static final String GOLD_PATH = "/Users/abhinaym/Downloads/TWU_Biblioteca-master/out/textfiles";
    private static final int NO_OF_FILES = 5;  // Now fixed later we can set it by counting the number of books from the entries in the file

    Book book1 = new Book("After Many a Summer Dies the Swan", "Aldous Huxley", "1765");
    Book book2 = new Book("All Passion Spent", "Vita Sackville-West", "1876");
    Book book3 = new Book("All the King's Men", "Robert Penn Warren", "1877");
    Book book4 = new Book("An Acceptable Time", "Madeleine L'Engle", "1865");
    Book book5 = new Book("Tale of Two Cities", "Charles Dickens", "1921");

    private List<Book> bookList = new ArrayList<Book>(Arrays.asList(book1,book2,book3,book4,book5));


    public void displayListOfLibraryBooksWithDetails() {

        try (BufferedReader br = new BufferedReader(new FileReader(GOLD_PATH + '/' + "bookdetailslist"))) {

            String sCurrentLine;
            int ctr = 0;

            while ((sCurrentLine = br.readLine()) != null) {

              if (bookList.get(ctr++).isCheckedOut())

                    continue;

                String[] bookName = sCurrentLine.split(",");

                System.out.printf("%-20d%-40s%-40s%s\n", ctr, bookName[0], bookName[1], bookName[2]);


            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public void checkOutOfBooks(int bookNo) {


        if ((bookNo - 1) <= NO_OF_FILES) {

            bookList.get(bookNo-1).setCheckedOut(true);
            displayListOfLibraryBooksWithDetails();

        } else {

            System.out.println("Sorry ! That book is not available");
            System.out.println();


        }


    }


    public void returnOfBooks(int book_no) {


        if ((book_no - 1) <= NO_OF_FILES) {

            if (bookList.get(book_no -1).isCheckedOut() == false) {
                System.out.println("That is not a valid book to return");
                System.out.println();
            } else {
               bookList.get(book_no -1).setCheckedOut(false);
                displayListOfLibraryBooksWithDetails();
            }
        } else {
            System.out.println("That is not a valid book to return");
            System.out.println();
        }


    }
}
