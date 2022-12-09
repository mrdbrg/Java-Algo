package com.havefunwith.helpers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Helper {

    /**
     * Helps when an exception is thrown to advise user on proper input data .
     *
     * @param correctData
     * @param hint
     * @return
     */
    public static String correctInput(String correctData, String hint) {
        return "-> " + correctData + "\n*************************************************\n" +
                "=> " + hint + "\n\n";
    }

    /**
     * Prompts user to choose from a list of algorithms.
     *
     * @return user algorithm's choice
     */
    public static int promptUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose 1 :: ValidateSubsequence");
        arrowPrompt();
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Default arrow for user input.
     */
    public static void arrowPrompt() {
        System.out.print("-> ");
    }

    /**
     * This method converts a string to an int[] array.
     *
     * @param strVal
     * @return a int[] array
     */
    public static int[] convertToIntArray(String strVal) {
        String[] numStr = strVal.split(",");
        int[] numbers = new int[numStr.length];

        for (int i = 0; i < numStr.length; i++) {
            numbers[i] = Integer.parseInt(numStr[i]);
        }
        return numbers;
    }

    /**
     * This method converts int[] into List<Integer>
     *
     * 1. In Java 8+ we can make a stream of int array byt calling Arrays.stream or IntStream.of
     * 2. Call IntStream#boxed to use boxing conversion from int primitive type to Integer objects.
     * 3. Collect into a list using Stream.collect(Collectors.toList()). Java 16+, call Stream#toList()
     *
     * @param ints
     * @return a List of Integer
     */
    public static List<Integer> convertToList(int[] ints) {
        return Arrays.stream(ints).boxed().collect(Collectors.toList());
    }

    /**
     * Prompts user to choose from a list of available solutions.
     *
     * @param counter
     * @param solutions
     */
    public static void displaySolutionOptions(int counter, String[] solutions) {
        System.out.println("This algorithm has " + counter + " solution options.\n");
        System.out.println("Choose from: ");
        for (int i = 0; i < counter; i++) {
            System.out.println("Solution " + (i + 1) + ": " + solutions[i]);
        }
        System.out.println("\nChoose a solution: ");
        arrowPrompt();
    }

}
