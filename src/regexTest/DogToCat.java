package regexTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DogToCat {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("cat");
        Matcher m = p.matcher("one cat two cats in the yard");
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "dog");
        }
        System.out.println(sb.toString());
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}
