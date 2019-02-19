package swordToOffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 可以证明，在n>=2时，是2^(n-1)次方
 */
public class Practice9 {

    //利用数学来证明直接算
    public int JumpFloorII(int target) {
        if(target < 0) {
            throw new RuntimeException("非法输入！");
        }
        if(target == 0){
            return 0;
        }
        int result = 1;
        for(int i = 0; i < target - 1; i++) {
            result = result * 2;
        }
        return result;
    }

    //慢慢算
    // f(n) = f(n-1) + f(n-2) + ... + f(1) + 1;
    //      = 2 * f(n-1);
}
