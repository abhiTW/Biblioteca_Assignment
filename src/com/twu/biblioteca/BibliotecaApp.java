package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BibliotecaApp {




    private static final String GOLD_PATH  =  "/Users/abhinaym/Downloads/TWU_Biblioteca-master/out/textfiles";

    public static void main(String[] args) {


        BibliotecaApp customerRequest = new BibliotecaApp();


        customerRequest.displayMenuOption();

        System.out.println();
        customerRequest.displayListOfLibraryBooksWithDetails();

        /*customerRequest.displayMenuOption();
        customerRequest.displayListOfLibraryBooks();*/

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

            while ((sCurrentLine = br.readLine()) != null) {


                String[] bookName = sCurrentLine.split("\\r?\\n");
                System.out.println(bookName[0]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void displayListOfLibraryBooksWithDetails() {


        try (BufferedReader br = new BufferedReader(new FileReader(GOLD_PATH + '/' + "bookdetailslist"))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {


                String[] bookName = sCurrentLine.split(",");

                System.out.printf("%-40s%-40s%s\n",bookName[0],bookName[1],bookName[2]);


                System.out.println();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }




    }


    public void choosingMainMenuOption(int option) {

        if(option == 1)
            displayListOfLibraryBooks();
        else if(option == 2)
        {
            System.out.println("System Exiting .....");
            System.exit(0);
        }
        else
        {
            System.out.println("Select a valid option!");

        }



    }


    public void displayMenuOption()
    {

        System.out.printf("%-50s\n", "MAIN MENU");
        System.out.println("**********************************************");

        System.out.printf("%-30s\n", "Option 1: List the library books");
        System.out.printf("%-30s\n", "Option 2: Quit ");

        System.out.println();
        System.out.printf("%-30s\n", "Please enter your option:");
        Scanner input = new Scanner(System.in);
       choosingMainMenuOption(input.nextInt());

    }
}
