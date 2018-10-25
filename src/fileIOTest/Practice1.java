package fileIOTest;

import java.io.File;

public class Practice1 {
    public static void printFile(File file,int level){
        if(file.isDirectory()){
            String pre="";
            for(int i=0;i<level;i++){
                pre=pre+" ";
            }
            File[] fs =file.listFiles();
            for(File ff:fs){
                System.out.print(pre);
                System.out.println(ff.getName());
                if(ff.isDirectory()){
                    level++;
                    printFile(ff,level);
                }
            }
        }
    }
    public static void main(String[] args) {
        String input=null;
        if(args.length==0){
            input=".";
        }else if (args.length ==1){
            input = args[0];
        }else{
            System.out.println("input error");
            return ;
        }
        File f= new File(input);
        printFile(f,0);
    }

}
