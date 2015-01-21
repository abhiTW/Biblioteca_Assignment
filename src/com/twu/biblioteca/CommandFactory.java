package com.twu.biblioteca;

import com.twu.biblioteca.command.*;
import com.twu.biblioteca.model.Library;

/**
 * Created by abhinaym on 18/01/15.
 */
public class CommandFactory {

    public static Command createCommand(int menuOption, Library bookLibrary, Library movieLibrary,LoginValidator loginValidator) {
        switch (menuOption) {
            case 1:
                return new ListOutOptionBook(bookLibrary);
            case 2:
                return new ListOutOptionMovie(movieLibrary);
            case 3:
                System.out.println("The System is Exiting....");
                System.exit(0);
                break;
            case 4:
                return new CheckoutOptionBook(bookLibrary,loginValidator);
            case 5:
                return new ReturnOptionBook(bookLibrary,loginValidator);
            case 6:
                return new CheckOutOptionMovie(movieLibrary,loginValidator);
            case 7:
                return new ReturnOptionMovie(movieLibrary,loginValidator);
            case 8:
                return new LogInOption(loginValidator);
            case 9:
                return new ListOutTheCheckedOutBooksOption(bookLibrary,loginValidator);
            case 10:
                return new ViewCustomerInfoOption(loginValidator);
            default:
                System.out.println("Select a valid option!");
                break;
        }

        return null;
    }

}
