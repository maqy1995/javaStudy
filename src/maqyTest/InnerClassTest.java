package maqyTest;

public class InnerClassTest {
    static{
        System.out.println("static outer");
    }

    static class Inner1{
        static{
            System.out.println("static inner");
        }
        public Inner1(){
            System.out.println("Inner1 Construct");
        }
        public void t(){
            System.out.println("yes");
        }
    }

    public static void main(String[] args) {
        new InnerClassTest();
    }
}
