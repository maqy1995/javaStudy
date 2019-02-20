package swordToOffer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 思路：还是斐波拉契数列，f(n) = f(n-1) + f(n-2)
 */
public class Practice10 {
    public int RectCover(int target) {
        if(target < 0){
            throw new RuntimeException("输入非法!");
        }
        if(target == 0){
            return 0;
        }
        int[] tmp = {1,2};
        if(target <= 2){
            return tmp[target - 1];
        }
        int result = 0;
        for(int i = 3;i <= target;i++) {
            result = tmp[0] + tmp[1];
            tmp[0] = tmp[1];
            tmp[1] = result;
        }
        return result;
    }
}
