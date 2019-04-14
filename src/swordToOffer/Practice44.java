package swordToOffer;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 圆圈中最后剩下的数
 */
public class Practice44 {
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        for(int i = 1; i <= n; i++){
            linkedList.add(i);
        }

        Iterator iterator = linkedList.iterator();
        int i=1;
        while(linkedList.size() > 1){
            i=1;
            while (i<=m){
                if(iterator.hasNext()){
                    iterator.next();
                }else {
                    iterator = linkedList.iterator();
                    iterator.next();
                }
                i++;
            }
            iterator.remove();
        }
        return linkedList.getFirst();
    }

    public static void main(String[] args) {
        Practice44 practice44 = new Practice44();
        int x = practice44.LastRemaining_Solution(5,3);
        System.out.println(x);
    }
}
