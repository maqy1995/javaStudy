package swordToOffer;

public class Practice21 {
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
        int[] pushA={1,2,3,4,5};
        int[] popA={4,5,3,2,1};
        Practice21 practice21 = new Practice21();
        System.out.println(practice21.IsPopOrder(pushA,popA));
    }
}
