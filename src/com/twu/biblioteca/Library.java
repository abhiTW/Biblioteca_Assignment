package com.twu.biblioteca;
import java.util.List;

public class Library {

    private List<Book> bookList;

    public Library(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void displayListOfLibraryBooksWithDetails() {

        int ctr = 0;

        for (Book book : bookList) {
            if (bookList.get(ctr++).isCheckedOut())

                continue;
            System.out.printf("%-20d%-40s%-40s%s\n", ctr, book.getName(), book.getAuthorName(), book.getYearOfPublication());

        }
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public boolean checkOutOfBooks(int bookNo) {
        if ((bookNo - 1) <= bookList.size()) {

            bookList.get(bookNo - 1).setCheckedOut(true);
            displayListOfLibraryBooksWithDetails();
        } else {
            return false;
        }
        return true;
    }


    public boolean returnOfBooks(int bookNo) {

        if ((bookNo - 1) <= bookList.size()) {

            if (!bookList.get(bookNo - 1).isCheckedOut()) {
                return false;
            } else {
                bookList.get(bookNo - 1).setCheckedOut(false);

                displayListOfLibraryBooksWithDetails();
                return true;
            }
        } else {
            return false;
        }
    }


}
