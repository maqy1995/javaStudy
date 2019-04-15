package swordToOffer;

public class QuickSort2 {
    public void swap(int[] num, int i, int j) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }

    public int partition(int[] num, int start, int end) {
        //用于将数组中一个元素放到正确的位置，左边的元素都将比该元素小，右边的元素都将比该元素大。最后返回元素位置
        //直接选定最后一个元素作为标志
        int lowerNum = start - 1;
        for (int i = start; i < end; i++) {
            if (num[i] <= num[end]) {
                lowerNum++;
                if (lowerNum != i) {
                    swap(num, lowerNum, i);
                }
            }
        }
        lowerNum++;
        swap(num, lowerNum, end);
        return lowerNum;
    }

    public void quickSort(int[] num,int start,int end) {
        if (start<end){
            int index = partition(num,start,end);
            quickSort(num,start,index-1);
            quickSort(num,index+1,end);
        }
    }

    public static void main(String[] args) {
        int[] num={1,2,1,3,3,4,5,2};
        QuickSort2 quickSort2 = new QuickSort2();
        quickSort2.quickSort(num,0,num.length-1);
        for(int x:num){
            System.out.print(x+" ");
        }
    }
}
