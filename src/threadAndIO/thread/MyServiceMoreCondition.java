package threadAndIO.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyServiceMoreCondition {
    private Lock lock = new ReentrantLock();
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();

    public void awaitA(){
        lock.lock();
        try{
            System.out.println("begin awaitA的时间为"+System.currentTimeMillis()+"ThreadName"+Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end awaitA的时间为"+System.currentTimeMillis()+"ThreadName"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void awaitB(){
        lock.lock();
        try{
            System.out.println("begin awaitB的时间为"+System.currentTimeMillis()+"ThreadName"+Thread.currentThread().getName());
            conditionB.await();
            System.out.println("end awaitB的时间为"+System.currentTimeMillis()+"ThreadName"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalAll_A() {
        lock.lock();
        try {
            System.out.println("signalAll_A时间为："+System.currentTimeMillis()+"ThreadName" + Thread.currentThread().getName());
            conditionA.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void signalAll_B() {
        lock.lock();
        try {
            System.out.println("signalAll_B时间为："+System.currentTimeMillis()+"ThreadName" + Thread.currentThread().getName());
            conditionB.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
