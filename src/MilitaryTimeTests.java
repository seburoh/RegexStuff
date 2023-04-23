import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MilitaryTimeTests {

    /* Positives. */

    @Test
    void basicDate() {
        assertTrue(Main.isMilitaryTime("23:04"));
    }

    @Test
    void zeroes() {
        assertTrue(Main.isMilitaryTime("00:00"));
        assertTrue(Main.isMilitaryTime("12:00"));
        assertTrue(Main.isMilitaryTime("00:12"));
    }

    @Test
    void fiftyNines() {
        assertTrue(Main.isMilitaryTime("23:59"));
        assertTrue(Main.isMilitaryTime("00:59"));
        assertTrue(Main.isMilitaryTime("12:59"));
    }

    @Test
    void hourZeroDigits() {
        for (int i = 0; i < 10; i++) {
            assertTrue(Main.isMilitaryTime("0" + i + ":04"));
        }
    }

    @Test
    void hourOneDigits() {
        for (int i = 0; i < 10; i++) {
            assertTrue(Main.isMilitaryTime("1" + i + ":04"));
        }
    }

    @Test
    void hourTwoDigits() {
        for (int i = 0; i < 4; i++) {
            assertTrue(Main.isMilitaryTime("2" + i + ":04"));
        }
    }

    @Test
    void allTheTimes() {
        String hour;
        String minute;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                hour = i < 10 ? "0" + i : String.valueOf(i);
                minute = j < 10 ? "0" + j : String.valueOf(j);

                assertTrue(Main.isMilitaryTime(hour + ":" + minute), "Time failed: " + i + ":" + j);
            }
        }
    }

    /* Negatives. */

    @Test
    void lessDigits() {
        assertFalse(Main.isMilitaryTime("0:00"));
        assertFalse(Main.isMilitaryTime("0:0"));
        assertFalse(Main.isMilitaryTime("00:0"));
        assertFalse(Main.isMilitaryTime("1:11"));
        assertFalse(Main.isMilitaryTime("1:1"));
        assertFalse(Main.isMilitaryTime("11:1"));
    }

    @Test
    void highHour() {
        assertFalse(Main.isMilitaryTime("30:00"));
        assertFalse(Main.isMilitaryTime("24:00"));
    }

    @Test
    void highMinute() {
        assertFalse(Main.isMilitaryTime("10:60"));
        assertFalse(Main.isMilitaryTime("10:70"));
        assertFalse(Main.isMilitaryTime("10:99"));
    }

    @Test
    void startEnd() {
        assertFalse(Main.isMilitaryTime(" 10:30"));
        assertFalse(Main.isMilitaryTime("10:30 "));
        assertFalse(Main.isMilitaryTime(" 10:30 "));
    }

    @Test
    void empty() {
        assertFalse(Main.isMilitaryTime(":"));
        assertFalse(Main.isMilitaryTime(":0"));
        assertFalse(Main.isMilitaryTime("0:"));
    }

    @Test
    void realBad() {
        assertFalse(Main.isMilitaryTime("00"));
        assertFalse(Main.isMilitaryTime("if i fought william osman in his egg drop challenge i would lose"));
    }
}