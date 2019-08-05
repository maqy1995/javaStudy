package threadAndIO.thread;

public class TwoThreadPrint {
    private static int i = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread("偶数线程") {
            @Override
            public void run() {
                while (i <= 100) {
                    synchronized (TwoThreadPrint.class) {
                        if ((i & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + i);
                            i++;
                        }
                        try {
                            TwoThreadPrint.class.notify();
                            TwoThreadPrint.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread t2 = new Thread("奇数线程") {
            @Override
            public void run() {
                while (i <= 100) {
                    synchronized (TwoThreadPrint.class) {

                        if ((i & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + i);
                            i++;
                        }
                        try {
                            TwoThreadPrint.class.notify();
                            TwoThreadPrint.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
