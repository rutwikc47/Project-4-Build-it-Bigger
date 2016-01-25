package com.udacity.gradle.jokes;

import java.util.Random;

public class Joker {


    String [] jokescc={"Today a man knocked on my door and asked for a small donation towards the local swimming pool. I gave him a glass of water.","Artificial intelligence is no match for natural stupidity.","I started out with nothing, and I still have most of it.","Oops. My brain just hit a bad sector."};

    public String getJoke(){

        return jokescc[new Random().nextInt(jokescc.length)];
    }
}