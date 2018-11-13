package regexDemo;

public class IS1900s {
    public boolean is1900s(String s){
        if(s == null) {
            return false;
        }
        return s.matches("19\\d\\d");
    }
}
