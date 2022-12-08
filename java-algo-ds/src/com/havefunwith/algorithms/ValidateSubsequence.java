package com.havefunwith.algorithms;

import java.util.List;

public class ValidateSubsequence {

    // for-loop solution
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

}
