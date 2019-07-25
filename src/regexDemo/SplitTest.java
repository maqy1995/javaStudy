package regexDemo;

public class SplitTest {
    public static void main(String[] args) {
        String s = "4066|AAAAAAAACOPAAAAA||||38||Very shallow parents could feel things. Still availabl||";

        String ss = "||||";

        String sss = "1|AAAAAAAABAAAAAAA|2450815|2450996|DEPARTMENT|1|1|In general basic characters welcome. Clearly lively friends conv|bi-annual|";
        String[] tokens = sss.split("\\|");
        System.out.println(tokens);
    }
}
