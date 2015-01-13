package com.twu.biblioteca;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Librarian {


    private static final String GOLD_PATH = "/Users/abhinaym/Downloads/TWU_Biblioteca-master/out/textfiles";
    private static final int NO_OF_FILES = 5;  // Now fixed later we can set it by counting the number of books from the entries in the file

    private int[] checkOutArray = new int[NO_OF_FILES];
    Book book1 = new Book("After Many a Summer Dies the Swan", "Aldous Huxley", "1765");
    Book book2 = new Book("All Passion Spent", "Vita Sackville-West", "1876");
    Book book3 = new Book("All the King's Men", "Robert Penn Warren", "1877");
    Book book4 = new Book("An Acceptable Time", "Madeleine L'Engle", "1865");
    Book book5 = new Book("Tale of Two Cities", "Charles Dickens", "1921");

    private List<Book> bookList = new ArrayList<Book>(Arrays.asList(book1,book2,book3,book4,book5));



    public static void main(String[] args) {



        Librarian librarian = new Librarian();

        librarian.displayWelcomeMessageInTheConsole();
        System.out.println();

       librarian.displayListOfLibraryBooksWithDetails();



        Scanner input = new Scanner(System.in);
        String flag = "yes";
        while (flag.equalsIgnoreCase("y") || flag.equalsIgnoreCase("yes")) {

            librarian.displayMenuOption();

            System.out.println("Enter Y or N to continue or quit respectively: ");
            flag = input.next();

        }
        System.out.println();
        librarian.displayListOfLibraryBooksWithDetails();

        librarian.displayMenuOption();
        librarian.displayListOfLibraryBooks();

    }

    public void displayWelcomeMessageInTheConsole() {

        System.out.print("Welcome to Bibilioteca!!!");

    }

    public void displayListOfLibraryBooks() {

       /* System.out.println("After Many a Summer Dies the Swan");
        System.out.println("All Passion Spent");
        System.out.println("All the King's Men");
        System.out.println("An Acceptable Time");
        System.out.println("Tale of Two Cities");

        */


        try (BufferedReader br = new BufferedReader(new FileReader(GOLD_PATH + '/' + "booklist"))) {

            String sCurrentLine;

            int ctr = 0;

            while ((sCurrentLine = br.readLine()) != null) {


                if (checkOutArray[ctr++] == 1)
                    continue;

                String[] bookName = sCurrentLine.split("\\r?\\n");
                System.out.println(bookName[0]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void displayListOfLibraryBooksWithDetails() { // Since this is a formatted output not able to write a corresponding jUnit test


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


    public void choosingMainMenuOption(int option) {

        if (option == 1)
            displayListOfLibraryBooksWithDetails();
        else if (option == 2) {
            System.out.println("System Exiting .....");
            //System.exit(0);
        } else if (option == 3) {

            displayListOfLibraryBooksForCheckingOut();
        } else if (option == 4) {

            displayForReturningTheLibraryBook();
        } else {
            System.out.println("Select a valid option!");
            System.out.println();

        }


    }

    private void displayListOfLibraryBooksForCheckingOut() {  // can check only a single book at a time

        displayListOfLibraryBooksWithDetails();

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the corresponding book number to check out:");

        checkOutOfBooks(input.nextInt());


    }

    private void displayForReturningTheLibraryBook() {  // can check only a single book at a time


        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of the book to be returned:");

        returnOfBooks(input.nextInt());


    }


    public void displayMenuOption() {

        System.out.printf("%-50s\n", "MAIN MENU");
        System.out.println("**********************************************");

        System.out.printf("%-30s\n", "Option 1: List the library books");
        System.out.printf("%-30s\n", "Option 2: Quit ");
        System.out.printf("%-30s\n", "Option 3: Check out a Book ");
        System.out.printf("%-30s\n", "Option 4: Return a Book ");


        System.out.println();
        System.out.printf("%-30s\n", "Please enter your option:");
        Scanner input = new Scanner(System.in);
        choosingMainMenuOption(input.nextInt());

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
