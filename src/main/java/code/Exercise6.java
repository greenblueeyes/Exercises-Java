package code;

import java.util.Arrays;
import java.util.function.Consumer;

public class Exercise6 {
    // https://leetcode.com/problems/zigzag-conversion
    //
    // The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
    //
    // P   A   H   N
    // A P L S I I G
    // Y   I   R
    // And then read line by line: "PAHNAPLSIIGYIR"
    //
    // Write the code that will take a string and make this conversion given a number of rows:
    //
    // string convert(string s, int numRows);
    //
    // Example 1:
    //
    // Input: s = "PAYPALISHIRING", numRows = 3
    // Output: "PAHNAPLSIIGYIR"
    // Example 2:
    //
    // Input: s = "PAYPALISHIRING", numRows = 4
    // Output: "PINALSIGYAHRPI"
    // Explanation:
    // P     I    N
    // A   L S  I G
    // Y A   H R
    // P     I
    // Example 3:
    //
    // Input: s = "A", numRows = 1
    // Output: "A"
    //
    // Constraints:
    //
    // 1 <= s.length <= 1000
    // s consists of English letters (lower-case and upper-case), ',' and '.'.
    // 1 <= numRows <= 1000
    //

    public String solve(final String inputStr, final int totalRows) {
        if (totalRows <= 1 || totalRows > 1000|| inputStr == null || inputStr.isEmpty()) {
            throw new IllegalArgumentException("null or empty string or 0 rows specified");
        }

        int cols = Math.floorDiv(inputStr.length(), 2);
        char[][] grid = new char[totalRows][cols];

        // initialize
        Arrays.stream(grid).forEach(col -> Arrays.fill(col, ' '));

        // fill
        staggerFillWithText(grid, inputStr);

        // extract characters
        StringBuilder bldr = new StringBuilder();
        navigate(grid, bldr::append);
        return bldr.toString();
    }

    void staggerFillWithText(char[][] grid, final String inputStr) {
        int rows = grid.length;
        int cols = grid[0].length;

        int currCol = 0;
        int currRow = 0;
        int idxStr = 0;

        while (currCol < cols && idxStr < inputStr.length()) {
            // distribute characters in column, each row straight down
            while (currRow < rows && idxStr < inputStr.length()) {
                grid[currRow][currCol] = inputStr.charAt(idxStr);
                idxStr++;
                currRow++;
            }

            // after last row, distribute characters in diagonal back up
            currRow = rows - 2;
            currCol++;
            while (currRow > 0 && currCol < cols && idxStr < inputStr.length()) {
                grid[currRow][currCol] = inputStr.charAt(idxStr);
                idxStr++;
                currRow--;
                currCol++;
            }
        }
        print(grid);
    }

    void navigate(final char[][] grid, final Consumer<Character> consumer) {
        for (char[] row: grid){
            for (char ch: row) {
                if (ch != ' ') {
                    consumer.accept(ch);
                }
            }
        }
    }

    void print(final char[][] grid) {
        for (char[] row: grid){
            System.out.print(" > ");
            for (char ch: row) {
                System.out.printf(" %c", ch);
            }
            System.out.println();
        }
    }
}
