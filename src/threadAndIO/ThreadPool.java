package threadAndIO;

/**
 * 一个线程池需要哪些基本功能呢？
 * @author maqy
 */
public interface ThreadPool<Job extends Runnable> {

    /**
     * 执行一个Job
     */
    void execute(Job job);

    /**
     * 增加工作者线程的数量
     * @param num 增加的数量
     */
    void addWorker(int num);

    /**
     * 减少工作者线程的数量
     * @param num 减少的数量
     */
    void removeWorker(int num);

    /**
     * 关闭线程池
     */
    void shutDown();

    /**
     * 得到正在等待执行的job的数量
     * @return 等待执行的job的数量
     */
    public int getJobSize();
}
