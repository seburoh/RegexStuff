import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PhoneTests {

    /* Positives. */

    /*
    970-867-5309 is not the number of Jenny, but a pizzeria called Totally 80's Pizza in Fort Collins Colorado.
    */

    @Test
    void testFullNumber() {
        assertTrue(Main.isPhoneNumber("(970)-867-5309"), "Full failed");
    }

    @Test
    void serviceCodes() {
        assertTrue(Main.isPhoneNumber("911"), "911 failed");
        assertTrue(Main.isPhoneNumber("211"), "211 failed");
    }

    @Test
    void testFullNumberCountry() {
        assertTrue(Main.isPhoneNumber("1-(970)-867-5309"), "Full Country failed");
        assertTrue(Main.isPhoneNumber("1(970)-867-5309"), "Full Country failed");
    }

    @Test
    void testLessParens() {
        assertTrue(Main.isPhoneNumber("970-867-5309"), "No parens failed");
        assertTrue(Main.isPhoneNumber("(970-867-5309"), "Right parens failed");
        assertTrue(Main.isPhoneNumber("970)-867-5309"), "Left parens failed");
    }

    @Test
    void testParensCountry() {
        assertTrue(Main.isPhoneNumber("1-970)-867-5309"), "Parens with dash Country failed");
        assertTrue(Main.isPhoneNumber("1970)-867-5309"), "Parens no dash Country failed");
    }

    @Test
    void testLessDashesNoParens() {
        assertTrue(Main.isPhoneNumber("970867-5309"), "Left dash failed");
        assertTrue(Main.isPhoneNumber("970-8675309"), "Right dash failed");
        assertTrue(Main.isPhoneNumber("9708675309"), "No dashes failed");
    }

    @Test
    void testLessDashesNoParensCountry() {
        assertTrue(Main.isPhoneNumber("1-970-867-5309"), "No Parens with dash Country failed");
        assertTrue(Main.isPhoneNumber("1970-867-5309"), "No Parens no first dash Country failed");
        assertTrue(Main.isPhoneNumber("19708675309"), "No Parens no dashes Country failed");
    }

    @Test
    void testLessDashesYesParens() {
        assertTrue(Main.isPhoneNumber("(970)867-5309"), "Left dash failed");
        assertTrue(Main.isPhoneNumber("(970)8675309"), "No dashes failed");
        assertTrue(Main.isPhoneNumber("(970)-8675309"), "Right dash failed");
    }

    @Test
    void testLessMixed() {
        assertTrue(Main.isPhoneNumber("(970-867-5309"), "Right parens failed");
        assertTrue(Main.isPhoneNumber("970)-867-5309"), "Left parens failed");
        assertTrue(Main.isPhoneNumber("(970867-5309"), "Right parens left dash failed");
        assertTrue(Main.isPhoneNumber("970)8675309"), "Left parens no dashes failed");
        assertTrue(Main.isPhoneNumber("(9708675309"), "Right parens no dashes failed");
    }

    /* Negatives. */

    @Test
    void badService() {
        assertFalse(Main.isPhoneNumber("111"), "111 service failed");
        assertFalse(Main.isPhoneNumber("912"), "912 service failed");
        assertFalse(Main.isPhoneNumber("011"), "011 service failed");
        assertFalse(Main.isPhoneNumber("000"), "000 service failed");
    }

    @Test
    void leadingChars() {
        assertFalse(Main.isPhoneNumber(" (970)-867-5309"), "Leading failed");
    }

    @Test
    void followingChars() {
        assertFalse(Main.isPhoneNumber("(970)-867-5309 "), "Following failed");
    }

    @Test
    void leadingFollowingChars() {
        assertFalse(Main.isPhoneNumber(" (970)-867-5309 "), "Leading+Following failed");
    }

    @Test
    void tooManyNumbers() {
        assertFalse(Main.isPhoneNumber("(9701)-867-5309"), "Too many area group failed");
        assertFalse(Main.isPhoneNumber("(970)-8672-5309"), "Too many middle group failed");
        assertFalse(Main.isPhoneNumber("(970)-867-53093"), "Too many last group failed");
        assertFalse(Main.isPhoneNumber("(9701)-8672-53093"), "Too many all groups failed");
    }

    @Test
    void notEnoughNumbers() {
        assertFalse(Main.isPhoneNumber("(11)-867-5309"), "Too many area group failed");
        assertFalse(Main.isPhoneNumber("(970)-22-5309"), "Too many middle group failed");
        assertFalse(Main.isPhoneNumber("(970)-867-333"), "Too many last group failed");
        assertFalse(Main.isPhoneNumber("(11)-22-333"), "Too many all groups failed");
    }

    @Test
    void testEmpty() {
        assertFalse(Main.isPhoneNumber(""),"empty failed");
        assertFalse(Main.isPhoneNumber("970"),"one chunk failed");
        assertFalse(Main.isPhoneNumber("have you heard of raid shadow legends?"),"yeah real bad idk");
    }

}