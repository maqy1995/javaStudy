package codePractice.Toutiao;

import java.util.Scanner;

public class RangeMax {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] input = new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            input[i]=scan.nextInt();
            if(input[i]>max){
                max=input[i];//得到当前输入中的最大值
            }
        }
        max=max*max;//求平方，则是1个数的最大
        //暴力解法，滑动窗口
        for(int i=2;i<=n;i++){
            int minWindow=Integer.MAX_VALUE;
            int sum=0;
            //第一个小窗口的和 + 最小值.
            for(int k=0;k<i;k++){
                sum=sum+input[k];
                if(input[k]<minWindow){
                    minWindow=input[k];
                }
            }
            int tmp = minWindow*sum;
            if(tmp>max){
                max=tmp;
            }
            //从第二个小窗口开始,可以省略一些判断
            for(int j=1;j<=n-i;j++){
                //每个小窗口的开始是j，终止是j+i-1
                sum=sum-input[j-1]+input[j+i-1]; //新的sum值
                if(input[j+i-1]<minWindow){
                    minWindow=input[j+i-1];
                }else{
                    //原来的最小值不在了，重新找
                    if(minWindow==input[j-1]){
                        minWindow=input[j+i-1];
                        for(int t=j;t<j+i-1;t++){
                            if(input[t]<minWindow){
                                minWindow=input[t];
                            }
                        }
                    }
                }
                tmp = minWindow*sum;
                if(tmp>max){
                    max=tmp;
                }
            }
        }
        System.out.println(max);
    }
}
