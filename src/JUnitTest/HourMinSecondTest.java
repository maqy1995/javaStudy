package JUnitTest;

import org.junit.Test;
import regexTest.HourMinSecond;

import static org.junit.Assert.*;

public class HourMinSecondTest {

    @Test
    public void getHourMinSecond() {
        assertEquals(new HourMinSecond("23","57","15"),HourMinSecond.getHourMinSecond("23:57:15"));

        assertEquals(new HourMinSecond("15","6","07"),HourMinSecond.getHourMinSecond("15:6:07"));

        assertEquals(null,HourMinSecond.getHourMinSecond("25:57:15"));

        assertEquals(null,HourMinSecond.getHourMinSecond("24:77:15"));

        assertEquals(null,HourMinSecond.getHourMinSecond("15:23:89"));
    }

}