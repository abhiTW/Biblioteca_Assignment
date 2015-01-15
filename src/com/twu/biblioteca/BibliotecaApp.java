package com.twu.biblioteca;

import com.twu.biblioteca.command.CheckoutOption;
import com.twu.biblioteca.command.ListOutOption;
import com.twu.biblioteca.command.ReturnOption;
import com.twu.biblioteca.model.Library1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by abhinaym on 13/01/15.
 */
public class BibliotecaApp {

    private Library1 library1;

    private static final String FILE_PATH = "/Users/abhinaym/Downloads/TWU_Biblioteca-master/src/files";

    public BibliotecaApp(Library1 library1) {
        this.library1 = library1;
    }

    public static void main(String[] args) {


        InputParser inputParser = new InputParser();
        ArrayList<Book> bookList = inputParser.updateBookListFromFile(FILE_PATH + '/' + "bookdetailslist");
        ArrayList<Book> availableBookList= inputParser.updateBookListFromFile(FILE_PATH + '/' + "bookdetailslist");

        Library1 library1 = new Library1(availableBookList,bookList);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(library1);

        bibliotecaApp.displayWelcomeMessageInTheConsole();
        System.out.println();

        Scanner input = new Scanner(System.in);
        String flag = "yes";
        while (flag.equalsIgnoreCase("y") || flag.equalsIgnoreCase("yes")) {
            bibliotecaApp.displayMenuOption(System.in);
            System.out.println("Enter Y or N to continue or quit respectively: ");
            flag = input.next();
        }
        System.out.println();
        bibliotecaApp.displayMenuOption(System.in);

    }

    public void displayWelcomeMessageInTheConsole() {

        System.out.print("Welcome to Bibilioteca!!!");

    }


public boolean choosingMainMenuOption(int option) {

        if (option == 1) {
          displayListOfAvailableBooks();

        } else if (option == 2) {
            System.exit(0);

        } else if (option == 3) {
            displayListOfLibraryBooksForCheckingOut(System.in);

        } else if (option == 4) {
            displayForReturningTheLibraryBook(System.in);
        } else {
            return false;
        }

        return true;
    }

    public void displayListOfAvailableBooks()
    {
            new ListOutOption(library1).displayListOfLibraryBooksWithDetails();


    }


    public void displayListOfLibraryBooksForCheckingOut(InputStream inContent) {
        boolean checkedOut;
        Scanner input = new Scanner(inContent);
        new ListOutOption(library1).displayListOfLibraryBooksWithDetails();

        System.out.println("Enter the corresponding book name to check out:");

        String bookName = input.nextLine();

        checkedOut = new CheckoutOption(library1).checkout(bookName);

        if (!checkedOut) {
            System.out.println("Sorry ! That book is not available");
            System.out.println();
        } else {
            System.out.println("Thank you! Enjoy the book");
        }

    }

    private void displayForReturningTheLibraryBook(InputStream inContent) {

        boolean returned;

        Scanner input = new Scanner(inContent);
        System.out.println("Enter the name of the book to be returned:");

        returned = new ReturnOption(library1).returnABook(input.nextLine());
        if (!returned) {

            System.out.println("That is not a valid book to return");
            System.out.println();
        } else {
            System.out.println("Thank you for returning the book");
        }
    }


    public  void displayMenuOption(InputStream inContent) {

        boolean validOption;

        System.out.printf("%-50s\n", "MAIN MENU");
        System.out.println("**********************************************");

        System.out.printf("%-30s\n", "Option 1: List the library books");
        System.out.printf("%-30s\n", "Option 2: Quit ");
        System.out.printf("%-30s\n", "Option 3: Check out a Book ");
        System.out.printf("%-30s\n", "Option 4: Return a Book ");


        System.out.println();
        System.out.printf("%-30s\n", "Please enter your option:");

        Scanner input = new Scanner(inContent);
        validOption = choosingMainMenuOption(Integer.parseInt(input.next()));


        if (!validOption)
            System.out.println("Select a valid option!");
    }

}
