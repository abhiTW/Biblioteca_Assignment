package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by abhinaym on 14/01/15.
 */
public class BookTest {

 @Test
   public void checkBookEqualsMethod()
 {
     Book book1 = new Book("After Many a Summer Dies the Swan", "Aldous Huxley", "1765");
     Book book2 = new Book("After Many a Summer Dies the Swan", "Aldous Huxley", "1765");
     assertThat("@BookTest Class",book1,is(book2));

 }

}
