package code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercise6Test {

    @Test
    void testSolve_threeRows() {
        Exercise6 ex6 = new Exercise6();
        String result = ex6.solve("STRIPEISHIRING", 3);

        Assertions.assertEquals("SPHNTIESIIGRIR", result);
    }

    @Test
    void testSolve_fourRows() {
        Exercise6 ex6 = new Exercise6();
        String result = ex6.solve("STRIPEISHIRING", 4);

        Assertions.assertEquals("SINTESIGRPHRII", result);
    }
}
