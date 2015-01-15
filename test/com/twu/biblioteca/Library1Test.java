package com.twu.biblioteca;

import com.twu.biblioteca.model.Library1;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Library1Test {

    @Test
    public void shouldCheckOutABook() {
        //setup
        Book book = new Book("", "", "");
        ArrayList<Book> books1 = new ArrayList<>();
        books1.add(book);
        Library1 library = new Library1(books1,books1);

        //action
        library.checkOut(book);

        //assert
        assertThat(library.getAvailableBookList().size(), is(0));
    }

    @Test
    public void shouldCheckFindByName()  {

        String bookName = "All Passion Spent";
        Book book = new Book(bookName, "abh", "abhdsch");

        ArrayList<Book> books1 = new ArrayList<>();
        books1.add(book);
        Library1 library = new Library1(books1,books1);

        Book newBook = library.find(bookName);
        assertThat("@Find", newBook,is(book));
    }

    @Test
    public void shouldReturnNullIfBookIsUnavailable()  {

        String bookName1 = "Ask Me";
        Book book1 = new Book(bookName1, "abh", "abhdsch");
        String bookName2 = "All Passion Spent";
       // Book book2 = new Book(bookName1, "abh", "abhdsch");

        ArrayList<Book> books1 = new ArrayList<>();
        books1.add(book1);
        Library1 library = new Library1(books1,books1);

        Book newBook = library.find(bookName2);
        assertNull(newBook);
        //assertEquals(newBook,null);
    }

    @Test
    public void shouldUpdateBookListWithReturnedBook() {
        String bookName = "All Passion Spent";
        Book book = new Book(bookName, "abh", "abhdsch");

        ArrayList<Book> books1 = new ArrayList<>();
        Library1 library = new Library1(books1,books1);

        assertThat(library.returnBook(book), is(true));

        assertThat(books1.size(), is(1));
    }





}