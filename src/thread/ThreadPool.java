package thread;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 测试一下schedule
 * FixedRate模式下，任务执行时间过长，后续任务也不会并发执行
 * 任务抛出异常，后续任务也会继续执行。
 */
class HelloTask implements Runnable {
    String name;

    public HelloTask(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("Hello," + name + "! It is " + LocalTime.now());
        int[] t=null;
        try {
            System.out.println("ThreadID:"+Thread.currentThread().getId());
            Thread.sleep(5000);
            System.out.println(t[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("GoodBye,"+name +"! It is "+ LocalTime.now());

    }
}

public class ThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        Thread t =new Thread(new HelloTask("Bpb"));
        executor.scheduleAtFixedRate(t,2,1,TimeUnit.SECONDS);
        //executor.scheduleWithFixedDelay(new HelloTask("Alice"),2,1,TimeUnit.SECONDS);
        //executor.shutdown();
    }
}
