package threadAndIO.thread;

public class ThreadFirst {
    public static void main(String[] args) {
        System.out.println("main start");
        Thread t =new Thread(){
            @Override
            public void run() {
                System.out.println("threadAndIO.thread run ...");
                System.out.println("threadAndIO.thread end");
            }
        };
        t.run();
        System.out.println("main end");
    }
}
