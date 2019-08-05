package codePractice.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1到n的排列按字典排序，给你一个排列，假设他是第k个排列，输出倒数第k个排列
 * <p>
 * 输入：
 * 3
 * 1 2 3
 * 输出：
 * 3 2 1
 * <p>
 * 输入
 * 5
 * 3 1 5 2 4
 * 输出：
 * 3 5 1 4 2
 */
public class Practice1 {
    public static void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static ArrayList<Integer> aux = new ArrayList<>();

    public static void combination(int[] input, int start, int len) {
        if (len > 0 && start + len <= input.length) {
            //求start开始，长度为len的组合
            if (len == 1) {
                aux.add(input[start]);
                ArrayList<Integer> tmp = new ArrayList<>(aux);
                res.add(tmp);
                aux.remove(aux.size() - 1);
            }

            combination(input, start + 1, len);
            aux.add(input[start]);
            combination(input, start + 1, len - 1);
            aux.remove(aux.size() - 1);
        }
    }

    public static void combination(int[] input) {
        for (int i = 1; i <= input.length; i++) {
            combination(input, 0, i);
        }
    }

    public static void permutation(int[] input, int index) {
        if (index == input.length) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < input.length; i++) {
                tmp.add(input[i]);
            }
            res.add(tmp);
            return;
        }
        for (int i = index; i < input.length; i++) {
            swap(input, index, i);
            permutation(input, index + 1);
            swap(input, index, i);
        }
    }

    public static void combination2(int[] input, int start, int len){
        //表示从start开始选len长度的组合
        if(len > 0 && start + len <= input.length){
            if(len == 1){
                aux.add(input[start]);
                res.add(new ArrayList<>(aux));
                aux.remove(aux.size() - 1);
            }

            combination2(input, start + 1, len);
            aux.add(input[start]);
            combination2(input, start + 1, len - 1);
            aux.remove(aux.size() - 1);
        }
    }
    public static void combination2(int[] input){
        for(int i = 0; i <= input.length; i++){
            combination2(input, 0, i);
        }
    }
    public static int getI(int[] input){
        int res = -1;
        for(int i = input.length - 1; i >= 1; i--){
            if(input[i-1] < input[i]){
                res = i - 1;
                return res;
            }
        }
        return res;
    }
    public static int getJ(int[] input, int start){
        for(int i = input.length - 1; i > start; i--){
            if(input[i] > input[start]){
                return i;
            }
        }
        return -1;
    }
    public static void reverse(int[] input, int start, int end){
        while(start < end){
            int t = input[start];
            input[start] = input[end];
            input[end] = t;
            start++;end--;
        }
    }
    public static void dicOrder(int[] input){
        //将最开始的加进去
        ArrayList<Integer> tmp1 = new ArrayList<>();
        for(int k = 0; k < input.length; k++){
            tmp1.add(input[k]);
        }
        res.add(tmp1);
        //1.从右到左找到左边比右边小的位置i
        //2.从右到左找到第一个大于位置i的点
        //3.交换i，j
        //4.reverse 从i+1到最后
        int i=i = getI(input),j=0;
        while (i != -1){
            j = getJ(input, i);
            if(j == -1){
                throw new RuntimeException("出错了！");
            }
            swap(input,i,j);
            reverse(input,i+1,input.length - 1);
            //得到了一个结果
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int k = 0; k < input.length; k++){
                tmp.add(input[k]);
            }
            res.add(tmp);
            i = getI(input);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] input = new int[n];
//        for(int i = 0; i < n; i++){
//            input[i] = sc.nextInt();
//        }
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        permutation(input, 0);
        System.out.println("总个数："+res.size());
        System.out.println(res);
    }
}
