package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BibliotecaApp {


    public static void main(String[] args) {


        BibliotecaApp customerRequest = new BibliotecaApp();
        customerRequest.displayListOfLibraryBooks();

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


        try (BufferedReader br = new BufferedReader(new FileReader("/Users/abhinaym/Downloads/TWU_Biblioteca-master/out/textfiles/booklist"))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {


                String[] bookName = sCurrentLine.split("\\r?\\n");
                System.out.println(bookName[0]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
