package com.twu.biblioteca;

import com.twu.biblioteca.command.CheckoutOption;
import com.twu.biblioteca.command.ListOutOption;
import com.twu.biblioteca.command.ReturnOption;
import com.twu.biblioteca.model.Library1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by abhinaym on 13/01/15.
 */
public class BibliotecaApp {

    private static LoginValidator loginValidator = new LoginValidator();
    private Library1 library1;
    private static final String FILE_PATH = "/Users/abhinaym/Downloads/TWU_Biblioteca-master/src/files";

    public BibliotecaApp(Library1 library1) {
        this.library1 = library1;
    }

    Customer customer1 = new Customer("Abhinaya", "abhinayacric@gmail.com", "1234567890", "abc-defg", "abhinayaTW");
    Customer customer2 = new Customer("Anu", "anucric@gmail.com", "1236567890", "dfg-hjkl", "anusuyaTW");
    ArrayList<Customer> customerList = new ArrayList<Customer>(Arrays.asList(customer1, customer2));


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


    public void choosingMainMenuOption(int option) {

        switch (option) {
            case 1:
                new ListOutOption(library1).displayListOfLibraryBooksWithDetails();
                break;
            case 2:
                System.exit(0);
                break;
            case 3:
                while (!loginValidator.isLoggedIn()) {
                    displayForEnteringLoginInfo();
                }

                System.out.println("Enter the corresponding book name to check out:");
                String bookName = new Scanner(System.in).nextLine();
                new CheckoutOption(library1).checkout(bookName);

            case 4:
                Scanner input = new Scanner(System.in);
                System.out.println("Enter the name of the book to be returned:");
                new ReturnOption(library1).returnABook(input.nextLine());

            default:
                System.out.println("Select a valid option!");
        }
    }


    private void displayForEnteringLoginInfo() {
        String libraryNo, password;
        Scanner inputLibNum = new Scanner(System.in);
        Scanner inputPassword = new Scanner(System.in);

        System.out.println("Enter the library number:");
        libraryNo = inputLibNum.next();
        System.out.println("Enter the password:");
        password = inputPassword.next();

        loginValidator.validateCustomerLogin(customerList, libraryNo, password);
    }

    public void displayMenuOption(InputStream inContent) {
        System.out.printf("%-50s\n", "MAIN MENU");
        System.out.println("**********************************************");

        System.out.printf("%-30s\n", "Option 1: List the library books");
        System.out.printf("%-30s\n", "Option 2: Quit ");
        System.out.printf("%-30s\n", "Option 3: Check out a Book ");
        System.out.printf("%-30s\n", "Option 4: Return a Book ");

        System.out.println();
        System.out.printf("%-30s\n", "Please enter your option:");

        Scanner input = new Scanner(inContent);
        choosingMainMenuOption(Integer.parseInt(input.next()));

    }

}
