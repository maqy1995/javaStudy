package swordToOffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 同样可以利用斐波那契数列的思想，设F(n)为跳上第n个台阶的跳法数量，则F(n) = F(n-1) + F(n-2)，而且F(1) = 1 , F(2) = 2;
 */
public class Practice8 {
    public int JumpFloor(int target) {
        if(target < 0) {
            throw new RuntimeException("输入有误");
        }
        if(target == 0) {
            return 0;
        }
        int[] tmp = {1, 2};
        if(target <= 2) {
            return tmp[target -1];
        }
        int result = 0;
        for(int i = 3; i <= target; i++){
            result = tmp[0] +tmp[1];
            tmp[0] = tmp[1];
            tmp[1] = result;
        }
        return result;
    }
}
