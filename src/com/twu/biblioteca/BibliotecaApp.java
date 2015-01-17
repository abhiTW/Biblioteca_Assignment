package com.twu.biblioteca;

import com.twu.biblioteca.command.CheckoutOption;
import com.twu.biblioteca.command.ListOutOption;
import com.twu.biblioteca.command.LogInOption;
import com.twu.biblioteca.command.ReturnOption;

import com.twu.biblioteca.model.Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by abhinaym on 13/01/15.
 */

public class BibliotecaApp {

    private Library bookLibrary;
    private Library movieLibrary;
    private static final String FILE_PATH = "/Users/abhinaym/Downloads/TWU_Biblioteca-master/src/files";
    Customer loggedInCustomer;

    public BibliotecaApp(Library bookLibrary, Library movieLibrary) {
        this.bookLibrary = bookLibrary;
        this.movieLibrary = movieLibrary;
    }

    Customer customer1 = new Customer("Abhinaya", "abhinayacric@gmail.com", "1234567890", "abc-defg", "abhinayaTW");
    Customer customer2 = new Customer("Anu", "anucric@gmail.com", "1236567890", "dfg-hjkl", "anusuyaTW");
    ArrayList<Customer> customerList = new ArrayList<Customer>(Arrays.asList(customer1, customer2));
    private LoginValidator loginValidator = new LoginValidator(customerList);

    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        ArrayList<Item> bookList = inputParser.createBookListFromFile(FILE_PATH + '/' + "bookdetailslist");
        ArrayList<Item> availableBookList = inputParser.createBookListFromFile(FILE_PATH + '/' + "bookdetailslist");
        Library bookLibrary = new Library(availableBookList, bookList);

        ArrayList<Item> movieList = inputParser.createMovieListFromFile(FILE_PATH + '/' + "moviedetailslist");
        ArrayList<Item> availableMovieList = inputParser.createMovieListFromFile(FILE_PATH + '/' + "moviedetailslist");
        Library movieLibrary = new Library(availableMovieList, movieList);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bookLibrary, movieLibrary);

        bibliotecaApp.displayWelcomeMessageInTheConsole();
        System.out.println();

        Scanner input = new Scanner(System.in);
        String flag = "yes";
        while (flag.equalsIgnoreCase("y") || flag.equalsIgnoreCase("yes")) {
            bibliotecaApp.displayMenuOption();
            bibliotecaApp.choosingMainMenuOption(Integer.parseInt(input.next()));
            System.out.println("Enter Y or N to continue or quit respectively: ");
            flag = input.next();

        }
    }

    public void displayWelcomeMessageInTheConsole() {
        System.out.print("Welcome to Bibilioteca!!!");
    }

    public void choosingMainMenuOption(int option) {

        Scanner input = new Scanner(System.in);
        String itemName;

        switch (option) {
            case 1:
                new ListOutOption(bookLibrary).displayListOfLibraryBooksWithDetails();
                break;
            case 2:
                new ListOutOption(movieLibrary).displayListOfLibraryMoviesWithDetails();
                break;
            case 3:
                System.out.println("The System is Exiting....");
                System.exit(0);
                break;
            case 4:
                if (loggedInCustomer == null) {
                    System.out.println("Sorry LOGIN first to check out a book !");
                } else {
                    System.out.println("Enter a bookname to checkout:");
                    itemName = input.nextLine();
                    new CheckoutOption(bookLibrary).checkout(itemName, loggedInCustomer);
                }
                break;
            case 5:
                if (loggedInCustomer == null) {
                    System.out.println("Sorry LOGIN first to return a book !");
                } else {
                    System.out.println("Enter the name of the book to return:");
                    itemName = input.nextLine();
                    new ReturnOption(bookLibrary).returnABook(itemName);
                }
                break;
            case 6:
                if (loggedInCustomer == null) {
                    System.out.println("Sorry LOGIN first to check out a movie !");

                } else {
                    System.out.println("Enter the name of the movie to check out:");
                    itemName = input.nextLine();
                    new CheckoutOption(movieLibrary).checkoutAMovie(itemName, loggedInCustomer);
                }
                break;
            case 7:
                if (loggedInCustomer == null) {
                    System.out.println("Sorry LOGIN first to return a movie !");
                } else {
                    System.out.println("Enter the name of the movie to return:");
                    itemName = input.nextLine();
                    new ReturnOption(movieLibrary).returnAMovie(itemName);
                }
                break;
            case 8:
                if (loggedInCustomer != null) {
                    System.out.println("You are already logged into the system");
                } else {
                    loggedInCustomer = new LogInOption(loginValidator).getUserInputForAuthentication();
                }
                break;
            case 9:
                if (loggedInCustomer == null) {
                    System.out.println("Sorry LOGIN first to know who has checked out a book!");
                } else {
                    new ListOutOption(bookLibrary).displayListOfLibraryBooksWithTheCustomerWhoCheckedOut();
                }
                break;
            case 10:
                if (loggedInCustomer == null) {
                    System.out.println("Sorry LOGIN first to view your contact information!");
                } else {
                    new ListOutOption(bookLibrary).displayContactInformationOfTheLoggedInUser(loggedInCustomer);
                }
                break;
            default:
                System.out.println("Select a valid option!");
        }
    }

    public void displayMenuOption() {
        System.out.printf("%-50s\n", "MAIN MENU");
        System.out.println("**********************************************");

        System.out.printf("%-30s\n", "Option 1: List the library books");
        System.out.printf("%-30s\n", "Option 2: List the movies");
        System.out.printf("%-30s\n", "Option 3: Quit ");
        System.out.printf("%-30s\n", "Option 4: Check out a Book ");
        System.out.printf("%-30s\n", "Option 5: Return a Book ");
        System.out.printf("%-30s\n", "Option 6: Check out a Movie");
        System.out.printf("%-30s\n", "Option 7: Return a Movie ");
        System.out.printf("%-30s\n", "Option 8: Login to the system ");
        System.out.printf("%-30s\n", "Option 9: List of customers and the books they have checked out");
        System.out.printf("%-30s\n", "Option 10: View your information");
        System.out.println();
        System.out.printf("%-30s\n", "Please enter your option:");
    }

}
