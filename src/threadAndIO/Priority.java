package threadAndIO;

public class Priority {
    private static volatile boolean notStart = true;
    class Job implements Runnable {

        @Override
        public void run() {
            if(notStart) {

            }
        }
    }
}
