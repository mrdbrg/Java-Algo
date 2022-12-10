package com.havefunwith.helpers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Helper {

    /**
     * Prompts user to choose from a list of algorithms.
     *
     * @return user algorithm's choice
     */
    public static int promptUser(String options) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(options);
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
        String[] strNum = strVal.split(",");
        int[] array = new int[strNum.length];

        for (int i = 0; i < strNum.length; i++) {
            array[i] = Integer.parseInt(strNum[i]);
        }
        return array;
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

    /**
     * Returns the banner to describe the chosen solution.
     *
     * @param banner
     */
    public static void solutionBanner(String banner) {
        System.out.println("===========================");
        System.out.println("    " + banner);
        System.out.println("===========================");
    }

    /**
     * Displays exception message and invokes {@link #correctInput(String, String)}
     *
     * @param exception
     * @param data
     * @param hint
     */
    public static void throwException(Exception exception, String[] data, String[] hint) {
        System.out.println("\nEXCEPTION :: Error " + exception.getMessage() + "\n\n" +
                "Try again with correct input example below: \n" +
                correctInput(data, hint));
    }

    /**
     * Helps when an exception is thrown to advise user on proper input data .
     *
     * @param correctData
     * @param hint
     * @return
     */
    private static String correctInput(String[] correctData, String[] hint) {
        String output = "";
        for (int i = 0; i < correctData.length; i++) {
            output += "-> " + correctData[i] + "\n";
        }
        output += "******************************************\n";
        for (int i = 0; i < correctData.length; i++) {
            output += "=> " +  hint[i] + "\n";
        }
        return output;
    }

}
