import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList();
        //考虑输入不合法的情况
        if (num.length < size || size <= 0) {
            return result;
        }
        //注意linkedList存储的是下标
        LinkedList<Integer> linkedList = new LinkedList();
        int i = 0;
        linkedList.addFirst(i);
        //如果size为1的滑动窗口，则第一个元素也加进去
        if (size == 1) {
            result.add(num[i]);
        }
        i++;
//        i++;
        //找到第一个最大值
//        while(i<size){
//            if(num[i]>num[linkedList.getFirst()]){
//                linkedList.removeFirst();
//                linkedList.addFirst(i);
//            }
//            i++;
//        }
//        result.add(num[linkedList.getFirst()]);
        while (i < num.length) {
            if ((i - linkedList.getFirst()) > size - 1) {
                //新加的元素已经超过该窗口了
                linkedList.removeFirst();
            }
            if (linkedList.isEmpty()) {
                linkedList.addFirst(i);
            } else if (num[i] > num[linkedList.getFirst()]) {
                linkedList.clear();
                linkedList.addFirst(i);
            } else if (num[i] > num[linkedList.getLast()]) {
                linkedList.removeLast();
                linkedList.addLast(i);
            } else {
                linkedList.addLast(i);
            }


            if (i >= size - 1) {
                result.add(num[linkedList.getFirst()]);
            }
            i++;
        }
        return result;
    }
}