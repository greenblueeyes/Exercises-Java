package code;

import org.junit.jupiter.api.Test;

import code.Exercise1;

public class Exercise1Test {

    final Exercise1 exercise = new Exercise1();

    @Test
    void testFindIndicies() {
      List<Integer> result = exercise.findIndices(50);

      assertNotNull(result);
      assertFalse(result.isEmpty());
      assertEquals(2, result.length());
      assertTrue(result.contains(3))
      assertTrue(result.contains(5));
    }

    @Test
    public testFindIndices_noMatch() {
        List<Integer> result = exercise.findIndices(5);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}