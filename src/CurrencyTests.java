import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CurrencyTests {

    /* Positives. */

    @Test
    void basicCurrency() {
        assertTrue(Main.isCurrency("$4.50"));
    }

    @Test
    void basicLargeCurrency() {
        assertTrue(Main.isCurrency("$123,456,789.23"));
    }

    @Test
    void noDollars() {
        assertTrue(Main.isCurrency("$.23"));
        assertTrue(Main.isCurrency("$0.23"));
        assertTrue(Main.isCurrency("$.03"));
    }

    @Test
    void flatBroke() {
        assertTrue(Main.isCurrency("$.00"));
        assertTrue(Main.isCurrency("$0.00"));
        assertTrue(Main.isCurrency("$0,000.00"));
    }

    @Test
    void middlingMoney() {
        assertTrue(Main.isCurrency("$79.23"));
        assertTrue(Main.isCurrency("$1.23"));
        assertTrue(Main.isCurrency("$1,710.03"));
    }

    @Test
    void largeMoney() {
        assertTrue(Main.isCurrency("$123,456,789.23"));
        assertTrue(Main.isCurrency("$123,456,123,456,123,456,123,456,789.23"));
        assertTrue(Main.isCurrency("$13,456,789.23"));
        assertTrue(Main.isCurrency("$1,456,789.23"));
    }

    /* Negatives. */

    @Test
    void noChange() {
        assertFalse(Main.isCurrency("$4.0"));
        assertFalse(Main.isCurrency("$4."));
        assertFalse(Main.isCurrency("$4.5"));
    }

    @Test
    void malformedTriplets() {
        assertFalse(Main.isCurrency("$400,0.00"));
        assertFalse(Main.isCurrency("$4,0.00"));
        assertFalse(Main.isCurrency("$4,000,0.50"));
        assertFalse(Main.isCurrency("$4,0,000.50"));
    }

    @Test
    void badFormat() {
        assertFalse(Main.isCurrency("4.00"));
        assertFalse(Main.isCurrency("$400"));
        assertFalse(Main.isCurrency("450"));
    }

    @Test
    void empty() {
        assertFalse(Main.isCurrency(""));
        assertFalse(Main.isCurrency("$"));
        assertFalse(Main.isCurrency("$."));
    }

    @Test
    void realBad() {
        assertFalse(Main.isCurrency("$4"));
        assertFalse(Main.isCurrency("league of legends feels pretty overrated in the current market"));
    }

}