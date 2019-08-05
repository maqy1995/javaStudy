package thinkInJava.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用来测试IntGenerator的类
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int id){
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while(!generator.isCanceled()){
            int val = generator.next();
            if(val % 2 != 0){
                System.out.println(val + "not even");
                generator.cancel(); // Cancels all EvenCheckers
            }
        }
    }

    // Test any type of generator
    public static void test(IntGenerator generator,int count){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < count; i++){
            executorService.execute(new EvenChecker(generator,i));
        }
        executorService.shutdown();
    }

    public static void test(IntGenerator generator){
        test(generator, 10);
    }
}
