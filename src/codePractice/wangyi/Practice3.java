package codePractice.wangyi;

import java.util.Scanner;

/**
 * 给定一个长度为n的数字序列，对于每个k，求出长度为k的连续子序列的最大值中的最小值
 *
 * 输入：
 * 6
 * 1 3 2 4 6 5
 * 输出：
 * 1 3 3 4 6 6
 */
public class Practice3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            input[i] = sc.nextInt();
        }
        //dp[i][j]表示长度为i的，以j结尾的区间的最大值
        int[][] dp = new int[n][n];
        //初始化
        res[0] = Integer.MAX_VALUE;
        for(int k = 0; k < n; k++){
            dp[0][k] = input[k];
            res[0] = Math.min(res[0],dp[0][k]);
        }
        for(int i = 1; i < n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = i; j < n; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], input[j]);
                if(dp[i][j] < min){
                    min = dp[i][j];
                }
            }
            res[i] = min;
        }
        //输出结果
        for(int i = 0; i < n; i++){
            System.out.print(res[i]+ " ");
        }
    }
}
