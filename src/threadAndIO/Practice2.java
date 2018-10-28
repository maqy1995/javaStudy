package threadAndIO;

import java.io.*;

public class Practice2 {
    public static void main(String[] args) throws IOException {
        try(InputStream inputStream=new FileInputStream("test");OutputStream outputStream=new FileOutputStream("result")) {
            byte[] buffer=new byte[2];
            int n;
            while((n=inputStream.read(buffer))!=-1){
                System.out.println(n);
                outputStream.write(n);
            }
        }
    }
}
