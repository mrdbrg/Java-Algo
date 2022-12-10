package com.havefunwith;

import com.havefunwith.algorithms.TwoNumberSum;
import com.havefunwith.algorithms.ValidateSubsequence;

import java.io.IOException;
import java.util.Scanner;

import static com.havefunwith.helpers.Helper.*;
import static com.havefunwith.helpers.Helper.throwException;

public class Main {

    public static void main(String[] args) throws IOException {

        int inputChoice;
        int option = 1;
        Scanner scanner = new Scanner(System.in);
        do {
            inputChoice = promptUser("Choose 1 :: ValidateSubsequence\n" +
                    "Choose 2 :: TwoNumberSum");

            if (inputChoice == 1) {
                try {
                    if (ValidateSubsequence.getCounter() > 1) {
                        displaySolutionOptions(ValidateSubsequence.getCounter(), ValidateSubsequence.getSolutions());
                        option = Integer.parseInt(scanner.nextLine());
                    }
                    Boolean output = ValidateSubsequence.availableSolutions(option);
                    if (output == true) inputChoice = 0;
                } catch(Exception e) {
                    throwException(e, new String[]{"1,2,3"}, new String[]{"No spaces in between each item in the array."});
                }
            } else if (inputChoice == 2) {
                try {
                    if (TwoNumberSum.getCounter() > 1) {
                        displaySolutionOptions(TwoNumberSum.getCounter(), TwoNumberSum.getSolutions());
                        option = Integer.parseInt(scanner.nextLine());
                    }
                    Boolean output = TwoNumberSum.availableSolutions(option);
                    if (output == true) inputChoice = 0;
                } catch(Exception e) {
                    throwException(e, new String[]{"1,2,3", "10"}, new String[]{"No spaces in between each item in the array.", "Second value must be an integer value."});
                }
            }

        } while(inputChoice != 0);
    }

}
