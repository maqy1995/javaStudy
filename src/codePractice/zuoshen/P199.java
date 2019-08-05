package codePractice.zuoshen;

/**
 * 换钱的方法数
 */
public class P199 {

    public static int recur(int[] input, int index, int rest) {
        int sum = 0;
        if (index == input.length) {
            if (rest == 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            for (int k = 0; k * input[index] <= rest; k++) {
                sum += recur(input, index + 1, rest - (k * input[index]));
            }
        }
        return sum;
    }

    public static int getNum(int[] arr, int aim) {
        int[][] f = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            f[i][0] = 1;
        }
        //最后一个元素的钱数
        int lastMoney = arr[arr.length - 1];
        for(int t = 1; t * lastMoney <= aim; t++){
            f[arr.length - 1][t * lastMoney] = 1;
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = i; j <= aim; j++) {
                int tmp = f[i+1][j];
//                for (int k = 0; k * arr[i] <= j; k++) {
//                    tmp += f[i + 1][j - k * arr[i]];
//                }
                if(j - arr[i] >= 0){
                    tmp += f[i][j - arr[i]];
                }
                f[i][j] = tmp;
            }
        }
        return f[0][aim];
    }

    public static int getNum2(int[] arr, int aim) {
        int[] f = new int[aim + 1];
        f[0] = 1;
        //最后一个元素的钱数
        int lastMoney = arr[arr.length - 1];
        for(int t = 1; t * lastMoney <= aim; t++){
            f[t * lastMoney] = 1;
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = i; j <= aim; j++) {
                int tmp = f[j];
                if(j - arr[i] >= 0){
                    tmp += f[j - arr[i]];
                }
                f[j] = tmp;
            }
        }
        return f[aim];
    }

    public static void main(String[] args) {
        int[] input = {5, 10, 25, 1};
        System.out.println(recur(input, 0, 1000));
        System.out.println(getNum2(input, 1000));
    }
}
