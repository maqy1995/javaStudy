public class Test {
    public static int race=0;

    public static void increment(){
        race++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for(int i=0;i<20;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<1000;j++){
                        increment();
                    }
                }
            });
            threads[i].start();
        }

        for(Thread thread : threads) {
            thread.join();
        }
//        while (Thread.activeCount()>2){
//            Thread.yield();
//        }
        System.out.println(Thread.activeCount());

        System.out.println(race);

    }
}
