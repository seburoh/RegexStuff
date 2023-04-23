import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CityStateZipTests {

    /*
    Address is 2101 Jefferson Ave, Tacoma, WA 98402.
     */

    /* Positives. */

    @Test
    void basicDate() {
        assertTrue(Main.isCityState("Tacoma, WA 98402"));
    }

    @Test
    void basicCase() {
        assertTrue(Main.isCityState("tAcoma, wa 98402"));
        assertTrue(Main.isCityState("TAC, WA 98402"));
        assertTrue(Main.isCityState("tac, Wa 98402"));
    }

    @Test
    void separators() {
        assertTrue(Main.isCityState("Tacoma, WA 98402"));
        assertTrue(Main.isCityState("Tacoma WA 98402"));
        assertTrue(Main.isCityState("Tacoma,WA 98402"));
        assertTrue(Main.isCityState("Tacoma, WA, 98402"));
        assertTrue(Main.isCityState("Tacoma, WA 98402"));
        assertTrue(Main.isCityState("Tacoma, WA,98402"));
    }

    @Test
    void smolCity() {
        assertTrue(Main.isCityState("T, WA 98402"));
    }

    @Test
    void cityCodes() {
        assertTrue(Main.isCityState("Tacoma, AL 98402"));
        assertTrue(Main.isCityState("Tacoma, Ak 98402"));
        assertTrue(Main.isCityState("Tacoma, Az 98402"));
        assertTrue(Main.isCityState("Tacoma, Ar 98402"));
        assertTrue(Main.isCityState("Tacoma, As 98402"));
        assertTrue(Main.isCityState("Tacoma, ca 98402"));
        assertTrue(Main.isCityState("Tacoma, co 98402"));
        assertTrue(Main.isCityState("Tacoma, ct 98402"));
        assertTrue(Main.isCityState("Tacoma, de 98402"));
        assertTrue(Main.isCityState("Tacoma, dc 98402"));
        assertTrue(Main.isCityState("Tacoma, fl 98402"));
        assertTrue(Main.isCityState("Tacoma, ga 98402"));
        assertTrue(Main.isCityState("Tacoma, gu 98402"));
        assertTrue(Main.isCityState("Tacoma, hi 98402"));
        assertTrue(Main.isCityState("Tacoma, id 98402"));
        assertTrue(Main.isCityState("Tacoma, il 98402"));
        assertTrue(Main.isCityState("Tacoma, in 98402"));
        assertTrue(Main.isCityState("Tacoma, ia 98402"));
        assertTrue(Main.isCityState("Tacoma, ks 98402"));
        assertTrue(Main.isCityState("Tacoma, ky 98402"));
        assertTrue(Main.isCityState("Tacoma, la 98402"));
        assertTrue(Main.isCityState("Tacoma, me 98402"));
        assertTrue(Main.isCityState("Tacoma, md 98402"));
        assertTrue(Main.isCityState("Tacoma, ma 98402"));
        assertTrue(Main.isCityState("Tacoma, mi 98402"));
        assertTrue(Main.isCityState("Tacoma, mn 98402"));
        assertTrue(Main.isCityState("Tacoma, ms 98402"));
        assertTrue(Main.isCityState("Tacoma, mo 98402"));
        assertTrue(Main.isCityState("Tacoma, mt 98402"));
        assertTrue(Main.isCityState("Tacoma, ne 98402"));
        assertTrue(Main.isCityState("Tacoma, nv 98402"));
        assertTrue(Main.isCityState("Tacoma, nh 98402"));
        assertTrue(Main.isCityState("Tacoma, nj 98402"));
        assertTrue(Main.isCityState("Tacoma, nm 98402"));
        assertTrue(Main.isCityState("Tacoma, ny 98402"));
        assertTrue(Main.isCityState("Tacoma, nc 98402"));
        assertTrue(Main.isCityState("Tacoma, nd 98402"));
        assertTrue(Main.isCityState("Tacoma, mp 98402"));
        assertTrue(Main.isCityState("Tacoma, oh 98402"));
        assertTrue(Main.isCityState("Tacoma, ok 98402"));
        assertTrue(Main.isCityState("Tacoma, or 98402"));
        assertTrue(Main.isCityState("Tacoma, pa 98402"));
        assertTrue(Main.isCityState("Tacoma, pr 98402"));
        assertTrue(Main.isCityState("Tacoma, ri 98402"));
        assertTrue(Main.isCityState("Tacoma, sc 98402"));
        assertTrue(Main.isCityState("Tacoma, sd 98402"));
        assertTrue(Main.isCityState("Tacoma, tn 98402"));
        assertTrue(Main.isCityState("Tacoma, tx 98402"));
        assertTrue(Main.isCityState("Tacoma, tt 98402"));
        assertTrue(Main.isCityState("Tacoma, ut 98402"));
        assertTrue(Main.isCityState("Tacoma, vt 98402"));
        assertTrue(Main.isCityState("Tacoma, va 98402"));
        assertTrue(Main.isCityState("Tacoma, vi 98402"));
        assertTrue(Main.isCityState("Tacoma, wa 98402"));
        assertTrue(Main.isCityState("Tacoma, wv 98402"));
        assertTrue(Main.isCityState("Tacoma, wi 98402"));
        assertTrue(Main.isCityState("Tacoma, wy 98402"));
    }

    @Test
    void variousZips() {
        assertTrue(Main.isCityState("Tacoma, WA 00000"));
        assertTrue(Main.isCityState("Tacoma, WA 99999"));
        assertTrue(Main.isCityState("Tacoma, WA 42069"));
    }

    /* Negatives. */

    @Test
    void noCity() {
        assertFalse(Main.isCityState("WA 98402"));
        assertFalse(Main.isCityState(",WA 98402"));
        assertFalse(Main.isCityState(", WA 98402"));
    }

    @Test
    void noState() {
        assertFalse(Main.isCityState("Tacoma, 98402"));
        assertFalse(Main.isCityState("Tacoma  98402"));
        assertFalse(Main.isCityState("Tacoma,,98402"));
    }

    @Test
    void noZip() {
        assertFalse(Main.isCityState("Tacoma, WA,"));
        assertFalse(Main.isCityState("Tacoma, WA "));
        assertFalse(Main.isCityState("Tacoma, WA, "));
    }

    @Test
    void startEnd() {
        assertFalse(Main.isCityState(" Tacoma, WA 98402"));
        assertFalse(Main.isCityState(" Tacoma, WA 98402 "));
        assertFalse(Main.isCityState("Tacoma, WA 98402 "));
    }

    @Test
    void empty() {
        assertFalse(Main.isCityState(""));
    }

    @Test
    void realBad() {
        assertFalse(Main.isCityState("hue"));
        assertFalse(Main.isCityState("twinz^2-1 made a really good song before they went bankrupt"));
    }
}
