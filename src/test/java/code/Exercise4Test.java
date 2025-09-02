package code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Exercise4Test {

    private final Exercise4 ex4 = new Exercise4();

    @Test
    void testRun_case_1() {
       float result = ex4.run(
            Arrays.asList(new Integer[] {1,3}),
            Arrays.asList(new Integer[] {2})
        );
        Assertions.assertEquals(2f, result);
    }

    @Test
    void testRun_case_2() {
        float result = ex4.run(
                Arrays.asList(new Integer[] {1,2}),
                Arrays.asList(new Integer[] {3,4})
        );
        Assertions.assertEquals(2.5f, result);
    }
}
