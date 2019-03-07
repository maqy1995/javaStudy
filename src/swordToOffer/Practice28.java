package swordToOffer;

import java.util.ArrayList;

/**
 *
 */
public class Practice28 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        //非法性检查
        ArrayList<Integer> result = new ArrayList<>();
        if(input == null || k >input.length || k<=0){
            return result;
        }

        int index = Util.partition(input,0,input.length-1);
        while (index != k-1){
            if(index>k-1){
                index = Util.partition(input,0,index);
            }else if(index < k -1){
                index = Util.partition(input,index,input.length-1);
            }
        }
        for(int i = 0;i<=index;i++){
            result.add(input[i]);
        }
        return result;
    }

}
