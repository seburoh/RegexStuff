import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordTests {

    /* Positives. */

    @Test
    void basicPassword() {
        assertTrue(Main.isPassword("Password1!"));
    }

    @Test
    void startWithStuff() {
        assertTrue(Main.isPassword("1!Password"));
    }

    @Test
    void middleStuff() {
        assertTrue(Main.isPassword("passW1!ord"));
    }

    @Test
    void spreadStuff() {
        assertTrue(Main.isPassword("paSsw1or!d"));
    }

    @Test
    void longPassword() {
        assertTrue(Main.isPassword("3hG95Z5TUVgpFgArMNKPY94AhEpc5PcKNiHJ7s!n6HnBCTxkhUfBGTyEcwVysuTnznyLzPsQ" +
                "YbLHyRTkF6DmQRGv5SfzWqDo9EgaTcD67jFwNfGyyreFw2RBQb8ouF9QP"));
        assertTrue(Main.isPassword("hwf975fNysN958xtLEEuT!!tZn5wXDFseLTi6mrQ4ckhTMwdKPK!v97qf264FxnwD9fcMKK6DER" +
                "K4CAKyfRsi5vkfnjWurqPhpVb76hP!mMLZcSpN8Zcbtyz3NsvqhUW4P4L"));
    }

    /* Negatives. */

    @Test
    void smol() {
        assertFalse(Main.isPassword("p1C!"));
    }

    @Test
    void noCap() {
        assertFalse(Main.isPassword("password1!"));
    }

    @Test
    void noNum() {
        assertFalse(Main.isPassword("password!C"));
    }

    @Test
    void noPunc() {
        assertFalse(Main.isPassword("PasswordC"));
    }

    @Test
    void startEnd() {
        assertFalse(Main.isPassword(" PasswordC!"));
        assertFalse(Main.isPassword(" PasswordC! "));
        assertFalse(Main.isPassword("PasswordC! "));
    }

    @Test
    void empty() {
        assertFalse(Main.isPassword(""));
    }

    @Test
    void realBad() {
        assertFalse(Main.isPassword("in theory this might actually be not bad if it's gibberish?"));
    }
}