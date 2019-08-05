package codePractice.Toutiao;

/**
 * 有N张卡牌堆成一摞，每张卡牌上都会有一个整数标记其分数。
 * <p>
 * 现有两个人要交替从牌堆顶拿牌，每次第一个人拿1-2张，第二个人可以拿第一个人的2倍数量的卡牌
 * <p>
 * 问先拿的人最多得多少分
 * <p>
 * <p>
 * 利用动态规划做。
 * f(i,j)表示先手，从第i张开始，拿j张牌，得到的最高分
 * <p>
 * f(i,j) = max {sum[i,i+j-1]+sum[i+j, n] - max f(i+j,k)}，
 * 其中j >= 1,
 * i + j <= n
 * k <= n - (i + j) + 1
 * k 属于 [1, 2 * j]
 * <p>
 * 初始条件为f(i,n-i+1) = sum[n] - sum[i-1]
 * f(n,1) = input[n]
 */
public class PlayingCard2 {

    public static int maxScore(int[] input) {
        int n = input.length;
        int[][] f = new int[n + 1][n + 1];
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + input[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            f[i][n - i + 1] = sum[n] - sum[i - 1];
        }

        for (int i = n; i >= 1; i--) {
            for (int j = n - i; j >= 1; j--) {
                int k = 1;
                //本轮的最大值
                int max = Integer.MIN_VALUE;
                while (k <= 2 * j && k <= n - (i + j) + 1) {
                    int tmp = f[i + j][k];
                    if (tmp > max) {
                        max = tmp;
                    }
                    k++;
                }
                f[i][j] = sum[n] - sum[i - 1] - max;
            }
        }
        return Math.max(f[1][1], f[1][2]);
    }

    public static int recur(int[] input, int[] sum, int i, int j, int m, int[][][] memory) {
        //从i开始选j张牌的先手最大值
        int n = input.length;
        //如果可选的牌可以到最后一张，则全拿
        if ((i + j - 1) >= n) {
            return sum[n] - sum[i - 1];
        }
        m = Math.max(m, j);
        int tmpMax = 0;
        for (int k = 1; k <= 2 * m; k++) {
            if (i + j <= n && k <= n) {
                if (memory[i + j][k][m] != 0) {
                    tmpMax = Math.max(tmpMax, memory[i + j][k][m]);
                } else {
                    tmpMax = Math.max(tmpMax, recur(input, sum, i + j, k, m, memory));
                }
            }
        }
        memory[i][j][m] = sum[n] - sum[i - 1] - tmpMax;
        return memory[i][j][m];
    }


    public static void main(String[] args) {
        //int[] input = {0,3,-4,1,1,7};
        //int[] input = {1,1,1,1};
        //int[] input = {2,7,9,4,4};
        int[] input = {5819,9551,3626,8100,6991,4067,581,3914,895,9859,3463,4463,851,1993,6596,408,2950,5818,1433,6552,8416,837,7084,5066,1514,6417,9411,9331,5321,7705,1376,6956,6964,2371,5858,9570,6367,9973,7921,2004,8642,8935,861,3857,7807,5708,5020,4558,9641,2286,7931,9637,7542,5899,3814,491,6356,9458,9074,8037,7722,5403,7363,8774,9165,3799,7304,2596,2319,5555,3382,8311,6396,7246,2193,7019,3019,4814,6450,1934,9388,4501,909,215,1656,3799,6611,8907,739,2678,1342,8707,4648,4223,5271,5970,9702,9413,6121,3915};
        int[] sum = new int[input.length + 1];
        for (int i = 1; i <= input.length; i++) {
            sum[i] = sum[i - 1] + input[i - 1];
        }
        int[][][] memory = new int[input.length + 1][input.length + 1][input.length + 1];
        System.out.println(recur(input, sum, 1, 2,1,memory));
    }
}
