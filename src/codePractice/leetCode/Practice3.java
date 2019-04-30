package codePractice.leetCode;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Practice3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars=s.toCharArray();
        LinkedList<Character> list=new LinkedList<Character>();
        int max=Integer.MIN_VALUE;
        for(char c:chars){
            int index=list.indexOf(c);
            if(index!=-1){//list中有该元素
                while (index>=0){
                    list.remove(index);
                    index--;
                }
                list.addLast(c);
            }else {
                list.addLast(c);
                if(list.size()>max){
                    max=list.size();
                }
            }
        }
        return max;
    }
}
