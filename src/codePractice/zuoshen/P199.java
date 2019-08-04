package codePractice.zuoshen;

/**
 * 换钱的方法数
 */
public class P199 {

    public static int recur(int[] input, int index, int rest){
        int sum = 0;
        if(index == input.length){
            sum = rest == 0 ? 1 : 0;
        }else {
            //第一个循环，是表示从第i张牌选起
            //for(int i = index; i < input.length; i++){
            //k从1开始，至少得选1张
            for(int k = 0; k * input[index] <= rest; k++){
                sum += recur(input, index + 1 , rest - (k * input[index]));
            }
            //}
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] input = {5,10,25,1};
        //int[] input = {3,5};
        System.out.println(recur(input,0,15));
    }

    public static int getNum(int[] arr, int aim){
        int[] f = new int[aim + 1];
        return 0;
    }
}
