package com.twu.biblioteca.command;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.model.Library;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by abhinaym on 19/01/15.
 */
public class ListOutOptionMovie extends Command {
    private Library library;

    public ListOutOptionMovie(Library library) {
        this.library = library;
    }

    public void displayListOfLibraryMoviesWithDetails() {
        int ctr = 0;
        for (Item item : library.getAvailableItemList()) {

            Movie movie  = (Movie)item;
            System.out.printf("%-20d%-40s%-40s%s\n", ++ctr,movie.getName(),movie.getDirector(),movie.getMovieRating());
        }
    }

    @Override
    public void execute() {
        displayListOfLibraryMoviesWithDetails();

    }
}
