package com.twu.biblioteca;

public class Book extends Item  {

    public String getAuthorName() {
        return authorName;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }



    private String authorName;
    private String yearOfPublication;

    public Book(String name,String authorName, String yearOfPublication) {
            super(name);
            this.authorName = authorName;
            this.yearOfPublication = yearOfPublication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
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
        return result;
    }
}
