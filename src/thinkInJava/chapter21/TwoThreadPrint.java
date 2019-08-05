package thinkInJava.chapter21;

public class TwoThreadPrint {
    private int count = 0;
    private final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new TwoThreadPrint().turning();
    }

    class TurningRunner2 implements Runnable {

        @Override
        public void run() {
            while (count <= 100){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName() + count++);
                    lock.notifyAll();
                    if(count <= 100){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void turning() throws InterruptedException {
        new Thread(new TurningRunner2(), "偶数").start();
        // 确保偶数线程线先获取到锁
        Thread.sleep(1);
        new Thread(new TurningRunner2(), "奇数").start();
    }

    class TurningRunner implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                // 获取锁
                synchronized (lock) {
                    // 拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    // 唤醒其他线程
                    lock.notifyAll();
                    try {
                        if (count <= 100) {
                            // 如果任务还没有结束，则让出当前的锁并休眠
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
