package regexDemo;

public class IsQQNum {
    public boolean isQQNum(String s){
        return s.matches("\\d{5,10}");
    }
}
