package thinkInJava.chapter18IO;
//Display a directory listing using regular expressions.
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args){
        File file =new File(".");
        String[] list;
        if(args.length==0){
            list=file.list();
        }else {
            list=file.list(new DirFilter(args[0]));
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String filename:list){
            System.out.println(filename);
        }
    }
}

class DirFilter implements FilenameFilter {
    private Pattern pattern;
    public DirFilter(String regex){
     this.pattern=Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
