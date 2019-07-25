package codePractice.leetCode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * date:2019.04.17
 */
public class TwoSum {
    /**
     * 暴力解法：
     * 时间复杂度O(n^2)，空间复杂度O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        //result
        int[] result = new int[2];
        //sanity check
        if(nums==null || nums.length<2){
            return result;
        }

        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 使用空间换时间，利用hashMap存储<num[i],i>。
     * 时间复杂度O(n)，空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> hashMap= new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int complement = target-nums[i];
            if(hashMap.containsKey(complement)&&hashMap.get(complement)!=i){
                //如果hashMap中有匹配的，且不是自己
                return new int[]{hashMap.get(complement),i};
            }
            hashMap.put(nums[i],i);
        }
        throw new RuntimeException("input error");
    }
}
