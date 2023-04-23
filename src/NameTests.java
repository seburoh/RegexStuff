import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NameTests {

    /*
    MI's used are "Secure Coding"
     */

    /* Positives. */

    @Test
    void basicName() {
        assertTrue(Main.isName("Capaul, Tom"), "Basic failed");
    }

    @Test
    void basicMI() {
        assertTrue(Main.isName("Capaul, Tom, S"), "Basic failed");
    }

    @Test
    void complexMI() {
        assertTrue(Main.isName("Capaul, Tom, SC"), "Basic failed");
    }

    @Test
    void complexMIDashes() {
        assertTrue(Main.isName("Capaul, Tom, S-C"), "Basic failed");
    }

    @Test
    void complexFN() {
        assertTrue(Main.isName("Capaul, To-m"), "Basic failed");
    }

    @Test
    void complexLN() {
        assertTrue(Main.isName("Ca-paul, Tom"), "Basic failed");
    }

    @Test
    void complexMix() {
        assertTrue(Main.isName("Ca-paul, To-m"), "Basic failed");
    }

    @Test
    void separatorsNoMI() {
        assertTrue(Main.isName("Capaul, Tom"), "Basic failed");
        assertTrue(Main.isName("Capaul,Tom"), "Basic failed");
        assertTrue(Main.isName("Capaul Tom"), "Basic failed");
    }

    @Test
    void separatorsWithMI() {
        assertTrue(Main.isName("Capaul, Tom,S"), "Basic failed");
        assertTrue(Main.isName("Capaul, Tom S"), "Basic failed");
        assertTrue(Main.isName("Capaul, Tom, S"), "Basic failed");
    }

    @Test
    void smol() {
        assertTrue(Main.isName("C, T,S"), "Basic failed");
        assertTrue(Main.isName("C,T S"), "Basic failed");
        assertTrue(Main.isName("C T, S"), "Basic failed");
    }

    @Test
    void middleInitialLengthSeps() {
        assertTrue(Main.isName("Capaul, Tom, S-C-o."), "Basic failed");
        assertTrue(Main.isName("Capaul, Tom, SC-o"), "Basic failed");
        assertTrue(Main.isName("Capaul, Tom, S-C-o"), "Basic failed");
    }

    @Test
    void middleInitialLengthNoSeps() {
        assertTrue(Main.isName("Capaul, Tom, SCo."), "Basic failed");
        assertTrue(Main.isName("Capaul, Tom, SCo"), "Basic failed");
    }

    @Test
    void goodMIPeriod() {
        assertTrue(Main.isName("Capaul, Tom, S."), "Basic failed");
        assertTrue(Main.isName("Capaul, Tom, S.C."), "Basic failed");
        assertTrue(Main.isName("Capaul, Tom, S-C."), "Basic failed");
    }

    /* Negatives. */

    @Test
    void badMILengthSeps() {
        assertFalse(Main.isName("Capaul, Tom, SCod."), "Basic failed");
        assertFalse(Main.isName("Capaul, Tom, SCo-d"), "Basic failed");
        assertFalse(Main.isName("Capaul, Tom, S-C-od."), "Basic failed");
    }

    @Test
    void badMILengthNoSeps() {
        assertFalse(Main.isName("Capaul, Tom, SCod"), "Basic failed");
        assertFalse(Main.isName("Capaul, Tom, SCodi"), "Basic failed");
        assertFalse(Main.isName("Capaul, Tom, SCoding"), "Basic failed");
    }

    @Test
    void badPeriod() {
        assertFalse(Main.isName("Capaul, Tom."), "Basic failed");
        assertFalse(Main.isName("Capaul, T."), "Basic failed");
    }

    @Test
    void badChars() {
        assertFalse(Main.isName("Cap9aul, Tom"), "Basic failed");
        assertFalse(Main.isName("Capaul, T9om"), "Basic failed");
        assertFalse(Main.isName("Capaul, Tom, 9"), "Basic failed");
    }

    @Test
    void startDash() {
        assertFalse(Main.isName("-Capaul, Tom"), "Basic failed");
        assertFalse(Main.isName("Capaul, -Tom"), "Basic failed");
        assertFalse(Main.isName("Capaul, Tom, -S"), "Basic failed");
    }

    @Test
    void endDash() {
        assertFalse(Main.isName("Capaul-, Tom"), "Basic failed");
        assertFalse(Main.isName("Capaul, Tom-"), "Basic failed");
        assertFalse(Main.isName("Capaul, Tom, S-"), "Basic failed");
    }

    @Test
    void leadingSpaces() {
        assertFalse(Main.isName(" Capaul, Tom"), "Basic failed");
    }

    @Test
    void trailingSpaces() {
        assertFalse(Main.isName("Capaul, Tom "), "Basic failed");
    }

    @Test
    void empty() {
        assertFalse(Main.isName(""), "Basic failed");
    }

    @Test
    void realBad() {
        assertFalse(Main.isName("999"), "Basic failed");
        assertFalse(Main.isName("have you tried NordVPN with this wonderful LCS"), "Basic failed");
    }

}
