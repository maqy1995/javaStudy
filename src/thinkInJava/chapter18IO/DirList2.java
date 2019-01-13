package thinkInJava.chapter18IO;
//Uses anonymous inner classes

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList2 {
    //注意jdk8之前，匿名内部类引用外部类的局部变量是需要加final修饰的，jdk8则题我们添加了这个语法糖。
    //即参数 String regex 原来应该是 final String regex
    public static FilenameFilter filter(String regex){
        // Creation of anonymous inner class:
        return new FilenameFilter(){
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };// End of anonymous inner class.
    }
    public static void main(String[] args){
        File file =new File(".");
        String[] list;
        if(args.length==0){
            list=file.list();
        }else {
            list=file.list(filter(args[0]));
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String filename:list){
            System.out.println(filename);
        }
    }
}
