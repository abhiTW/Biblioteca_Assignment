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
    }




}
