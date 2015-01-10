package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ExampleTest {


    private static final String GOLD_PATH ="/Users/abhinaym/Downloads/TWU_Biblioteca-master/out/textfiles" ;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private BibliotecaApp testInstance = new BibliotecaApp();



    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void checkWelcomeConsoleMessage() {


        testInstance.displayWelcomeMessageInTheConsole();
        assertEquals("Welcome to Bibilioteca!!!", outContent.toString());


    }

    @Test
    public void checkListOfLibraryBooks() throws IOException {

        testInstance.displayListOfLibraryBooks();
        verifyOutput(outContent.toString(), "booklist");


    }


    protected void verifyOutput(String actualValue, String fileName) throws IOException {


        BufferedReader file = new BufferedReader(new FileReader(GOLD_PATH + '/' + fileName));
        BufferedReader actualStream = new BufferedReader(new StringReader(actualValue));

        String thisFileLine;
        while ((thisFileLine = file.readLine()) != null) {
            assertThat("in file: " + fileName, actualStream.readLine(), equalTo(thisFileLine));


        }


    }
}
