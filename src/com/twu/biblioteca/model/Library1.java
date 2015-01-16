package com.twu.biblioteca.model;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library1 {

    private List<Book> bookList;
    private List<Book> availableBookList;

    Map<Customer,Book> customerBookMap = new HashMap<Customer,Book>();

    public Library1(List<Book> availableBookList,List<Book> bookList) {
        this.availableBookList = availableBookList;
        this.bookList = bookList;
    }

    public List<Book> getAvailableBookList() {
        return availableBookList;
    }

    public Map<Customer,Book> getCustomerBookMap(){
        return customerBookMap;
    };

    public void updateCustomerBookMap(Customer customer,Book book) {
      customerBookMap.put(customer,book);
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
}

