package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by abhinaym on 13/01/15.
 */
public class BibliotecaApp {


    private Librarian librarian = new Librarian();




    public static void main(String[] args) {

        BibliotecaApp customerRequest = new BibliotecaApp();
        customerRequest.displayWelcomeMessageInTheConsole();
        System.out.println();
        Scanner input = new Scanner(System.in);

        String flag = "yes";
        while (flag.equalsIgnoreCase("y") || flag.equalsIgnoreCase("yes")) {

            customerRequest.displayMenuOption();

            System.out.println("Enter Y or N to continue or quit respectively: ");
            flag = input.next();

        }
        System.out.println();
        customerRequest.displayMenuOption();

    }

    public void displayWelcomeMessageInTheConsole() {

        System.out.print("Welcome to Bibilioteca!!!");

    }

    public void choosingMainMenuOption(int option) {

        if (option == 1)
            librarian.displayListOfLibraryBooksWithDetails();
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

    private void displayListOfLibraryBooksForCheckingOut() {

        librarian.displayListOfLibraryBooksWithDetails();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the corresponding book number to check out:");
        librarian.checkOutOfBooks(input.nextInt());
    }

    private void displayForReturningTheLibraryBook() { 

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of the book to be returned:");
        librarian.returnOfBooks(input.nextInt());
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


}
