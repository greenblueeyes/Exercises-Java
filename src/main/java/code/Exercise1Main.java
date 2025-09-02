package code;

import java.util.Arrays;
import java.util.List;

import code.Exercise1;

public class Exercise1Main {

        public static void main(final String[] args) {
        int targetSum = 50;
        Exercise1.SearchArrays  arrayOption = null;

        if (args == null || args.length < 1 || args[0] == null) {
            throw new IllegalArgumentException("invalid args: " + Arrays.toString(args));
        }

        if (args.length > 1 && args[1] != null) {
            arrayOption = Exercise1.SearchArrays.findByName(args[1]);
        }

        try {
            targetSum = Integer.parseInt(args[0]);
        } catch(final NumberFormatException e) {
            throw new IllegalArgumentException("invalid args: " + Arrays.toString(args));
        }

        Exercise1 exercise;
        if (arrayOption != null) {
            exercise = new Exercise1(arrayOption);
        } else {
            exercise = new Exercise1();
        }
        final List<Integer> indices = exercise.findIndices(targetSum);
        if (indices.isEmpty()) {
            System.out.println(" > no match found");
        } else {
            System.out.println(" > Indices: " + indices.toString());
        }
        
    }

}
