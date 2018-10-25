package JUnitTest;

import org.junit.Before;
import org.junit.Test;
import regexTest.IS1900s;

import static org.junit.Assert.*;

public class IS1900sTest {
    IS1900s is1900s;
    @Before
    public void setUp(){
        is1900s = new IS1900s();
    }


    @Test
    public void testIS1900s(){
        assertTrue(is1900s.is1900s("1992"));
        assertTrue(is1900s.is1900s("1903"));
        assertTrue(is1900s.is1900s("1938"));

        assertFalse(is1900s.is1900s("aas"));
        assertFalse(is1900s.is1900s("1188"));
        assertFalse(is1900s.is1900s("19888"));
        assertFalse(is1900s.is1900s(null));
    }

}