package codePractice.zuoshen;

/**
 * 最长递增子序列
 */
public class P210 {
    public static int getMaxSub1(int[] input){
        //dp[i]表示以i结尾的最长子序列的长度
        int maxLen = 0;
        int[] dp = new int[input.length];
        int[] path = new int[input.length]; //存储前一个节点的位置
        for(int i=0;i<path.length;i++){
            path[i] = -1;//初始化path
        }
        dp[0] = 1;
        for(int i =1;i<dp.length;i++){
            int tmpMax = 1;
            for(int j = i-1;j>=0;j--){
                if(input[i] > input[j]){
                    if(dp[j] + 1 > tmpMax){
                        tmpMax = dp[j] + 1;
                        path[i] = j;
                    }
                }
            }
            dp[i] = tmpMax;
        }
        int maxLenIndex = -1;
        for(int i = 0 ;i< dp.length;i++){
            if(dp[i] > maxLen){
                maxLen = dp[i];
                maxLenIndex = i;
            }
        }
        while(maxLenIndex != -1){
            System.out.print(input[maxLenIndex] + " ");
            maxLenIndex = path[maxLenIndex];
        }
        System.out.println();
        return maxLen;
    }

    public static void main(String[] args) {
        int[] input = {2,1,5,3,6,4,8,9,7};
        System.out.println(getMaxSub1(input));
    }
}
