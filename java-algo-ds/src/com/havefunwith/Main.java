package com.havefunwith;

import com.havefunwith.algorithms.GreetingAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        GreetingAlgo myAlgo = new GreetingAlgo();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String userInput = reader.readLine();

        String greeting = myAlgo.greeting(userInput);

        System.out.println(greeting);
    }
}
