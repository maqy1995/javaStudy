package swordToOffer;

import java.util.Random;

public class Util {
    public static void swap(int[] num,int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    public static int partition(int[] num,int start, int end){
        //非法性检查
        if(num == null || start < 0 || end > num.length || start > end){
            throw new RuntimeException("参数有误!");
        }

        int small = start - 1;
        //得到一个(start,end)中的随机值，从而选中该次要比较的值
        int t = new Random().nextInt(end - start + 1) + start;
        //System.out.println("t:"+t);
        //将该值交换到最后
        swap(num,t,end);
        for(int i=start;i<end;i++){
            if(num[i]<num[end]){
                small++;
                if(small != i){
                    swap(num,small,i);
                }
            }
        }
        small++;
        swap(num,small,end);
        return small;

    }

    public static void main(String[] args) {
//        int[] num = {7,1,6,3,5};
////        System.out.println("index:"+partition(num,0,num.length-1));
////        for(int t : num){
////            System.out.print(t+" ");
////        }
        int n = 5;
        int sum = 1;
        while ( (n=(n & (n-1))) !=0){
            sum++;
        }
        System.out.println(sum);
    }
}
