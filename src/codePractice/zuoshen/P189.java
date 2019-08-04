package codePractice.zuoshen;

/**
 *  给定输入arr,arr中所有的值都为正数且不重复，每个值代表一种面值的货币，每种面值的货币
 *  可以使用任意张，再给定一个整数aim，代表要找的签署，求组成aim的最少货币数。
 */
public class P189 {
    public static int getMinNum(int[] input, int aim){
        int[] f = new int[aim + 1];
        int num = 0;
        //初始化
        for(int i = 0; i < f.length; i++){
            f[i] = Integer.MAX_VALUE;
        }
        //目标是1块
        if(aim == 0){
            return 0;
        }
        f[0] = 0;
        for(int i = 0; i < input.length; i++){
            if(input[i] < f.length){
                f[input[i]] = 1;
            }
        }
        for(int i = 1; i < f.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j< input.length; j++){
                if(i - input[j] >= 0 && f[i - input[j]] < min){
                    min = f[i - input[j]];
                }
            }
            if(min < f[i]){
                f[i] = min + 1;
            }
        }
        if(f[aim] == Integer.MAX_VALUE){
            return -1;
        }
        return f[aim];
    }

    public static void main(String[] args) {
        int[] input = {5,3};
        int aim = 6;
        System.out.println(getMinNum(input,aim));
    }
}
