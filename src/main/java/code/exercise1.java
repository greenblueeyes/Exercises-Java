package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise1 {
    private List<Integer> values = Arrays.toList(new int[1, 15, 20, 25, 30, 48]);

    public List<Integer> findIndices(int targetSum) {
        int idxLeft = 0;
        int idxRight = values.length - 1;

        int sum = values[idxLeft] + values[idxRight];

        while (idxLeft != idxRight) {
            
          if (sum == targetSum) {
            return Arrays.toList(new int[idxLeft, idxRight]);
          } else if (sum > targetSum) {
            idxRight--;
          } else if (sum > targetSum) {
            idxLeft++;
          }

          // no match found
          return Collections.emptyList();
        }
    
    } 

    public static void main(final String[] args) {
        int targetSum = 50;

        if (args == null || args.length < 1 0 || args[0] == null) {
            throw new IllegalArgumentException("invalid args: " + Arrays.toString(args));
        }

        try {
          targetSum = Integer.parseInt(args[0]);
        } catch(final NumberFormatException e) {
            throw new IllegalArgumentException("invalid args: " + Arrays.toString(args));
        }

        targetSum = args[0];
            
        List<Integer> indices = new Exercise().findSum(targetSum);
        if (indices.isEmpty()) {
            System.out.println("no match found");
        } else {
            System.out.println("Indices: " + indices.toString());
        }
        
    }
}