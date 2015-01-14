package com.twu.biblioteca;

/**
 * Created by abhinaym on 12/01/15.
 */
public class Book {


    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    private String name;
    private String authorName;
    private String    yearOfPublication;
    private  boolean checkedOut= false;


    Book(String name,String authorName,String yearOfPublication)

    {
            this.name = name;
            this.authorName = authorName;
            this.yearOfPublication = yearOfPublication;

    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
    public boolean isCheckedOut() {
        return checkedOut;
    };


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (checkedOut != book.checkedOut) return false;
        if (!authorName.equals(book.authorName)) return false;
        if (!name.equals(book.name)) return false;
        if (!yearOfPublication.equals(book.yearOfPublication)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + authorName.hashCode();
        result = 31 * result + yearOfPublication.hashCode();
        result = 31 * result + (checkedOut ? 1 : 0);
        return result;
    }
}
