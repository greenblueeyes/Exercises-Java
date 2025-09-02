package code;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Search an array of integers for to indices that add up to a specific value.
 * Try to solve in less than O(n^2)
 */
public class Exercise1 {
    public static enum SearchArrays {
      TEST (new int[] {1, 15, 20, 25, 30, 48}), //50
      TEST1(new int[] {2, 7, 11, 15}), //9
      TEST2(new int[] {3, 2, 4}), //6
      TEST3(new int[] {3, 3}); //6

      List<Integer> searchArray = Collections.emptyList();

      SearchArrays(final int[] valArray) {
        searchArray = Arrays.stream(valArray).boxed().sorted().toList();
      }

      public static SearchArrays findByName(String name) {
        final List<SearchArrays> matches = Arrays.stream(values()).filter(enumItem -> enumItem.name().equalsIgnoreCase(name)).toList();

        return matches.isEmpty()? null: matches.getFirst();
      }
    }

    private final List<Integer> values;

    public Exercise1() {
       values = SearchArrays.TEST.searchArray;
    }

    public Exercise1(SearchArrays option) {
        values = option.searchArray;
    }

    public List<Integer> findIndices(int targetSum) {
        int idxLeft = 0;
        int idxRight = values.size() - 1;

        int sum = values.get(idxLeft) + values.get(idxRight);

        while (idxLeft != idxRight) {
            if (sum == targetSum) {
                return Arrays.asList(idxLeft, idxRight);
            } else if (sum < targetSum) {
                idxLeft++;
            } else { // (sum < targetSum)
                idxRight--;
            }
            sum = values.get(idxLeft) + values.get(idxRight);
        }  

        return Collections.emptyList();  
    } 
}