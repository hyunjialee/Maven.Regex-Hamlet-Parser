import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String toChange = "The Tragedy of Hamlet, Prince of Denmark";
        String expected = "The Tragedy of Leon, Prince of Denmark";

        String actual = "";

        assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String toChange = "What, is Horatio there?";
        String expected = "What, is Tariq there?";

        String actual = "";

        assertEquals(expected,actual);

    }

    @Test
    public void testFindHoratio() {

        String toFind = "Well, good night.\n" +
                "If you do meet Horatio and Marcellus,\n" +
                "The rivals of my watch, bid them make haste.";
        ;

    }

    @Test
    public void testFindHamlet() {

        String toFind = "Good Hamlet, cast thy nighted colour off,\n" +
                "And let thine eye look like a friend on Denmark.\n" +
                "Do not for ever with thy vailed lids";
    }
}