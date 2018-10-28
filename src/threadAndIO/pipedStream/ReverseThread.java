package threadAndIO.pipedStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 执行逆序的线程类
 */
public class ReverseThread extends Thread {
    private PrintWriter out = null;
    private BufferedReader in = null;

    public ReverseThread(PrintWriter out, BufferedReader in) {
        this.out = out;
        this.in = in;
    }

    //逆序线程的线程体
    public void run() {
        if (out != null && in != null) {
            try {
                String input;
                while ((input = in.readLine()) != null) {
                    out.println(reverseIt(input));
                    out.flush();
                }
                //注意这里只关闭了out流
                out.close();
            }catch (IOException e){
                System.out.println("ReverseThread run :" +e);
            }
        }
    }

    //实现单词的逆序算法
    private String reverseIt(String source){
        int i,len =source.length();
        //　　String：适用于少量的字符串操作的情况
        //　　StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
        //　　StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况,是线程安全的
        StringBuffer dest = new StringBuffer(len);
        for(i=(len-1);i>=0;i--){
            dest.append(source.charAt(i));
        }
        return dest.toString();
    }
}
