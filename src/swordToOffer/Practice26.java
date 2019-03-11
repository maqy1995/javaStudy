package swordToOffer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 回溯法？？？递归解决
 */
public class Practice26 {
    ArrayList<String> result = new ArrayList<>();
    TreeSet<String> treeSet = new TreeSet<>();//用于保证有序和去除重复数据
    StringBuilder sb = new StringBuilder();
    public void swap(char[] chars,int i,int j){
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
    //求字符数组的组合
    public void combination(char[] chars,int index, int m){
        if(m > 0){
            if( (chars.length - index) == m){
                sb.append(chars,index,chars.length-index);
                treeSet.add(sb.toString());
                sb.delete(0,sb.length());
            }else {
                //选第一个元素，然后从后面n-1个中选m-1个
                sb.append(chars[index]);
                combination(chars,index+1,m-1);
                //不选第一个元素，从后面n-1个中选m个
                combination(chars,index+1,m);
            }
        }else {
            if(sb.length() != 0){
                treeSet.add(sb.toString());
                sb.delete(0,sb.length());
            }
        }
    }
    public ArrayList<String> combination(char[] chars){
        for(int i = 1;i <= chars.length;i++){
            combination(chars,0,i);
        }
        while (!treeSet.isEmpty()){
            result.add(treeSet.pollFirst());
        }
        return result;
    }
    //求出字符数组的排列
    public void permutation(char[] chars,int index){
        if(index == chars.length-1){
            treeSet.add(new String(chars));
        }else {
            for(int i = index;i<chars.length;i++){
                swap(chars,index,i);
                permutation(chars,index+1);
                swap(chars,index,i); //恢复成原来的样子
            }
        }
    }
    public ArrayList<String> Permutation(String str) {

        if(str == null || str.length() == 0){
            return result;
        }
        char[] chars = str.toCharArray();
        permutation(chars,0);
        while (!treeSet.isEmpty()){
            result.add(treeSet.pollFirst());
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abc";
        Practice26 practice26 = new Practice26();
        ArrayList<String> result = practice26.combination(s.toCharArray());
        for(String string : result){
            System.out.println(string);
        }
    }
}
