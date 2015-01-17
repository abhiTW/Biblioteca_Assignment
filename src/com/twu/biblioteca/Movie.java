package com.twu.biblioteca;



public class Movie extends Item {

    String yearOfRelease;

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public String getDirector() {
        return director;
    }

    public String getMovieRating() {
        return movieRating;
    }

    String director;
    String movieRating;

    public Movie(String name,String yearOfRelease, String director, String movieRating) {

        super(name);
        this.yearOfRelease = yearOfRelease;
        this.director = director;
        this.movieRating = movieRating;
    }


}
