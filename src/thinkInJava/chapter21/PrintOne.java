package thinkInJava.chapter21;

/**
 * 两个线程交替打印1
 */
class Test implements Runnable {
    private static volatile int flag = 0;

    private int i=0;

    public Test(int i){
        this.i=i;
    }
    @Override
    public void run() {
        while(true){
            if(flag %2 == i){
                System.out.println(Thread.currentThread().getName() + "flag:" + flag);
                flag++;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class PrintOne {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Test(0));
        Thread thread2 = new Thread(new Test(1));
        thread1.start();
        thread2.start();
    }
}
