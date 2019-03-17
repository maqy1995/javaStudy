package swordToOffer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Practice33 {
    //利用二分查找的思想，找到第一个和最后一个然后相减

    public int getLowNum(int[] array, int start, int end, int k){
        int result = -1;
        if(start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if(array[mid] == k && mid == 0){
            return 0;
        }
        if(array[mid] >= k ){
            if(array[mid] == k && array[mid-1] < k){
                return mid;
            }else{
                result = getLowNum(array, start, mid - 1, k);
            }
        }else{
            result = getLowNum(array, mid + 1, end, k);
        }
        return result;
    }
    public int getHighNum(int[] array, int start,int end, int k){
        int result = -1;
        if(start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if(array[mid] == k && mid == array.length - 1){
            return array.length - 1;
        }
        if(array[mid] <= k ){
            if(array[mid] == k && array[mid+1] > k){
                return mid;
            }else{
                result = getHighNum(array, mid+1, end, k);
            }
        }else{
            result = getHighNum(array,start,mid-1,k);
        }
        return result;
    }
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0){
            return 0;
        }
        int end = getHighNum(array,0,array.length-1,k);
        int start = getLowNum(array,0,array.length-1,k);
        if(start == -1 || end == -1){
            return 0;
        }
        return end - start +1;
    }
}
