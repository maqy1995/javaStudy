package swordToOffer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 */
public class Practice7 {
    // 第一种，递归求法，速度很慢，因为递归有额外的开销，还会有重复的计算
    public int Fibonacci(int n) {
        if( n < 0) {
            throw new RuntimeException("输入有误");
        }
        if( n == 0) {
            return 0;
        }
        if( n == 1) {
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n -2);
    }

    // 第二种，用循环来求解，通过一个数组存储中间变量，避免重复运算
    public int Fibonacci2(int n) {
        if( n < 0) {
            throw new RuntimeException("输入有误");
        }
        int[] tmp = {0, 1};
        if(n <= 1){
            return tmp[n];
        }
        int result = 0;
        for(int i = 2; i <= n; i++) {
            result = tmp[0] + tmp[1];
            tmp[0] = tmp[1];
            tmp[1] = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 10;
        Practice7 practice7 = new Practice7();
        System.out.println(practice7.Fibonacci(x));
        System.out.println(practice7.Fibonacci2(x));
    }
}
