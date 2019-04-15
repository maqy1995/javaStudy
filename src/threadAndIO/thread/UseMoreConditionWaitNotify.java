package threadAndIO.thread;

public class UseMoreConditionWaitNotify {
    public static void main(String[] args) throws InterruptedException {
        MyServiceMoreCondition service = new MyServiceMoreCondition();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        Thread b = new ThreadB(service);
        b.setName("B");
        b.start();

        Thread.sleep(3000);

        service.signalAll_A();
    }
    public static class ThreadA extends Thread {
        private MyServiceMoreCondition service;
        public ThreadA(MyServiceMoreCondition service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.awaitA();
        }
    }

    public static class ThreadB extends Thread {
        private MyServiceMoreCondition service;
        public ThreadB(MyServiceMoreCondition service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.awaitB();
        }
    }
}
