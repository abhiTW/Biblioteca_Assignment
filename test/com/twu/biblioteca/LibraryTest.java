package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void shouldCheckOutABook() {
        //setup
        Book book = new Book("", "", "");
        ArrayList<Item> books1 = new ArrayList<>();
        books1.add(book);
        Library library = new Library(books1,books1);

        //action
        library.checkOut(book);

        //assert
        assertThat(library.getAvailableItemList().size(), is(0));
    }

    @Test
    public void shouldCheckFindByName()  {

        String bookName = "All Passion Spent";
        Book book = new Book(bookName, "abh", "abhdsch");

        ArrayList<Item> books1 = new ArrayList<>();
        books1.add(book);
        Library library = new Library(books1,books1);

        Book newBook = (Book)library.find(bookName);
        assertThat("@Find", newBook,is(book));
    }

    @Test
    public void shouldReturnNullIfBookIsUnavailable()  {

        String bookName1 = "Ask Me";
        Book book1 = new Book(bookName1, "abh", "abhdsch");
        String bookName2 = "All Passion Spent";


        ArrayList<Item> books1 = new ArrayList<>();
        books1.add(book1);
        Library library = new Library(books1,books1);

        Book newBook = (Book)library.find(bookName2);
        assertNull(newBook);

    }

    @Test
    public void shouldUpdateBookListWithReturnedBook() {
        String bookName = "All Passion Spent";
        Book book = new Book(bookName, "abh", "abhdsch");

        ArrayList<Item> books1 = new ArrayList<>();
        Library library = new Library(books1,books1);

        assertThat(library.returnItem(book), is(true));

        assertThat(books1.size(), is(1));
    }





}