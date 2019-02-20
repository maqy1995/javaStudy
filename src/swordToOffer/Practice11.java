package swordToOffer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 利用二进制求解，首先要判断是正数还是负数
 */
public class Practice11 {
    public int NumberOf1(int n) {
        int num = 0;
        int i;
        if (n != 0) {
            //正数右移高位补0
            for (i = 0; i < 32; i++) {
                if ((n & 1) == 1) {
                    ++num;
                }
                n = n >> 1;
            }
        }
        return num;
    }
}
