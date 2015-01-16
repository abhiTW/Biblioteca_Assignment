package com.twu.biblioteca;

import com.twu.biblioteca.command.CheckoutOption;
import com.twu.biblioteca.command.ListOutOption;
import com.twu.biblioteca.command.LogInOption;
import com.twu.biblioteca.command.ReturnOption;
import com.twu.biblioteca.model.Library1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by abhinaym on 13/01/15.
 */

public class BibliotecaApp {

    private Library1 library1;
    private static final String FILE_PATH = "/Users/abhinaym/Downloads/TWU_Biblioteca-master/src/files";
    Customer loggedInCustomer;

    public BibliotecaApp(Library1 library1) {
        this.library1 = library1;
    }

    Customer customer1 = new Customer("Abhinaya", "abhinayacric@gmail.com", "1234567890", "abc-defg", "abhinayaTW");
    Customer customer2 = new Customer("Anu", "anucric@gmail.com", "1236567890", "dfg-hjkl", "anusuyaTW");
    ArrayList<Customer> customerList = new ArrayList<Customer>(Arrays.asList(customer1, customer2));

    private LoginValidator loginValidator = new LoginValidator(customerList);


    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        ArrayList<Book> bookList = inputParser.updateBookListFromFile(FILE_PATH + '/' + "bookdetailslist");
        ArrayList<Book> availableBookList = inputParser.updateBookListFromFile(FILE_PATH + '/' + "bookdetailslist");

        Library1 library1 = new Library1(availableBookList, bookList);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(library1);

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
        String bookName;
        switch (option) {
            case 1:
                new ListOutOption(library1).displayListOfLibraryBooksWithDetails();
                break;
            case 2:
                System.exit(0);
                break;
            case 3:
                if(loggedInCustomer== null) {
                    System.out.println("Sorry LOGIN first to check out a book !");
                }
                else{
                    System.out.println("Enter a bookName to checkOut:");
                    bookName =input.nextLine();
                    new CheckoutOption(library1).checkout(bookName,loggedInCustomer);
                }
                break;
            case 4:
                if(loggedInCustomer== null) {
                    System.out.println("Sorry LOGIN first to check out a book !");
                }
                else {
                    System.out.println("Enter the name of the book to be returned:");
                    bookName = input.nextLine();
                    new ReturnOption(library1).returnABook(bookName);
                }
                break;
            case 5:
                loggedInCustomer = new LogInOption(loginValidator).getUserInputForAuthentication();
                break;
            case 6:
                if(loggedInCustomer== null) {
                    System.out.println("Sorry LOGIN first to know who has checked out a book!");
                }
                else {
                    new ListOutOption(library1).displayListOfLibraryBooksWithTheCustomerWhoCheckedOut();
                }
                break;
            case 7:
                if(loggedInCustomer== null) {
                    System.out.println("Sorry LOGIN first to view your contact information!");
                }
                else
                {
                    new ListOutOption(library1).displayContactInformationOfTheLoggedInUser(loggedInCustomer);
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
        System.out.printf("%-30s\n", "Option 2: Quit ");
        System.out.printf("%-30s\n", "Option 3: Check out a Book ");
        System.out.printf("%-30s\n", "Option 4: Return a Book ");
        System.out.printf("%-30s\n", "Option 5: Login to the system ");
        System.out.printf("%-30s\n", "Option 6: List of customers and the books they have checked out");
        System.out.printf("%-30s\n", "Option 7: View your information");
        System.out.println();
        System.out.printf("%-30s\n", "Please enter your option:");
    }

}
