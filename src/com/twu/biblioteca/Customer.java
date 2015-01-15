package com.twu.biblioteca;

/**
 * Created by abhinaym on 15/01/15.
 */
public class Customer {

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getLibNo() {
        return libNo;
    }

    public String getPassword() {
        return password;
    }

    private  String name;
    private  String emailAddress;
    private  String phoneNo;
    private  String libNo;
    private  String password;


    public Customer(String name, String emailAddress, String phoneNo, String libNo, String password) {

            this.name = name;
            this.emailAddress = emailAddress;
            this.phoneNo= phoneNo;
            this.libNo= libNo;
            this.password = password;
    }
}
