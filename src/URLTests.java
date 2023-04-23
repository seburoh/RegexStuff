import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class URLTests {

    /* Positives. */

    @Test
    void basicURLHTTP() {
        assertTrue(Main.isURL("http://regex101.com/"));
    }

    @Test
    void basicURLNoHTTP() {
        assertTrue(Main.isURL("regex101.com/"));
    }

    @Test
    void basicURLHTTPS() {
        assertTrue(Main.isURL("https://regex101.com/"));
    }

    @Test
    void longURLHTML() {
        assertTrue(Main.isURL("https://docs.oracle.com/javase/tutorial/essential/regex/groups.html"));
    }

    @Test
    void longURLwordEnd() {
        assertTrue(Main.isURL("https://canvas.uw.edu/courses/1642545/assignments/8223051#submit"));
    }

    @Test
    void longURLSlashEnd() {
        assertTrue(Main.isURL("https://store.steampowered.com/app/2385750/Mega_Man_Battle_Network_Legacy_Collection_Original_Soundtrack/"));
    }

    @Test
    void smol() {
        assertTrue(Main.isURL("r.c"));
    }

    /* Negatives. */

    @Test
    void badHTTP() {
        assertFalse(Main.isURL("htts://regex101.com/"));
    }

    @Test
    void periodEnd() {
        assertFalse(Main.isURL("https://regex101.com/."));
    }

    @Test
    void noPeriod() {
        assertFalse(Main.isURL("https://regex101/com/"));
    }

    @Test
    void startEnd() {
        assertFalse(Main.isURL(" https://regex101.com/"));
        assertFalse(Main.isURL(" https://regex101.com/ "));
        assertFalse(Main.isURL("https://regex101.com/ "));
    }

    @Test
    void empty() {
        assertFalse(Main.isURL(""));
    }

    @Test
    void realBad() {
        assertFalse(Main.isURL("whee"));
        assertFalse(Main.isURL("i'm pretty sure genshin is just overrated because the waifus are cute"));
    }
}