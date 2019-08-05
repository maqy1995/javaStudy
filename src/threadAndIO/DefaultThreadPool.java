package threadAndIO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 默认线程池
 *
 * @param <Job> 提交的作业
 * @author maqy
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    private static final int MIN_WORKER_NUM = 1;
    private static final int MAX_WORKER_NUM = 10;
    private static final int DEFAULT_WORKER_NUM = 5;

    //一个线程安全的存储Job的LinkedList
    private LinkedList<Job> jobs = new LinkedList<Job>();

    private List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    //工作者线程的数量
    private int workerNum = DEFAULT_WORKER_NUM;

    //线程编号生成
    private AtomicInteger threadNum = new AtomicInteger();

    public DefaultThreadPool(){
        initializeWorkers(DEFAULT_WORKER_NUM);
    }

    public DefaultThreadPool(int workerNum){
        int trueWorkerNum = workerNum;
        if(workerNum < MIN_WORKER_NUM){
            trueWorkerNum = MIN_WORKER_NUM;
        }else if(workerNum > MAX_WORKER_NUM){
            trueWorkerNum = MAX_WORKER_NUM;
        }
        initializeWorkers(trueWorkerNum);
    }

    public void initializeWorkers(int workerNum) {
        for (int i = 0; i < workerNum; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker,"Default_ThreadPool_worker-"+threadNum.incrementAndGet());
            thread.start();
        }
    }

    @Override
    public void execute(Job job) {
        if(job != null){
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void addWorker(int num) {

    }

    @Override
    public void removeWorker(int num) {

    }

    @Override
    public void shutDown() {

    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    //Worker是用来真正干活的
    class Worker implements Runnable{
        //是否工作的标志位，注意需要是volatile修饰的
        private volatile boolean running = true;
        @Override
        public void run() {
            while (running){
                Job job = null;
                synchronized(jobs){
                    while (jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            // 感知到外部对WorkerThread的中断操作，返回
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    //取出一个job
                    job = jobs.removeFirst();
                }
                if(job != null){
                    try {
                        job.run();
                    }catch (Exception ex){
                        //忽略Job执行中的异常
                    }
                }
            }
        }

        public void shutDown(){
            this.running = false;
        }
    }
}
