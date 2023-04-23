import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EmailTests {

    /* Positives. */

    @Test
    void basicEmail() {
        assertTrue(Main.isEmail("jamesbond@mi6.gov"), "Basic failed");
    }

    @Test
    void localEndsNums() {
        assertTrue(Main.isEmail("jamesbond007@mi6.gov"), "Num end failed");
    }

    @Test
    void smolLocal() {
        assertTrue(Main.isEmail("j@mi6.gov"), "Num end failed");
    }

    @Test
    void smolDomain() {
        assertTrue(Main.isEmail("jamesbond007@m.gov"), "Num end failed");
    }

    @Test
    void multipartDomainEmail() {
        assertTrue(Main.isEmail("jamesbond007@mi6.co.nz"), "What did New Zealand do to you?");
    }

    @Test
    void withLocalPeriods() {
        assertTrue(Main.isEmail("jamesbond.007@mi6.gov"), "One period failed");
        assertTrue(Main.isEmail("james.bond.007@mi6.gov"), "Two periods failed");
        assertTrue(Main.isEmail("j.a.m.e.s.bond.007@mi6.gov"), "Many periods failed");
    }

    @Test
    void withDomainPeriods() {
        assertTrue(Main.isEmail("jamesbond007@mi.6.gov"), "Two periods failed");
        assertTrue(Main.isEmail("jamesbond007@m.i.6.gov"), "Two periods failed");
        assertTrue(Main.isEmail("jamesbond007@m.i.6.6.6.gov"), "Many periods failed");
    }

    @Test
    void localStartsNums() {
        assertTrue(Main.isEmail("007jamesbond@mi6.gov"), "Num start failed");
    }

    @Test
    void domainStartsNums() {
        assertTrue(Main.isEmail("007jamesbond@6mi6.gov"), "Num start failed");
    }

    @Test
    void domainEndsNotNums() {
        assertTrue(Main.isEmail("007jamesbond@mi.gov"), "Not num end failed");
    }

    /* Negatives. */

    @Test
    void localStartsWithPeriod() {
        assertFalse(Main.isEmail(".jamesbond007@mi6.gov"), "Starter failed");
        assertFalse(Main.isEmail("..jamesbond007@mi6.gov"), "Starter failed");
    }

    @Test
    void localEndsWithPeriod() {
        assertFalse(Main.isEmail("jamesbond007.@mi6.gov"), "Starter failed");
        assertFalse(Main.isEmail("jamesbond007..@mi6.gov"), "Starter failed");
    }

    @Test
    void domainStartsWithPeriod() {
        assertFalse(Main.isEmail("jamesbond007@.mi6.gov"), "Starter failed");
        assertFalse(Main.isEmail("jamesbond007@..mi6.gov"), "Starter failed");
    }

    @Test
    void domainEndsWithPeriod() {
        assertFalse(Main.isEmail("jamesbond007@mi6.gov."), "Starter failed");
        assertFalse(Main.isEmail("jamesbond007@mi6.gov.."), "Starter failed");
    }

    @Test
    void localConsPeriods() {
        assertFalse(Main.isEmail("james..bond007@mi6.gov"), "Starter failed");
    }

    @Test
    void domainConsPeriods() {
        assertFalse(Main.isEmail("jamesbond007@mi6..gov"), "Starter failed");
    }

    @Test
    void noLocal() {
        assertFalse(Main.isEmail("@mi6.gov"), "Starter failed");
    }

    @Test
    void noFirstDomain() {
        assertFalse(Main.isEmail("jamesbond007@.gov"), "Starter failed");
    }

    @Test
    void noDomain() {
        assertFalse(Main.isEmail("jamesbond007@"), "Starter failed");
    }

    @Test
    void testEmpty() {
        assertFalse(Main.isSSN(""),"empty failed");
    }

    @Test
    void testDumb() {
        assertFalse(Main.isSSN("111"),"one chunk failed");
        assertFalse(Main.isSSN("have you heard of raid shadow legends?"),"yeah something real bad idk");
    }

}
