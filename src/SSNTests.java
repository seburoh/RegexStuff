import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SSNTests {

    /* Positives. */

    @Test
    void testDashes() {
        assertTrue(Main.isSSN("111-22-3333"),"Dashes failed");
    }

    @Test
    void testSpaces() {
        assertTrue(Main.isSSN("111 22 3333"),"Spaces failed");
    }

    @Test
    void testOneSpace() {
        assertTrue(Main.isSSN("11122 3333"),"One Space failed");
        assertTrue(Main.isSSN("111 223333"),"One Space failed");
    }

    @Test
    void testOneDash() {
        assertTrue(Main.isSSN("111-223333"),"One Dash failed");
        assertTrue(Main.isSSN("11122-3333"),"One Dash failed");
    }

    @Test
    void testNoSpaces() {
        assertTrue(Main.isSSN("111223333"),"No Spaces failed");
    }

    /* Negatives. */

    @Test
    void testPreceding() {
        assertFalse(Main.isSSN(" 111-22-3333"),"Preceding failed");
    }

    @Test
    void testFollowing() {
        assertFalse(Main.isSSN("111-22-3333 "),"Following failed");
    }

    @Test
    void testWrongCount() {
        assertFalse(Main.isSSN("11-22-3333"),"First group wrong count failed");
        assertFalse(Main.isSSN("111-2-3333"),"Second group wrong count failed");
        assertFalse(Main.isSSN("111-22-333"),"Third group wrong count failed");

        assertFalse(Main.isSSN("1111-22-3333"),"First group wrong count failed");
        assertFalse(Main.isSSN("111-222-3333"),"Second group wrong count failed");
        assertFalse(Main.isSSN("111-22-33333"),"Third group wrong count failed");
    }

    @Test
    void testAllZeroes() {
        assertFalse(Main.isSSN("000-22-3333"),"000 failed");
        assertFalse(Main.isSSN("111-00-3333"),"00 failed");
        assertFalse(Main.isSSN("111-22-0000"),"0000 failed");
        assertFalse(Main.isSSN("000-00-0000"),"000-00-0000 failed");
    }

    @Test
    void testBadRegion() {
        assertFalse(Main.isSSN("666-22-3333"),"666 failed");
        for (int i = 900; i < 1000; i++) {
            assertFalse(Main.isSSN(i + "-22-3333"),"900-999 failed at: " + i);
        }
    }

    @Test
    void testEmpty() {
        assertFalse(Main.isSSN(""),"empty failed");
        assertFalse(Main.isSSN("111"),"one chunk failed");
        assertFalse(Main.isSSN("have you heard of raid shadow legends?"),"yeah something real bad idk");
    }

}
