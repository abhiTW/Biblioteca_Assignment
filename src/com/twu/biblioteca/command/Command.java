package com.twu.biblioteca.command;

import com.twu.biblioteca.model.Library;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by abhinaym on 18/01/15.
 */
public abstract class Command {

    public abstract void execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

}
