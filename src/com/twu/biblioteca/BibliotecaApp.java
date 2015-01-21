package com.twu.biblioteca;

import com.twu.biblioteca.command.*;

import com.twu.biblioteca.model.Library;

import java.lang.reflect.InvocationTargetException;
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

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        InputParser inputParser = new InputParser();
        ArrayList<Item> bookList = inputParser.createBookListFromFile(FILE_PATH + '/' + "bookdetailslist");
        ArrayList<Item> availableBookList = new ArrayList<Item>(bookList);
        Library bookLibrary = new Library(availableBookList, bookList);

        ArrayList<Item> movieList = inputParser.createMovieListFromFile(FILE_PATH + '/' + "moviedetailslist");
        ArrayList<Item> availableMovieList =  new ArrayList<>(movieList);
        Library movieLibrary = new Library(availableMovieList, movieList);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(bookLibrary, movieLibrary);
        bibliotecaApp.displayWelcomeMessageInTheConsole();
        System.out.println();
        Scanner input = new Scanner(System.in);
        while(true) {
            bibliotecaApp.displayMenuOption();
            bibliotecaApp.choosingMainMenuOption(Integer.parseInt(input.next()));
        }

        }

    public void displayWelcomeMessageInTheConsole() {
        System.out.print("Welcome to Bibilioteca!!!");
    }

    public void choosingMainMenuOption(int option) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Command command = CommandFactory.createCommand(option,bookLibrary,movieLibrary,loginValidator);

        if(command!=null)
        command.execute();
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
