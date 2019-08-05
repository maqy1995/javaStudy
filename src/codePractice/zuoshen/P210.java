package codePractice.zuoshen;

/**
 * 最长递增子序列
 */
public class P210 {
    //从ends中二分查找[0,right]范围内，target的位置,相同的元素则返回最左边的值
    public static int binarySerch(int[] ends, int right, int target){
        int start = 0;
        int end = right;
        while(start <= end){
            int mid = (start + end) / 2;
            if(target > ends[mid]){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        //没有return说明ends中没有
        return start;
    }
    public static int[] getDp(int[] input){
        int n = input.length;
        // dp[i]表示以input[i]结尾的最长递增子序列的长度
        int[] dp = new int[n];
        //ends[i]表示长度为i的递增子序列的最后一个数的最小值
        int[] ends = new int[n];
        //right 表示 ends当前的有效值，即当前最长递增子序列的长度
        int right = 0;
        dp[0] = 1;
        ends[0] = input[0];
        for(int i = 1; i < input.length; i++){
            //要到ends[]中二分查找，当前input[i]对应的位置
            int index = binarySerch(ends,right,input[i]);
            right = Math.max(right,index);
            ends[index] = input[i];
            dp[i] = index + 1;
        }
        int maxLen = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] > maxLen){
                maxLen = dp[i];
            }
        }
        System.out.println("最长子序列长度为："+maxLen);
        return dp;
    }

    public static int[] generatePath(int[] input, int[] dp){
        int len = 0;
        int index = 0;
        for(int i = 0; i < dp.length; i++){
            if(dp[i] > len){
                len = dp[i];
                index = i;
            }
        }
        int[] path = new int[len];
        path[--len] = input[index];
        for(int i = index - 1; i >= 0 && len >= 0; i--){
            if(dp[i] == len && input[i] < input[index]){
                path[--len] = input[i];
                index = i;
            }
        }
        return path;
    }
    public static void main(String[] args) {
        int[] input = {2,1,5,3,6,4,8,9,7};
        //System.out.println(getMaxLen(input));
        int[] dp = getDp(input);
        int[] path = generatePath(input,dp);
        for(int i = 0; i < path.length; i++){
            System.out.print(path[i]+" ");
        }
    }
}
