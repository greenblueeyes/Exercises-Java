package code;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise2 {
    //
    // You are given two non-empty linked lists representing two non-negative integers.
    // The digits are stored in reverse order, and each of their nodes contains a single digit.
    // Add the two numbers and return the sum as a linked list.
    //
    // Example 1:
    // ---------
    // Input: l1 = [2,4,3], l2 = [5,6,4]
    // Output: [7,0,8]
    // Explanation: 342 + 465 = 807.
    //
    // Example 2:
    // --------
    // Input: l1 = [0], l2 = [0]
    // Output: [0]
    // Example 3:
    //
    // Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    // Output: [8,9,9,9,0,0,0,1]
    //
    // Constraints:
    //
    // The number of nodes in each linked list is in the range [1, 100].
    // 0 <= Node.val <= 9
    // It is guaranteed that the list represents a number that does not have leading zeros.
    //
    private final LinkedList<Integer> addendLeft;
    private final LinkedList<Integer> addendRight;

    public Exercise2(final LinkedList<Integer> left, final LinkedList<Integer> right) {
        if (left == null || right == null) {
            throw new IllegalArgumentException((left == null? "'left'" : "'right'") + " input is missing");
        }
        this.addendLeft = new LinkedList<>();
        this.addendLeft.addAll(left);

        this.addendRight = new LinkedList<>();
        this.addendRight.addAll(right);
    }

    public int getInputSize(final LinkedList<Integer> input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        final AtomicInteger count = new AtomicInteger(0);
        input.forEach(_ -> count.incrementAndGet());

        return count.get();
    }

    public int reverseAndCovertToNumber(final LinkedList<Integer> input) {
        // reverse
        var size = getInputSize(input); // 1
        if (size == 0) {
            return 0;
        }

        // push onto stack to reverse
        var numStack = new ArrayDeque<Integer>(size);
        input.forEach(numStack::push); // 2

        // pop stack elements into string for
        var strBldr = new StringBuilder(input.size());
        numStack.forEach(strBldr::append); // 3

        // convert and return
        return Integer.parseInt(strBldr.toString()); //4
    }

    public Integer sum() {
        var leftValue = reverseAndCovertToNumber(this.addendLeft);
        var rightValue = reverseAndCovertToNumber(this.addendRight);

        System.out.printf(" leftValue = %d%n rightValue = %d%n", leftValue, rightValue);

        return leftValue + rightValue;
    }

    public LinkedList<Integer> run() {
        var result = sum();
        var resultStr = Integer.toString(result); // 5
        var resultDeque = new ArrayDeque<Integer>(resultStr.length());

        resultStr.chars().forEach(chr -> resultDeque.push(chr - 48)); // 6
        return new LinkedList<>(resultDeque);
    }
}
