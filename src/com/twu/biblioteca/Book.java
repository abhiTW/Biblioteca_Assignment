package com.twu.biblioteca;

/**
 * Created by abhinaym on 12/01/15.
 */
public class Book {


    private String name;
    private String author_Name;
    private String    yearOfPublication;
    private  boolean checkedOut= false;


    Book(String name,String author_Name,String yearOfPublication)

    {
            this.name = name;
            this.author_Name = author_Name;
            this.yearOfPublication = yearOfPublication;

    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
    public boolean isCheckedOut() {
        return checkedOut;
    }




}
