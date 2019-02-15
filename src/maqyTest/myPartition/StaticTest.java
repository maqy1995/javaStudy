package maqyTest.myPartition;

import java.util.ArrayList;

public class StaticTest {
    public static void main(String[] args) {
        StaticDemo staticDemo = new StaticDemo();
        if(staticDemo.getArrayList() == null){
            System.out.println("is null");
        }

        ArrayList b = new ArrayList();
        b.add(1);

        staticDemo.setArrayList(b);

        if(staticDemo.getArrayList() == null){
            System.out.println("is null");
        }else {
            for(Object o : staticDemo.getArrayList()){
                System.out.println(o);
            }
        }

        StaticDemo staticDemo2 = new StaticDemo();

        ArrayList c = new ArrayList();
        c.add(2);
        c.add(3);
        //staticDemo2.setArrayList(c);
        b.add(2);
        if(staticDemo2.getArrayList() == null){
            System.out.println("is null");
        }else {
            for(Object o : staticDemo.getArrayList()){
                System.out.println(o);
            }
        }
    }
}
