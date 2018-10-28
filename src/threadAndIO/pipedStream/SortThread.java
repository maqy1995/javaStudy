package threadAndIO.pipedStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用于排序的线程
 */
public class SortThread extends Thread{
    private PrintWriter out =null;
    private BufferedReader in =null;

    public SortThread(PrintWriter out, BufferedReader in) {
        this.out = out;
        this.in = in;
    }

    //排序线程的线程体
    public void run(){
        int MAXWORDS =50 ;
        if(out!=null && in!=null){
            try {
                String[] listOfWords =new String[MAXWORDS];
                int numwords=0;
                while((listOfWords[numwords] = in.readLine())!=null){
                    numwords++;
                }
                //进行快排
                quicksort(listOfWords,0,numwords-1);
                for(int i =0;i<numwords;i++){
                    out.println(listOfWords[i]);
                }
                //注意这里至关闭了out流，关闭流
                out.close();
            } catch (IOException e) {
                System.out.println("SortThread run:"+e);
            }
        }
    }

    //实现快排
    private static void quicksort(String[] a,int left0,int right0){
        int left=left0;
        int right=right0;
        if(left>=right){
            return;
        }
        //选择tag值
        String mid=a[(left+right)/2];
        while(left<right){
            while(left<right && a[left].compareTo(mid)<0){
                left++;
            }
            while(left<right && a[right].compareTo(mid)>0){
                right--;
            }
            if(left<right){
                //swap a[left] and a[right]
                String t=a[left];
                a[left]=a[right];
                a[right]=t;
//                left++;
//                right--;
            }
        }
//        if(right<left){
//            int t =right;
//            right = left;
//            left = t;
//        }

        quicksort(a,left0,left);
        quicksort(a,left==left0?left+1:left,right0);
    }
}
