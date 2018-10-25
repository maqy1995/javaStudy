package JUnitTest;

import org.junit.Before;
import org.junit.Test;
import regexTest.IsQQNum;

import static org.junit.Assert.*;

public class IsQQNumTest {
    IsQQNum isQQNum;
    @Before
    public void setUp(){
        isQQNum = new IsQQNum();
    }

    @Test
    public void test(){
        assertTrue(isQQNum.isQQNum("123456789"));
        assertTrue(isQQNum.isQQNum("54321"));
        assertTrue(isQQNum.isQQNum("135879"));
        assertTrue(isQQNum.isQQNum("121112133"));
        assertTrue(isQQNum.isQQNum("1234567890"));

        assertFalse(isQQNum.isQQNum("12345678900"));
        assertFalse(isQQNum.isQQNum("1234"));
        assertFalse(isQQNum.isQQNum("12345678900sa"));
        assertFalse(isQQNum.isQQNum("12345678$9"));
        assertFalse(isQQNum.isQQNum("1234567s8"));


    }

}