package regexTest;
/**
 * regex for time like 20:30:15
 */

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HourMinSecond {
    String hour;
    String min;
    String second;

    public HourMinSecond(String hour, String min, String second) {
        this.hour = hour;
        this.min = min;
        this.second = second;
    }

    static Pattern pattern = Pattern.compile("([0-1][0-9]|[2][0-3])\\:([0-5][0-9]|[0-9])\\:([0-5][0-9]|[0-9])");
    public static HourMinSecond getHourMinSecond(String s){
        Matcher matcher = pattern.matcher(s);
        if(matcher.matches()){
            String hour = matcher.group(1);
            String min = matcher.group(2);
            String second = matcher.group(3);
            return new HourMinSecond(hour,min,second);
        }else
            return null;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this){
            return  true;
        }
        if(o instanceof HourMinSecond){
            HourMinSecond h = (HourMinSecond)o;
            return Objects.equals(h.hour, this.hour) && Objects.equals(h.min, this.min) && Objects.equals(h.second, this.second) ;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.hour+":"+this.min+":"+this.second;
    }

}
