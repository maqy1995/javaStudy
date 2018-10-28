package threadAndIO.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for(String name : Arrays.asList("Bob","Alice","Tom")){
            threads.add(new HelloThread(name));
        }
        System.out.println("START:");
        for(Thread t : threads){
            t.start();
        }
        for(Thread t : threads){
            t.join();
        }
        System.out.println("END");
    }
}
