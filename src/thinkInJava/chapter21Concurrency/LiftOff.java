package thinkInJava.chapter21Concurrency;

public class LiftOff implements Runnable{
    /**
     * default num
     */
    protected int countDown = 10;
    private static int taskCount = 1;
    private final int id = taskCount++;

    public LiftOff(){}

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "),";
    }

    @Override
    public void run() {
        while(countDown-- > 0){
            System.out.print(status());
            Thread.yield();
        }
    }
}
