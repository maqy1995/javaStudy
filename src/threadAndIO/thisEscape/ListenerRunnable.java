package threadAndIO.thisEscape;

import java.util.List;

public class ListenerRunnable implements Runnable {

    private EventSource<ThisEscape.EventListener> source;
    public ListenerRunnable(EventSource<ThisEscape.EventListener> source) {
        this.source = source;
    }
    @Override
    public void run() {
        List<ThisEscape.EventListener> listeners = null;

        try {
            listeners = this.source.retrieveListeners();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for(ThisEscape.EventListener listener : listeners) {
            listener.onEvent(new Object());
        }
    }

}
