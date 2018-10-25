package thread;

public class ThreadFirst {
    public static void main(String[] args) {
        System.out.println("main start");
        Thread t =new Thread(){
            @Override
            public void run() {
                System.out.println("thread run ...");
                System.out.println("thread end");
            }
        };
        t.start();
        System.out.println("main end");
    }
}
