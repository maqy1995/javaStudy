package thread;

public class HelloThread extends Thread {
    String name;
    public HelloThread(String name){
        this.name = name;
    }
    @Override
    public void run(){
        System.out.println("Hello,"+ name + "!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("GoodBye," + name + "!");
    }

}
