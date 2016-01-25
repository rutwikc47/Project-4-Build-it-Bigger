package com.rccorp.p4backend;

import com.udacity.gradle.jokes.Joker;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public void setData(String data) {
        myData = data;
    }

    public String getData() {
        return myData;
    }


}