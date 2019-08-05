package codePractice.Toutiao;

import java.util.LinkedList;

public class Travel {
    public static void getNum(LinkedList<Integer> input){
        if(input.size() == 1){
            System.out.println(input.getFirst());
            return;
        }
        int first = input.removeFirst();
        int second = input.removeFirst();
        input.addLast(second);
        System.out.println(first);
        getNum(input);
    }
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for(int i = 0; i < input.length; i++){
            linkedList.addLast(input[i]);
        }
        getNum(linkedList);
    }
}
