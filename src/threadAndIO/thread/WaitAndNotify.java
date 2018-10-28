package threadAndIO.thread;

import java.util.LinkedList;
import java.util.Queue;

class TaskQueue{
    final Queue<String> queue = new LinkedList<>();

    public synchronized String getTask() throws InterruptedException{
        //为什么用while，不用if，因为可能有多个线程同时在等待，而当notify方法解锁时，只会有一个线程
        //得到锁，该线程会运行remove方法，其他线程仍然需要判断队列是否为空，不然可能队列已经为空了，却仍然执行remove方法报错
        while(this.queue.isEmpty()){
            /*
            线程进入等待状态，但wait()方法并不会返回，只有通过其他线程唤起后，wait()方法才会返回
            其是定义在object类上的native方法，也就是由jvm虚拟机的c代码实现的
            必须在synchronized代码块中才可以调用，因为wait()方法调用的时候线程会释放锁，
            wait()方法返回以后，又要重新获得锁，我们只能在锁对象上调用wait方法(这里是this)
             */
            this.wait();
        }
        return queue.remove();
    }

    public synchronized void addTask(String name){
        this.queue.add(name);
        //用来唤起wait()的线程
        //this.notify();
        //唤醒所有线程
        this.notifyAll();
    }
}

class WorkerThread extends Thread {
    TaskQueue taskQueue;
    public WorkerThread(TaskQueue taskQueue){
        this.taskQueue=taskQueue;
    }

    public void run() {
        while(!isInterrupted()) {
            String name;
            try {
                name= taskQueue.getTask();
            } catch (InterruptedException e) {
                //不break的话，name可能没有初始化,这里打印出Exception的话会提交出去，因此不提交了
                break;
            }
            String result = "Hello," + name + "!";
            System.out.println(result);
        }
    }
}

public class WaitAndNotify {
    public static void main(String[] args) throws Exception {
        TaskQueue taskQueue = new TaskQueue();
        WorkerThread workerThread = new WorkerThread(taskQueue);
        workerThread.start();
        taskQueue.addTask("Bob");
        Thread.sleep(1000);
        taskQueue.addTask("Alice");
        Thread.sleep(1000);
        taskQueue.addTask("Tim");
        Thread.sleep(1000);
        //让worker线程中断
        workerThread.interrupt();
        //让主线程先等待worker线程的结束
        workerThread.join();
        System.out.println("End");
    }
}
