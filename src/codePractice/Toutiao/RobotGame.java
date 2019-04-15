package codePractice.Toutiao;

import java.util.Scanner;

public class RobotGame {
    public static boolean isEnergyEnough(int energy,int[] heights){
        for(int i=0;i<heights.length-1;i++){
            energy=energy-(heights[i]-energy);
            if(energy<=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] heights = new int[size];
        int maxInHeights=0;
        for(int i=0;i<size;i++){
            heights[i]=scanner.nextInt();
            if(heights[i]>maxInHeights){
                maxInHeights=heights[i];
            }
        }
        int start=1;
        int end=maxInHeights;
        int middle=0;
        int result=0;
        while (start<=end){
            middle=(start+end)/2;
            if(isEnergyEnough(middle,heights)){
                if(!isEnergyEnough(middle-1,heights)){
                    result=middle;
                    break;
                }
                end=middle-1;
            }else {
                start=middle+1;
            }
        }
        System.out.println(result);
    }
}
