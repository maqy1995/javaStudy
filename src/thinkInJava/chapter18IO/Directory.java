package thinkInJava.chapter18IO;

import thinkInJava.util.PPrint;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class Directory {
    public static File[] local(File dir, final String regex){//匿名内部类需要final，1.8之后添加了语法糖
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
                //return pattern.matcher(new File(name).getName()).matches();  //书里为什么要这么写？
            }
        });
    }
    //overload
    public static File[] local(String path, final String regex){
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();

        // The default iterable element is the file list:
        public Iterator<File> iterator() {
            return files.iterator();
        }
        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }
        public String toString(){
            return "dirs:" + PPrint.pformat(dirs) + "\n\nfiles:" + PPrint.pformat(files);
        }
        public static TreeInfo walk(String start, String regex){
            // Begin recursion
            return recurseDirs(new File(start), regex);
        }
        public static TreeInfo walk(File start, String regex){
            //Overloaded
            return recurseDirs(start,regex);
        }
        public static TreeInfo walk(File start){
            return recurseDirs(start, ".*");
        }
        public static TreeInfo walk(String start){
            return recurseDirs(new File(start), ".*");
        }

        static TreeInfo recurseDirs(File startDir, String regex){
            TreeInfo result = new TreeInfo();
            for(File item : startDir.listFiles()){
                if(item.isDirectory()){
                    result.dirs.add(item);
                    result.addAll(recurseDirs(item, regex));
                }else {
                    // Regular file
                    if(item.getName().matches(regex)){
                        result.files.add(item);
                    }
                }
            }
            return result;
        }
        //test
        public static void main(String[] args) {
            System.out.println(walk("D:\\maqy"));
        }
    }
}
