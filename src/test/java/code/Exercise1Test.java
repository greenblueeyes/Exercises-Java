package code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Exercise1Test {

    private Exercise1 exercise = new Exercise1();

    @Test
    void testFindIndices() {
      List<Integer> result = exercise.findIndices(50);

      assertNotNull(result);
      assertFalse(result.isEmpty());
      assertEquals(2, result.size());
      assertTrue(result.contains(2));
      assertTrue(result.contains(4));
    }

    @Test
    void testFindIndices_test1() {
        exercise = new Exercise1(Exercise1.SearchArrays.TEST1);

        List<Integer> result = exercise.findIndices(9);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
    }

    @Test
    void testFindIndices_test2() {
        exercise = new Exercise1(Exercise1.SearchArrays.TEST2);

        List<Integer> result = exercise.findIndices(6);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
    }

    @Test
    void testFindIndices_test3() {
        exercise = new Exercise1(Exercise1.SearchArrays.TEST3);

        List<Integer> result = exercise.findIndices(6);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
    }


    @Test
    void testFindIndices_noMatch() {
        List<Integer> result = exercise.findIndices(5);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
