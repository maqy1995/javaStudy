package swordToOffer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Practice21 {
    //使用一个辅助栈来完成这个功能
    //具体思路，从出栈数组的第一个元素开始，如果不等于入栈的第一个元素，则将元素入栈直到等于，并将该元素出栈
    //判断下一个出栈元素是否与辅助栈中的栈顶元素相等，如果不相等，则继续入栈，如果没有相等的，则返回false.
    Stack<Integer> auxiliaryStack = new Stack<>();
    public boolean IsPopOrderByAuxiliaryStack(int [] pushA,int [] popA) {
        boolean result = true;
        if(pushA == null || popA == null || pushA.length != popA.length){
            throw new RuntimeException("输入有误");
        }
        int i =0,j=0;
        while (i < popA.length){
            //如果辅助栈为空，则入栈一个元素
            if(auxiliaryStack.empty()){
                auxiliaryStack.push(pushA[j]);
                j++;
            }
            if(popA[i]!=auxiliaryStack.peek()){
                //如果辅助栈顶元素和出栈数组不等，则继续入栈
                if(j<pushA.length){
                    auxiliaryStack.push(pushA[j]);
                    j++;
                }else {
                    result = false;
                    break;
                }
            }else {
                //相等,则i+1并且辅助数组出栈一个元素
                i++;
                auxiliaryStack.pop();
            }
        }

        return result;


    }

    public boolean isRightOrder(int[] pushA,int[] popA,int pushAi,int popAi){

        int i =pushAi;int j=popAi;
        while (i >=0  && j < popA.length){
            if(pushA[i] != popA[j]){
                j++;
            }else {
                i--;
                j++;
            }
        }
        if(i != 0&& j!=popA.length){
            return false;
        }else {
            return true;
        }

    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null || pushA.length!= popA.length){
            throw new RuntimeException("输入有误");
        }
        boolean result = true;
        //思路：遍历出栈的顺序，对每个出栈的元素A，在入栈里面找到它，然后比较在A之前入栈的元素的出栈顺序是否正常。
        int pushAi;int popAi;
        for(popAi = 0; popAi < popA.length; popAi++) {
            for(pushAi = 0; pushAi < pushA.length; pushAi++) {
                //在入栈的数组中找到对应元素
                if(popA[popAi] == pushA[pushAi]){
                    break;
                }
            }
            if(pushAi >= pushA.length){
                //在入栈的数组里没有对应元素
                //throw new RuntimeException("输入有误");
                return false;
            }
            result = isRightOrder(pushA,popA,pushAi,popAi);
            if(result == false){
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] pushA={1,2,3,4,5};
//        int[] popA={4,5,3,2,1};
//        Practice21 practice21 = new Practice21();
//        System.out.println(practice21.IsPopOrder(pushA,popA));

    }
}
