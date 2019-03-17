package swordToOffer;

public class Practice32 {

    public int[] copy;

    public int InversePairs(int[] array,int[] copy, int start, int end){
        if(start == end){
            copy[start] = array[start];
            return 0;
        }
        int mid = (end - start) / 2;
        int left = InversePairs(array,copy,start,start + mid);
        int right = InversePairs(array,copy,start+mid+1,end);
        int i = start+mid;
        int j = end;
        int copyIndex = end;
        int count = 0;
        while(i>=start && j >= start+mid+1){
            if(array[i] > array[j]){
                count = count + j - mid - start;
                copy[copyIndex--] = array[i--];
            }else{
                copy[copyIndex--] = array[j--];
            }
        }
        for(;i>=start;){
            copy[copyIndex--] = array[i--];
        }
        for(;j>=start+mid+1;){
            copy[copyIndex--] = array[j--];
        }
        for(i = start;i <= end;i++){
            array[i] = copy[i];
        }
        return left+right+count;
    }

    public int InversePairs(int [] array) {
        if(array.length == 0 || array == null || array.length == 1){
            return 0;
        }
        this.copy = new int[array.length];
        int count=InversePairs(array,copy,0,array.length-1);
        return count;
    }

    public static void main(String[] args) {
        Practice32 practice32 = new Practice32();
        int[] x= {1,2,3,0};
        System.out.println(practice32.InversePairs(x));
    }
}
