package codePractice.leetCode;

import java.util.Arrays;

/**
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。
 *
 * 在此过程之后，我们得到一些数组 B。
 *
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 0
 * 输出：0
 * 解释：B = [1]
 * 示例 2：
 *
 * 输入：A = [0,10], K = 2
 * 输出：6
 * 解释：B = [2,8]
 * 示例 3：
 *
 * 输入：A = [1,3,6], K = 3
 * 输出：3
 * 解释：B = [4,6,3]
 */
public class Practice910 {
}
class Solution {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int res = A[A.length-1] - A[0];
        for(int i=0;i<A.length-1;i++){
            res=Math.min(res,Math.max(A[A.length-1],A[i]+2*K)-Math.min(A[i]+2*K,A[i+1]));
        }
        return res;
    }
}