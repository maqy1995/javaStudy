package codePractice.leetCode.array;

public class TrappingRainWater {
    //每次求一部分
    //start找到上升到最大的部分
    //end找到再一次的上升到最大的部分
    //然后使用一个函数来计算这之间的空隙
    public int trap(int[] height) {
        int sum=0;
        int i=0;
        while(i<height.length-1){
            if(height[i+1]>=height[i]){
                i++;
            }else{
                int j=i+1;
                //先找到低谷
                while(j<height.length&&height[j]<height[j-1]){
                    j++;
                }
                //找到高点
                while(j+1<height.length&&height[j+1]>=height[j]&&height[j]<height[i]){
                    j++;
                }
                if(j<height.length){
                    sum+=getArea(height,i,j);
                }
                i=j;
            }
        }
        return sum;
    }

    //竖着算格子
    public int getArea(int[] height,int start,int end){
        int sum=0;
        if(height[start]<=height[end]){
            int h=height[start];
            int i=start+1;
            while(i<end){
                sum+=h-height[i];
                i++;
            }
        }else{
            int h=height[end];
            int j=end-1;
            while(j>start){
                sum+=h-height[j];
                j--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        //int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] input={5,2,1,2,1,5};
        new TrappingRainWater().trap(input);
    }
}
