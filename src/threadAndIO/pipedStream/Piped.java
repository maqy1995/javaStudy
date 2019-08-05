package threadAndIO.pipedStream;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {
    static class Print implements Runnable{
        PipedReader in;

        public Print(PipedReader in){
            this.in = in;
        }
        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1){
                    System.out.print((char)receive);
                }
            }catch (IOException e){
                System.out.println(e);
            }

        }
    }
    public static void main(String[] args) throws IOException {
        PipedReader in = new PipedReader();
        PipedWriter out = new PipedWriter();
        in.connect(out);

        Thread thread = new Thread(new Print(in));
        thread.start();

        int receive = 0;
        try {
            while((receive = System.in.read()) != -1){
                out.write(receive);
            }
        }finally {
            out.close();
        }
    }
}
