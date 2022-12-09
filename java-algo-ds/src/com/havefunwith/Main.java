package com.havefunwith;

import com.havefunwith.algorithms.ValidateSubsequence;

import java.io.IOException;
import java.util.Scanner;

import static com.havefunwith.helpers.Helper.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int algoInput;
        do {
            algoInput = promptUser();

            if (algoInput == 1) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    int solutionOption = 1;
                    if (ValidateSubsequence.getCounter() > 1) {
                        displaySolutionOptions(ValidateSubsequence.getCounter(), ValidateSubsequence.getSolutions());
                        solutionOption = Integer.parseInt(scanner.nextLine());
                    }
                    Boolean output = ValidateSubsequence.availableSolutions(solutionOption);
                    if (output == true) algoInput = 0;
                } catch(Exception e) {
                    System.out.println("\nEXCEPTION :: Error " + e.getMessage() + "\n\n" +
                            "Try again with correct input example below: \n" +
                            correctInput("1,2,3", "No spaces in between each item in the array."));
                }
            }

        } while(algoInput != 0);
    }

}
