package codePractice;

import java.util.*;

public class Solution {
    static int count = 0;

    public void getNumOfPairs(int[] copy,int[] array,int start,int end){
        if(start==end){
            //copy[start]=array[start];
            return;
        }
        //long count=0;
        int mid=(end-start)/2;

        getNumOfPairs(array,copy,start,start+mid);
        getNumOfPairs(array,copy,start+mid+1,end);

        int i=start+mid;
        int j=end;
        int index=end;
        while(i>=start&&j>=start+mid+1){
            if(array[i]>array[j]){
                count=count+j-mid-start;
                copy[index--]=array[i--];
                //count%=1000000007;
            }else{
                copy[index--]=array[j--];
            }
        }
        for(;i>=start;i--){
            copy[index--]=array[i];
        }
        for(;j>=start+mid+1;j--){
            copy[index--]=array[j];
        }
    }

    public void mergeSort(int[] array, int[] aux, int start, int end) {
        if(start == end){
            return;
        }
        if (start < end) {
            int mid = (end - start) / 2;
            mergeSort(aux, array, start, start + mid);
            mergeSort(aux, array, start + mid + 1, end);
            int end1 = start + mid, end2 = end, index = end;
            while (end1 >= start && end2 >= start + mid + 1) {
                if (array[end2] >= array[end1]) {
                    aux[index--] = array[end2--];
                } else {
                    count = count + (end2 - start -mid);
                    aux[index--] = array[end1--];
                }
            }
            while (end1 >= start) {
                aux[index--] = array[end1--];
            }
            while (end2 >=start + mid + 1) {
                aux[index--] = array[end2--];
            }
        }
    }

    public int InversePairs(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        int[] aux = new int[array.length]; // 辅助数组
        for (int i = 0; i < array.length; i++) {
            aux[i] = array[i];
        }
        mergeSort(array, aux, 0, array.length - 1);
        //getNumOfPairs(array,aux,0,array.length-1);
        return count;//
        //return  (int)getNumOfPairs(array,aux,0,array.length-1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        System.out.println(solution.InversePairs(input));
    }
}


