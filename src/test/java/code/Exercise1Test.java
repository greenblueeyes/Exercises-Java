package code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import code.Exercise1;

public class Exercise1Test {

    private final Exercise1 exercise = new Exercise1();

    @Test
    void testFindIndicies() {
      List<Integer> result = exercise.findIndices(50);

      assertNotNull(result);
      assertFalse(result.isEmpty());
      assertEquals(2, result.size());
      assertTrue(result.contains(3));
      assertTrue(result.contains(5));
    }

    @Test
    void testFindIndices_noMatch() {
        List<Integer> result = exercise.findIndices(5);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
