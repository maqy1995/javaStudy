package codePractice.wangyi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 小易有一个初始为空的数字集合，支持两种操作:
 * 1. 加入数字x到集合中
 * 2. 询问集合中是否存在一个子集，满足子集中所有数字的 Or 值恰好为k
 * 输入：
 * 9
 * 1 4
 * 2 5
 * 1 9
 * 1 15
 * 2 4
 * 1 11
 * 2 10
 * 2 7
 * 2 9
 * 输出：
 * NO
 * YES
 * NO
 * NO
 * YES
 */
public class Practice2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //存放已有的子集的or值
        HashSet<Integer> hashSet = new HashSet<Integer>();
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            if(first == 1){
                //插入数字
                //将新加入的数要加到 新的子集中
                ArrayList<Integer> newInt = new ArrayList<>();
                for (int cur : hashSet) {
                    // cur 是每个子集的数的 or 值
                    int tmp = cur | second;
                    if(!hashSet.contains(tmp)){
                        newInt.add(tmp);
                    }
                }
                for(int t : newInt){
                    hashSet.add(t);
                }
                //单独输入作为子集
                if(!hashSet.contains(second)){
                    hashSet.add(second);
                }
            }else if(first == 2){
                if(hashSet.contains(second)){
                    res.add("YES");
                }else {
                    res.add("NO");
                }
            }
        }
        for(String s : res){
            System.out.println(s);
        }
    }
}
