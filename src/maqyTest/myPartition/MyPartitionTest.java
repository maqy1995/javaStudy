package maqyTest.myPartition;

import java.util.ArrayList;

public class MyPartitionTest {
    public static void main(String[] args) {
        MyPartition myPartition = MyPartition.getInstance();
        myPartition.setParallism(5);
        ArrayList a = myPartition.getChannelSplit();
        if(a==null){
            System.out.println("a is null");
        }

        MyPartition myPartition1 = MyPartition.getInstance();
        ArrayList b = new ArrayList();
        b.add(1);
        b.add(2);
        myPartition1.setChannelSplit(b);


        MyPartition myPartition2 = MyPartition.getInstance();
        ArrayList<Integer> c = myPartition1.getChannelSplit();
        for(int x :c){
            System.out.println(x);
        }

    }
}
