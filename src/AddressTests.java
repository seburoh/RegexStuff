import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AddressTests {

    /*
    Address is 2101 Jefferson Ave, Tacoma, WA 98402.
     */

    /* Positives. */

    @Test
    void basicDate() {
        assertTrue(Main.isAddress("2101 Jefferson ave"));
    }

    @Test
    void appendTypesSmall() {
        assertTrue(Main.isAddress("2101 Jefferson ave"));
        assertTrue(Main.isAddress("2101 Jefferson st"));
        assertTrue(Main.isAddress("2101 Jefferson rd"));
        assertTrue(Main.isAddress("2101 Jefferson blvd"));
    }

    @Test
    void appendTypesBig() {
        assertTrue(Main.isAddress("2101 Jefferson avenue"));
        assertTrue(Main.isAddress("2101 Jefferson street"));
        assertTrue(Main.isAddress("2101 Jefferson road"));
        assertTrue(Main.isAddress("2101 Jefferson boulevard"));
    }

    @Test
    void funnyCase() {
        assertTrue(Main.isAddress("2101 Jefferson aVe"));
        assertTrue(Main.isAddress("2101 JeFFFon st"));
        assertTrue(Main.isAddress("2101 JeffersoN RD"));
        assertTrue(Main.isAddress("2101 jefferson blvD"));
        assertTrue(Main.isAddress("2101 Jefferson AVEnue"));
        assertTrue(Main.isAddress("2101 Jeff stREET"));
        assertTrue(Main.isAddress("2101 JEFF RoAd"));
        assertTrue(Main.isAddress("2101 jeff bouLevard"));
    }

    @Test
    void smolName() {
        assertTrue(Main.isAddress("2101 J ave"));
    }

    @Test
    void numbers() {
        assertTrue(Main.isAddress("1 Jefferson ave"));
        assertTrue(Main.isAddress("0 Jefferson ave"));
        assertTrue(Main.isAddress("01 Jefferson ave"));
        assertTrue(Main.isAddress("99999991 Jefferson ave"));
    }

    /* Negatives. */

    @Test
    void noNumber() {
        assertFalse(Main.isAddress("Jefferson ave"));
    }

    @Test
    void noName() {
        assertFalse(Main.isAddress("2101 ave"));
    }

    @Test
    void noType() {
        assertFalse(Main.isAddress("2101 Jefferson"));
    }

    @Test
    void beforeAfter() {
        assertFalse(Main.isAddress(" 2101 Jefferson ave"));
        assertFalse(Main.isAddress(" 2101 Jefferson ave "));
        assertFalse(Main.isAddress("2101 Jefferson ave "));
    }

    @Test
    void badType() {
        assertFalse(Main.isAddress("2101 Jefferson hwy"));
    }

    @Test
    void empty() {
        assertFalse(Main.isAddress(""));
    }

    @Test
    void realBad() {
        assertFalse(Main.isAddress("jeff"));
        assertFalse(Main.isAddress("my everyday raycon e25 earbuds let me listen to youtube premium"));
    }
}