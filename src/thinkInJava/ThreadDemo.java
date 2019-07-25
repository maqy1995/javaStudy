package thinkInJava;

import java.io.IOException;

class UnresponsiveUI {
    private volatile double d = 1;
    public UnresponsiveUI() throws IOException {
        while (d>0){
            d = d+ d;
        }
        System.in.read();
    }
}

class ResponsiveUI extends Thread{

}

public class ThreadDemo extends Thread{
    private static volatile double d = 1;
    public ThreadDemo(){
        setDaemon(true);
        this.start();
    }
    @Override
    public void run(){
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }

    }

    public static void main(String[] args) throws IOException {
        new UnresponsiveUI();
        new ThreadDemo();
        System.in.read();
        System.out.println(d);
    }
}
