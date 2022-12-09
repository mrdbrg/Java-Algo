package com.havefunwith.algorithms;

import com.havefunwith.impl.HelperFields;

import java.util.List;
import java.util.Scanner;

import static com.havefunwith.helpers.Helper.*;
import static com.havefunwith.helpers.Helper.convertToList;

public class ValidateSubsequence {

    public static int counter = 2;
    public static String[] solutions = {"For Loop", "While Loop"};

    public static int getCounter() {
        return counter;
    }

    public static String[] getSolutions() {
        return solutions;
    }

    /**
     * For loop solution.
     *
     * O(n) Time Complexity
     * O(1) Space Complexity
     *
     * @param array
     * @param sequence
     * @return
     */
    public static Boolean solutionOne(List<Integer> array, List<Integer> sequence) {
        // declare index
        int index = 0;
        // traverse main array
        for (int i = 0; i < array.size(); i++) {
            // check if potential subsequence size is the same as index value: if true break out of loop
            if (index == sequence.size()) {
                break;
            }
            // condition: check if elements on main array are the same as elements
            // on sequence
            if (array.get(i) == sequence.get(index)) {
                index++;
            }
        }
        // return boolean response: sequence size equals to index value
        return index == sequence.size();
    }

    /**
     * While loop solution.
     *
     * O(n) Time complexity
     * O(1) Space complexity
     *
     * @param array
     * @param sequence
     * @return
     */
    public static Boolean solutionTwo(List<Integer> array, List<Integer> sequence) {

        int arrIdx = 0;
        int seqIdx = 0;

        while (arrIdx < array.size() && seqIdx < sequence.size()) {
            if (array.get(arrIdx) == sequence.get(seqIdx)) {
                seqIdx++;
            }
            arrIdx++;
        }
        return seqIdx == sequence.size();
    }

    /**
     *  Gives an option of available solutions.
     *
     * @param solutionOption
     * @return
     */
    public static Boolean availableSolutions(int solutionOption) {
        if (solutionOption == 1) {
            System.out.println("===========================");
            System.out.println("    FOR LOOP SOLUTION");
            System.out.println("===========================");
            int[][] values = promptForValues();
            System.out.println(ValidateSubsequence.solutionOne(convertToList(values[0]), convertToList(values[1])));
            return true;
        } else if (solutionOption == 2) {
            System.out.println("===========================");
            System.out.println("    WHILE LOOP SOLUTION");
            System.out.println("===========================");
            int[][] values = promptForValues();
            System.out.println(ValidateSubsequence.solutionOne(convertToList(values[0]), convertToList(values[1])));
            return true;
        } else {
            System.out.println("Not a valid option. Try again.\n\n");
            return false;
        }
    }

    /**
     * Prompts user for the array values.
     *
     * @return a two dimensional array of int[][]
     */
    private static int[][] promptForValues() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an array of integers:");
        arrowPrompt();
        int[] array =  convertToIntArray(scanner.nextLine());

        System.out.println("Enter a potential subsequence:");
        arrowPrompt();
        int[] sequence = convertToIntArray(scanner.nextLine());

        int[][] values = new int[][]{array, sequence};

        return values;
    }

}
