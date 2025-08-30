package code;

import java.util.Arrays;
import java.util.List;

import code.Exercise1;

public class Exercise1Main {

        public static void main(final String[] args) {
        int targetSum = 50;

        if (args == null || args.length < 1 || args[0] == null) {
            throw new IllegalArgumentException("invalid args: " + Arrays.toString(args));
        }

        try {
          targetSum = Integer.parseInt(args[0]);
        } catch(final NumberFormatException e) {
            throw new IllegalArgumentException("invalid args: " + Arrays.toString(args));
        }
            
        List<Integer> indices = new Exercise1().findIndices(targetSum);
        if (indices.isEmpty()) {
            System.out.println("no match found");
        } else {
            System.out.println("Indices: " + indices.toString());
        }
    }
}
