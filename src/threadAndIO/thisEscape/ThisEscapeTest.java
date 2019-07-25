package threadAndIO.thisEscape;

public class ThisEscapeTest {

    public static void main(String[] args) {
        EventSource<ThisEscape.EventListener> source = new EventSource<ThisEscape.EventListener>();
        ListenerRunnable listRun = new ListenerRunnable(source);
        Thread thread = new Thread(listRun);
        thread.start();
        ThisEscape escape1 = new ThisEscape(source);

    }
}
