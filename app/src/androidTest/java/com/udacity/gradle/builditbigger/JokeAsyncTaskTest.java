package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Rutwik on 23/01/16.
 */
public class JokeAsyncTaskTest extends AndroidTestCase {

    JokeAsyncTask mjokeasynctask;

    public void testAsynccheck(){
        mjokeasynctask.execute();

        try {
            String joketest=mjokeasynctask.get(30, TimeUnit.SECONDS);
            assertNotNull(joketest);
            assertNotSame(joketest,"");

        } catch (Exception e) {
            fail("Error Test Failed");
        }
    }
}
