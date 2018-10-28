package threadAndIO.pipedStream;

import java.io.*;

/**
 * 2018.10.28
 *
 * 一个单词处理程序。该程序从文件中读入一组单词，先将每个单词逆序(reverse),再将所有单词排序(sort)，然后将这些词逆序输出。
 * 最后输出的单词列表能够押韵。
 * 包括如下三个程序：
 * RhymingWords.java---------------包含main(),reverse()和sort()。
 * ReverseThread.java-----包含执行逆序的线程类。
 * SortThread.java--------包含执行排序的线程类
 */
public class RhymingWords {


    //创建管道，创建并启动单词逆序线程
    public static Reader reverse(Reader source) throws IOException {
        BufferedReader in =new BufferedReader(source);
        PipedWriter pipeOut=new PipedWriter();
        PipedReader pipeIn =new PipedReader(pipeOut);
        PrintWriter out =new PrintWriter(pipeOut);
        new ReverseThread(out,in).start();
        return pipeIn;
    }

    //创建管道，创建并启动单词排序线程
    public static Reader sort(Reader source) throws IOException {
        BufferedReader in =new BufferedReader(source);
        PipedWriter pipeOut = new PipedWriter();
        PipedReader pipeIn =new PipedReader(pipeOut);
        PrintWriter out = new PrintWriter(pipeOut);
        new SortThread(out,in).start();
        return pipeIn;
    }

    public static void main(String[] args) throws IOException {
        FileReader words =new FileReader("./src/threadAndIO/pipedStream/words.txt");

        //进行单词的逆序、排序、再逆序还原
        Reader rhymedWords =reverse(sort(reverse(words)));

        //将处理后的单词列表输出显示
        BufferedReader in =new BufferedReader(rhymedWords);
        String input;
        while((input=in.readLine())!=null){
            System.out.println(input);
        }
        in.close();
    }
}
