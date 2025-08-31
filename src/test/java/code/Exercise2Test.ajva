package code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class Exercise2Test {

    @Test
    void testSum_case_1() {
        var ex2 = new Exercise2(
            new LinkedList<Integer>(Arrays.asList(new Integer[] {2,4,3})),
            new LinkedList<Integer>(Arrays.asList(new Integer[] {5,6,4}))
        );

        Assertions.assertEquals(807, ex2.sum());
    }

    @Test
    void testRun_case_1() {
        var ex2 = new Exercise2(
                new LinkedList<Integer>(Arrays.asList(new Integer[] {2,4,3})),
                new LinkedList<Integer>(Arrays.asList(new Integer[] {5,6,4}))
        );

        var result = ex2.run();
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(7, result.get(0));
        Assertions.assertEquals(0, result.get(1));
        Assertions.assertEquals(8, result.get(2));
    }

    @Test
    void testSum_case_2() {
        var ex2 = new Exercise2(
                new LinkedList<Integer>(Arrays.asList(new Integer[] {0})),
                new LinkedList<Integer>(Arrays.asList(new Integer[] {0}))
        );

        Assertions.assertEquals(0, ex2.sum());
    }

    @Test
    void testRun_case_2() {
        var ex2 = new Exercise2(
                new LinkedList<Integer>(Arrays.asList(new Integer[] {0})),
                new LinkedList<Integer>(Arrays.asList(new Integer[] {0}))
        );

        var result = ex2.run();
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(0, result.get(0));
    }

    @Test
    void testSum_case_3() {
        var ex2 = new Exercise2(
                new LinkedList<Integer>(Arrays.asList(new Integer[] {9,9,9,9,9,9,9})),
                new LinkedList<Integer>(Arrays.asList(new Integer[] {9,9,9,9}))
        );

        Assertions.assertEquals(10009998, ex2.sum());
    }

    @Test
    void testRun_case_3() {
        var ex2 = new Exercise2(
                new LinkedList<Integer>(Arrays.asList(new Integer[] {9,9,9,9,9,9,9})),
                new LinkedList<Integer>(Arrays.asList(new Integer[] {9,9,9,9}))
        );

        var result = ex2.run();
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(8, result.get(0));
        Assertions.assertEquals(9, result.get(1));
        Assertions.assertEquals(9, result.get(2));
        Assertions.assertEquals(9, result.get(3));
        Assertions.assertEquals(0, result.get(4));
        Assertions.assertEquals(0, result.get(5));
        Assertions.assertEquals(0, result.get(6));
        Assertions.assertEquals(1, result.get(7));
    }
}
