package codePractice;

/**
 * 平原上，一群蜜蜂离开蜂巢采蜜，要连续采集5片花丛后归巢。
 * 已知5片花丛相对蜂巢的坐标，请你帮它们规划一下到访花丛的顺序，以使飞行总距离最短
 *
 * 例如：
 * 输入：
 * 200 0 10 200 50 200 30 200 25
 * 输出：
 * 456
 */

import java.util.Scanner;

public class Huawei2 {
    double min=10000;

    public double getTowPointD(int[] a,int[] b){
        double distance = 0;
        distance = (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
        return Math.sqrt(distance);
    }

    public void swap(int[] array,int start,int end){
        int t = array[start];
        array[start] = array[end];
        array[end] = t;
    }

    public double getArrayDistance(int[][] points,int[] array){
        double sumDistance=0;
        int[] origin={0,0};
        sumDistance=sumDistance+getTowPointD(origin,points[array[0]]);
        for(int i=0;i<points.length-1;i++){
            sumDistance = sumDistance+getTowPointD(points[array[i]],points[array[i+1]]);
        }
        sumDistance=sumDistance+getTowPointD(points[array[array.length-1]],origin);

        return sumDistance;
    }

    public void permutation(int[] array,int index,int[][] points){
        if(index == array.length-1){
            //这里就是array的一个排序了
            double t=getArrayDistance(points,array);
            if(t<min){
                min =t;
            }
        }else {
            for(int i=index;i<array.length;i++){
                swap(array,index,i);
                permutation(array,index+1,points);
                swap(array,index,i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] points = new int[5][2];
        //得到各个点的坐标
        for(int i = 0; i < 5; i++){
            points[i][0]=sc.nextInt();
            points[i][1]=sc.nextInt();
        }
        int[] array={0,1,2,3,4};
        Huawei2 huawei2 = new Huawei2();
        huawei2.permutation(array,0,points);
        //暴力计算12345的排列
        System.out.println(huawei2.min);
    }
}
