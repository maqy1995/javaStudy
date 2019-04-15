package swordToOffer;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Practice51 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null||numbers.length<=1||numbers.length!=length){
            return false;
        }
        int i=0;
        int t;
        while(i<numbers.length){
            if(numbers[i]!=i){
                //如果不相等，则交换过来
                if((numbers[i]==numbers[numbers[i]])||numbers[i]<i){
                    duplication[0]=numbers[i];
                    return false;
                }
                t=numbers[i];
                numbers[i]=numbers[t];
                numbers[t]=t;
            }else{
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Practice51 practice51 = new Practice51();
        int[] numbers={2,3,1,0,2,5,3};
        int [] duplication=new int[1];
        practice51.duplicate(numbers,numbers.length,duplication);
        System.out.println(duplication[0]);
    }
}
