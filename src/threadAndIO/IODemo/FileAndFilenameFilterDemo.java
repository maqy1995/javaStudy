package threadAndIO.IODemo;

/**
 * A demo in <Thinking in Java> Page 526.
 * test the function of File.list().
 *
 * @author maqy
 * @date 2018.12.21
 */

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileAndFilenameFilterDemo {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if(args.length==0){
            list=path.list();
        }else {
            list=path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String name:list){
            System.out.println(name);
        }
    }
}

class DirFilter implements FilenameFilter{
    Pattern pattern;
    public DirFilter(String regex){
        this.pattern=Pattern.compile(regex);
    }
    @Override
    public boolean accept(File dir, String name) {
        return this.pattern.matcher(name).matches();
    }
}
