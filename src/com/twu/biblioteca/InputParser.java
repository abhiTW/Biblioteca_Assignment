package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by abhinaym on 13/01/15.
 */
public class InputParser {

    public ArrayList<Book> updateBookListFromFile(String fileName)
    {
        ArrayList<Book> bookList = new ArrayList<Book>();
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



}
