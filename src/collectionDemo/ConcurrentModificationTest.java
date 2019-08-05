package collectionDemo;

import java.util.Iterator;
import java.util.LinkedList;

public class ConcurrentModificationTest {
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");

        System.out.println(strings.size());
        Iterator<String> iterator = strings.iterator();

        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
            if("d".equals(s)){
                strings.remove(s);
            }
        }
    }
}
