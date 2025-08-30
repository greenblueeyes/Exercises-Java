package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise1 {
    private List<Integer> values = Arrays.asList(1, 15, 20, 25, 30, 48);

    public List<Integer> findIndices(int targetSum) {
        int idxLeft = 0;
        int idxRight = values.size() - 1;

        int sum = values.get(idxLeft) + values.get(idxRight);

        while (idxLeft != idxRight) {
            
          if (sum == targetSum) {
            return Arrays.asList(idxLeft, idxRight);
          } else if (sum > targetSum) {
            idxRight--;
          } else if (sum > targetSum) {
            idxLeft++;
          }
        }  

        return Collections.emptyList();  
    } 
}
