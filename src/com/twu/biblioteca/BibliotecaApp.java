package com.twu.biblioteca;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by abhinaym on 13/01/15.
 */
public class BibliotecaApp {

    private Library library = new Library();

    public static void main(String[] args) {

        BibliotecaApp customerRequest = new BibliotecaApp();
        customerRequest.displayWelcomeMessageInTheConsole();
        System.out.println();
        Scanner input = new Scanner(System.in);

        String flag = "yes";
        while (flag.equalsIgnoreCase("y") || flag.equalsIgnoreCase("yes")) {

            customerRequest.displayMenuOption(System.in);

            System.out.println("Enter Y or N to continue or quit respectively: ");
            flag = input.next();

        }
        System.out.println();
        customerRequest.displayMenuOption(System.in);

    }

    public void displayWelcomeMessageInTheConsole() {

        System.out.print("Welcome to Bibilioteca!!!");

    }

    public boolean choosingMainMenuOption(int option) {

        if (option == 1) {
            library.displayListOfLibraryBooksWithDetails();

        }
        else if (option == 2) {
            System.out.println("System Exiting .....");

        } else if (option == 3) {

            displayListOfLibraryBooksForCheckingOut(System.in);
        } else if (option == 4) {

            displayForReturningTheLibraryBook(System.in);
        } else {
            return false;
        }

        return true;
    }

    public void displayListOfLibraryBooksForCheckingOut(InputStream inContent) {


        boolean checkedOut;
        library.displayListOfLibraryBooksWithDetails();

        Scanner input = new Scanner(inContent);
        System.out.println("Enter the corresponding book number to check out:");


        checkedOut = library.checkOutOfBooks(input.nextInt());
        if(!checkedOut)
        {
            System.out.println("Sorry ! That book is not available");
            System.out.println();
        }
        else
        {
            System.out.println("Thank you! Enjoy the book");
        }

    }

    public void displayForReturningTheLibraryBook(InputStream inContent) {

        boolean returned;

        Scanner input = new Scanner(inContent);
        System.out.println("Enter the number of the book to be returned:");

        returned = library.returnOfBooks(input.nextInt());
        if(!returned) {

            System.out.println("That is not a valid book to return");
            System.out.println();
        }
        else
        {
            System.out.println("Thank you for returning the book");
        }
    }


    public void displayMenuOption(InputStream inContent) {

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


        if(!validOption)
            System.out.println("Select a valid option!");
    }

}
