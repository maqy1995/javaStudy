package swordToOffer;

import java.util.ArrayList;

public class Practice35 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        if(sum <= 0) {
            return result;
        }
        int start = 1;
        int end = 2;
        int tmpSum = start + end;
        while(start<=(sum/2) && start < end){
            if(tmpSum == sum){
                ArrayList<Integer> tmpResult = new ArrayList();
                for(int i = start;i<=end;i++){
                    tmpResult.add(i);
                }
                result.add(tmpResult);
            }else if(tmpSum < sum){
                end = end + 1;
                tmpSum = tmpSum + end;
            }else{
                tmpSum = tmpSum - start;
                start = start + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Practice35 practice35 = new Practice35();
        practice35.FindContinuousSequence(3);
    }
}
