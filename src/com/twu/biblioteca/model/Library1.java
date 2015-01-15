package com.twu.biblioteca.model;
import com.twu.biblioteca.Book;
import java.util.List;

public class Library1 {

    private List<Book> bookList;
    private List<Book> availableBookList;

    public Library1(List<Book> availableBookList,List<Book> bookList) {
        this.availableBookList = availableBookList;
        this.bookList = bookList;
    }

    public List<Book> getAvailableBookList() {
        return availableBookList;
    }

    public void checkOut(Book book) {
        availableBookList.remove(book);
    }

    public Book find(String bookName) {
        for (Book book : availableBookList) {
            if (book.getName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    public Book findForReturn(String bookName) {
        for (Book book : bookList) {
            if (book.getName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }


    public boolean returnBook(Book book) {
        availableBookList.add(book);
        return true;
    }


    public void displayListOfReturnedBooks()
    {

    }
}

