package code;

import java.util.Arrays;
import java.util.List;

public class Exercise4 {
    /**
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     *
     * The overall run time complexity should be O(log (m+n)).
     *
     *
     *
     * Example 1:
     *
     * Input: nums1 = [1,3], nums2 = [2]
     * Output: 2.00000
     * Explanation: merged array = [1,2,3] and median is 2.
     * Example 2:
     *
     * Input: nums1 = [1,2], nums2 = [3,4]
     * Output: 2.50000
     * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
     */

    public Float run(final List<Integer> left, final List<Integer> right) {
        BinaryTree<Integer> bt = new BinaryTree<>(left);

        right.forEach(bt::append);

        List<Integer> singleSortedInputs = bt.toList();
        int size = singleSortedInputs.size();

        if (size == 1) {
            return singleSortedInputs.getFirst().floatValue();
        } else if (size % 2 == 1) {
            int midIdx = Math.floorDiv(size, 2);
            return singleSortedInputs.get(midIdx).floatValue();
        } else {
            int midIdxRight = size / 2;
            int midIdxLeft = midIdxRight - 1;
            System.out.printf(" mid-index-right = %d%n mid-index-left = %d%n", midIdxRight, midIdxLeft);
            System.out.printf(" right-value = %f%n left-value = %f%n", singleSortedInputs.get(midIdxRight).floatValue(), singleSortedInputs.get(midIdxLeft).floatValue());
            return (singleSortedInputs.get(midIdxLeft).floatValue() + singleSortedInputs.get(midIdxRight).floatValue())/ 2.f;
        }
    }
}
