import code.FewestCoinsInAmount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FewestCoinsInAmountTest {

    FewestCoinsInAmount fewCoins = new FewestCoinsInAmount();
    @Test
    void findFewestCoinsForAmount_1_2_5_amount_11() {
        int result = fewCoins.solve(new int[] {1, 2, 5}, 11);
        Assertions.assertEquals(3, result);
    }
}