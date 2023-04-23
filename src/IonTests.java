import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class IonTests {

    /* Positives. */

    @Test
    void basicIon() {
        assertTrue(Main.isOddIon("ion"));
    }

    @Test
    void repeated() {
        assertTrue(Main.isOddIon("ionionion"));
    }

    @Test
    void differentLetters() {
        assertTrue(Main.isOddIon("wheeion"));
    }

    @Test
    void mixedCase() {
        assertTrue(Main.isOddIon("iOn"));
        assertTrue(Main.isOddIon("ION"));
        assertTrue(Main.isOddIon("IONIoniOn"));
    }

    @Test
    void large() {
        StringBuilder strb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 500; i++) {
            strb.append((char)rand.nextInt(97,123));
            strb.append((char)rand.nextInt(97,123));
            assertTrue(Main.isOddIon(strb.toString()+"ion"));
        }
    }

    /* Negatives. */

    @Test
    void basicBadIon() {
        assertFalse(Main.isOddIon("iion"));
    }

    @Test
    void repeatedBad() {
        assertFalse(Main.isOddIon("ionion"));
        assertFalse(Main.isOddIon("ionionionion"));
    }

    @Test
    void badEnd() {
        assertFalse(Main.isOddIon("io"));
        assertFalse(Main.isOddIon("in"));
        assertFalse(Main.isOddIon("ion "));
        assertFalse(Main.isOddIon("on"));
    }

    @Test
    void noRepeatBad() {
        assertFalse(Main.isOddIon("bahion"));
    }

    @Test
    void badLarge() {
        StringBuilder strb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 500; i++) {
            strb.append((char)rand.nextInt(97,123));
            strb.append((char)rand.nextInt(97,123));
            strb.append(strb.length() % 2 == 0 ? (char)rand.nextInt(97,123) : "");
            assertFalse(Main.isOddIon(strb.toString()+"ion"));
        }
    }

    @Test
    void empty() {
        assertFalse(Main.isOddIon(""));
    }

    @Test
    void realBad() {
        assertFalse(Main.isOddIon("somehow this was like the easiest one?"));
    }
}