package collectionTest;

import java.util.ArrayList;
import java.util.List;

public class CollectionsTest  {
    public static void main(String[] args) {
//        LinkedHashMap<Integer,Integer> s = new LinkedHashMap<Integer, Integer>();
//        s.put(1,3);
//        s.put(3,5);
//        s.put(2,4);
//        for(Map.Entry<Integer,Integer> m: s.entrySet()) {
//            System.out.println(m.getKey());
//        }
        List<Integer> list=new ArrayList<Integer>();
        List<Integer> t = new ArrayList<Integer>(list);
        t.add(1);
        t.add(2);
        for(int x:t){
            System.out.println(x);
        }
        System.out.println(t.size());
        t.remove(t.size()-1);
        for(int x:t){
            System.out.println(x);
        }
        List<List<Integer>> result=new ArrayList<List<Integer>>();
    }
}
