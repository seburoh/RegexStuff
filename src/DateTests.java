import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateTests {

    /* Positives. */

    @Test
    void basicDate() {
        assertTrue(Main.isDate("12-3-1900"), "Basic failed");
        assertTrue(Main.isDate("1-3-1900"), "Basic failed");
    }

    @Test
    void basicLines() {
        assertTrue(Main.isDate("12/3/1900"), "Basic failed");
        assertTrue(Main.isDate("1/3/1900"), "Basic failed");
    }

    @Test
    void leadingZeroes() {
        assertTrue(Main.isDate("02-03-1900"), "Zeroes failed");
        assertTrue(Main.isDate("2-3-1900"), "Zeroes failed");
        assertTrue(Main.isDate("02-3-1900"), "Zeroes failed");
        assertTrue(Main.isDate("2-03-1900"), "Zeroes failed");
    }

    @Test
    void basicYear() {
        assertTrue(Main.isDate("12-3-0"), "Year failed");
        assertTrue(Main.isDate("1-3-1"), "Year failed");
        assertTrue(Main.isDate("1-3-99999999"), "Year failed");
        assertTrue(Main.isDate("1-3-2001"), "Year failed");
    }

    @Test
    void borderDaysGood() {
        assertTrue(Main.isDate("1-31-2023"), "Last day failed");
        assertTrue(Main.isDate("3-31-2023"), "Last day failed");
        assertTrue(Main.isDate("4-30-2023"), "Last day failed");
        assertTrue(Main.isDate("5-31-2023"), "Last day failed");
        assertTrue(Main.isDate("6-30-2023"), "Last day failed");
        assertTrue(Main.isDate("7-31-2023"), "Last day failed");
        assertTrue(Main.isDate("8-31-2023"), "Last day failed");
        assertTrue(Main.isDate("9-30-2023"), "Last day failed");
        assertTrue(Main.isDate("10-31-2023"), "Last day failed");
        assertTrue(Main.isDate("11-30-2023"), "Last day failed");
        assertTrue(Main.isDate("12-31-2023"), "Last day failed");
    }

    @Test
    void leapYear() {
        assertTrue(Main.isDate("2-28-1999"), "Leap year failed");
        assertTrue(Main.isDate("2-29-2000"), "Leap year failed");
        assertTrue(Main.isDate("2-28-2100"), "Leap year failed");
        assertTrue(Main.isDate("2-29-4"), "Leap year failed");
        assertTrue(Main.isDate("2-29-9368"), "Leap year failed");
    }

    /* Negatives. */

    @Test
    void leapYearBad() {
        assertFalse(Main.isDate("2-29-1999"), "Leap year bad failed");
        assertFalse(Main.isDate("2-29-2100"), "Leap year bad failed");
    }

    @Test
    void borderDaysBad() {
        assertFalse(Main.isDate("1-32-2023"), "Last day bad failed");
        assertFalse(Main.isDate("3-32-2023"), "Last day bad failed");
        assertFalse(Main.isDate("4-31-2023"), "Last day bad failed");
        assertFalse(Main.isDate("5-32-2023"), "Last day bad failed");
        assertFalse(Main.isDate("6-31-2023"), "Last day bad failed");
        assertFalse(Main.isDate("7-32-2023"), "Last day bad failed");
        assertFalse(Main.isDate("8-32-2023"), "Last day bad failed");
        assertFalse(Main.isDate("9-31-2023"), "Last day bad failed");
        assertFalse(Main.isDate("10-32-2023"), "Last day bad failed");
        assertFalse(Main.isDate("11-31-2023"), "Last day bad failed");
        assertFalse(Main.isDate("12-32-2023"), "Last day bad failed");
    }

    @Test
    void onlyZeroes() {
        assertFalse(Main.isDate("0-20-1999"), "Zeroes bad failed");
        assertFalse(Main.isDate("01-0-1999"), "Zeroes bad failed");
        assertFalse(Main.isDate("0-0-1999"), "Zeroes bad failed");
    }

    @Test
    void manyDashes() {
        assertFalse(Main.isDate("1--20-1999"), "Many dashes failed");
        assertFalse(Main.isDate("1-1--1999"), "Many dashes failed");
        assertFalse(Main.isDate("1--1--1999"), "Many dashes failed");
    }

    @Test
    void manyLines() {
        assertFalse(Main.isDate("1//20-1999"), "Many lines failed");
        assertFalse(Main.isDate("1-1//1999"), "Many lines failed");
        assertFalse(Main.isDate("1//1//1999"), "Many lines failed");
    }

    @Test
    void manyMixed() {
        assertFalse(Main.isDate("1/-20-1999"), "Many lines failed");
        assertFalse(Main.isDate("1-1-/1999"), "Many lines failed");
        assertFalse(Main.isDate("1/-1-/1999"), "Many lines failed");
    }

    @Test
    void startEnd() {
        assertFalse(Main.isDate(" 1-20-1999"), "Preceding failed");
        assertFalse(Main.isDate("1-1-1999 "), "Postceding failed");
        assertFalse(Main.isDate(" 1-1-1999 "), "Bothceding failed");
    }

    @Test
    void empty() {
        assertFalse(Main.isDate(""), "Empty failed");
    }

    @Test
    void realBad() {
        assertFalse(Main.isDate("666"), "cursed failed");
        assertFalse(Main.isDate("hellofresh for all of your food needs"), "yeah idk");
    }

}