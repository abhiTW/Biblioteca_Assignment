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



    private List<Book> bookList;

    public Librarian()
    {

        bookList = new ArrayList<Book>();
        updateBookListFromFile();

    }



    /************ Reading from the file and updating the arrayList ****************/

    private void updateBookListFromFile()
    {
        try (BufferedReader br = new BufferedReader(new FileReader(GOLD_PATH + '/' + "bookdetailslist"))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] bookName = sCurrentLine.split(",");
                Book book = new Book(bookName[0],bookName[1],bookName[2]);
                bookList.add(book);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

/***************** End of it *********************************************/


public void displayListOfLibraryBooksWithDetails() {

        int ctr = 0;

       for(Book book : bookList)
       {
            if (bookList.get(ctr++).isCheckedOut())

                continue;
           System.out.printf("%-20d%-40s%-40s%s\n", ctr, book.getName(), book.getAuthorName(), book.getYearOfPublication());

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

            if (!bookList.get(book_no - 1).isCheckedOut()) {
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
