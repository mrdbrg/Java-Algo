package com.havefunwith.algorithms;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static com.havefunwith.helpers.Helper.*;

public class TwoNumberSum {

    public static int counter = 2;
    public static String[] solutions = {"Two For Loop", "HashSet & One For Loop"};

    public static int getCounter() {
        return counter;
    }

    public static String[] getSolutions() {
        return solutions;
    }

    /**
     *
     * Two for loop solution.
     *
     * O(n^2) Time complexity
     * The algorithm is traversing the array twice. Because of this double iteration,
     * the algorithm will perform iterations n times twice.
     *
     * O(1) Space complexity
     * There is no major use of memory on this algorithm. The only use of memory to store
     * data is to store the first and second numbers.
     *
     * @param array
     * @param targetSum
     * @return
     */
    public static int[] solutionOne(int[] array, int targetSum) {
        // iterate over the array up to the number before the last one.
        for (int i = 0; i < array.length - 1; i++) {
            // assign first number
            int firstNumber = array[i];
            // iterate over the array again. This time to sum the first number
            // with the second number to find the target sum
            for (int j = i + 1; j < array.length; j++) {
                int secondNumber = array[j];
                if (firstNumber + secondNumber == targetSum) {
                    System.out.println("[" + firstNumber + "," + secondNumber + "]" );
                    return new int[] {firstNumber, secondNumber};
                }
            }
        }
        System.out.println("No two numbers equal to " + targetSum);
        return new int[0];
    }

    /**
     *
     * O(n) Time complexity
     * The algorithm is traversing the array only once and for each number we calculate
     * the potentialMatch. It's a constant time operation when performing this calculation.
     * When accessing the values in the HashSet, the operation is going to run in constant time.
     *
     * O(n) Space complexity
     * There are values being added to the HashSet. The HashSet could grow as large as the n
     * value of the array.
     *
     * @param array
     * @param targetSum
     * @return
     */
    public static int[] solutionTwo(int[] array, int targetSum) {
        // instantiate the hashset to collect the potential matches
        Set<Integer> set = new HashSet<>();

        // iterate over array
        for (int num : array) {
            // perform operation to find a potential match
            int potentialMatch = targetSum - num;
            // check if potential match is in the hashset
            // return an array of int[] with the potentialMatch and num
            if (set.contains(potentialMatch)) {
                System.out.println("[" + potentialMatch + "," + num + "]" );
                return new int[] {potentialMatch, num};
            } else {
                set.add(num);
            }
        }
        System.out.println("No two numbers equal to " + targetSum);
        return new int[0];
    }

    public static Boolean availableSolutions(int option) {
        if (option == 1) {
            solutionBanner("TWO FOR LOOP SOLUTION");
            int[][] values = algoTargetPrompt();
            System.out.println(TwoNumberSum.solutionOne(values[0], values[1][0]));
            return true;
        } else if (option == 2) {
            solutionBanner("HASHSET / FOR LOOP SOLUTION");
            int[][] values = algoTargetPrompt();
            System.out.println(TwoNumberSum.solutionTwo(values[0], values[1][0]));
            return true;
        } else {
            System.out.print("Not a valid option. Try again.\n\n");
            return false;
        }
    }

    /**
     *  Prompts user for algorithm values.
     *
     * @return
     */
    private static int[][] algoTargetPrompt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an array of integers:");
        arrowPrompt();
        int[] array = convertToIntArray(scanner.nextLine());

        System.out.println("Enter an integer target sum to be found:");
        arrowPrompt();
        int[] targetSum = convertToIntArray(scanner.nextLine());

        int[][] values = new int[][]{array, targetSum};

        return values;
    }

}
