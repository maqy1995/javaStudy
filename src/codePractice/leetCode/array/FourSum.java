package codePractice.leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //先排序
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int x=0,index=0;
        for(int i=0;i<nums.length-3;){
            for(int j=i+1;j<nums.length-2;){
                int low=j+1,high=nums.length-1;
                while(low<high){
                    if(nums[i]+nums[j]+nums[low]+nums[high]==target){
                        List<Integer> tmp = new ArrayList(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        result.add(tmp);
                        low++;
                        high--;
                    }else if(nums[i]+nums[j]+nums[low]+nums[high]<target){
                        low++;
                    }else{
                        high--;
                    }
                    while(low<high&&nums[low]==nums[low-1]){
                        low++;
                    }
                    while(low<high&&high<nums.length-1&&nums[high]==nums[high+1]){
                        high--;
                    }
                }
                j++;
                while(j<nums.length-1&&nums[j]==nums[j-1]){
                    j++;
                }
            }
            i++;
            while(i<nums.length-1&&nums[i]==nums[i-1]){
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum fourSum=new FourSum();
        int[] s={1,0,-1,0,-2,2};
        fourSum.fourSum(s,0);
    }
}
