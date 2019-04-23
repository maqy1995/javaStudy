package codePractice;

import java.util.Scanner;

public class RobotGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] heights = new int[size];
        for(int i=0;i<heights.length;i++){
            heights[i]=scanner.nextInt();
        }
        int result=0;
        for(int i=heights.length-1;i>=0;i--){
            result=(int)((result+heights[i])/2.0+0.5);
        }
        System.out.println(result);
    }
}
