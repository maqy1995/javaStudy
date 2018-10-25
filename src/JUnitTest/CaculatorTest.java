package JUnitTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CaculatorTest {

    @Test
    public void testcaculate() {
        assertEquals(3,new Caculator().caculate("1+2"));
        assertEquals(6,new Caculator().caculate("1+2+3"));
    }
    @Test
    public void testCaculateWithSpace(){
        assertEquals(3,new Caculator().caculate("1 + 2"));
    }
}