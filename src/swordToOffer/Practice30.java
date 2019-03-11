package swordToOffer;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class Practice30 {
    public int NumberOf1Between1AndN(int n){
        //得知道数是多少位的，并求出最高位的数
        if(n < 10){
            return 1;
        }
        int tmp = n;
        int exp = 0;//有多少位
        int num = 0;
        while (tmp/10 > 0){
            tmp = tmp /10;
            exp++;
        }
        int other = n - (int)Math.pow(10,exp);
        //循环完tmp就是原来n的最高位
        if(tmp > 1){
            //最高位如果大于1，则最高位是1的数有
            num = num + (int)Math.pow(10,exp);
        }else {
            //最高位是1,则最高位的数有n - (int)Math.pow(10,exp)
            num = num + other + 1;
        }
        //求除了最高位的1的数量
        num = num + tmp*(int)Math.pow(10,exp-1);

        num = num + NumberOf1Between1AndN(other);
        return num;
    }
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<=0){
            return 0;
        }
        return NumberOf1Between1AndN(n);
    }

    public static void main(String[] args) {
        Practice30 practice30 = new Practice30();
        System.out.println(practice30.NumberOf1Between1AndN_Solution(13));
    }
}
