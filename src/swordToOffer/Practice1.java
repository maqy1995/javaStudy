package swordToOffer;

/**
 * 剑指offer的面试题3
 * 给定一个从左到右，从上到下的二维数组，判断目标数字是否在数组中
 */
public class Practice1 {
    public boolean Find(int target, int [][] array) {
        boolean result = false;

        //合法性判断
        if(array != null){
            //int width = array.length; //二维数组的宽度
            int width = 0; // 初始化为第一列
            int height = array.length-1; // 二维数组的高度，即最后一行
            while(width < array[0].length && height >= 0){
                // 从左下角进行判断，如果目标数比左下角的数字大，则那一列都不用判断了，如果比左下角的数字小，则那一行都不用判断了
                if(array[height][width] == target){
                    result = true;
                    break;
                }else if(array[height][width] < target){
                    ++width;
                }else {
                    --height;
                }
            }
        }
        return result;
    }
}
