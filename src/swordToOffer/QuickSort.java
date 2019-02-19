package swordToOffer;

public class QuickSort {
    public static void quickSort(int[] a, int start, int end){
        int t = 0;
        int left = start;
        int right = end;
        if(left < right && a !=null && a.length > 0){
            while (left < right){
                t = a[left];
                while (a[right] >= t && left < right){
                    right--;
                }
                if(left < right){
                    a[left] = a[right];
                    left++;
                }
                while (a[left] <= t && left < right){
                    left++;
                }
                if(left < right){
                    a[right] = a[left];
                    right--;
                }
            }
            a[left] = t;
            quickSort(a,start,left-1);
            quickSort(a,left+1,end);
        }

    }

    public static void main(String[] args) {
        int[] a = {5,4,1,3,2,1};
        quickSort(a,0,a.length-1);
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
    }
}
