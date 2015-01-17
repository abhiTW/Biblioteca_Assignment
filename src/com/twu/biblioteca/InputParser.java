package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by abhinaym on 13/01/15.
 */
public class InputParser {

    public ArrayList<Item> createBookListFromFile(String fileName)
    {
        ArrayList<Item> bookList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String sCurrentLine;


            while ((sCurrentLine = br.readLine()) != null) {
                String[] bookName = sCurrentLine.split(",");
                Book book = new Book(bookName[0],bookName[1],bookName[2]);
                bookList.add(book);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookList;
    }


    public ArrayList<Item> createMovieListFromFile(String fileName)
    {
        ArrayList<Item> bookList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String sCurrentLine;


            while ((sCurrentLine = br.readLine()) != null) {
                String[] movieName = sCurrentLine.split(",");
                Movie movie = new Movie(movieName[0],movieName[1],movieName[2],movieName[3]);
                bookList.add(movie);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookList;
    }

}
