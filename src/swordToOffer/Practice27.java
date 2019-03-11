package swordToOffer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 思路：step1.递归
 */
public class Practice27 {

    public void permutation(char[] chars, int start, int end, ArrayList<String> result){
        if(start < end){

            for(int i = start; i < end; i++) {

                permutation(chars,start+1,end,result);
            }
        }else {
            result.add(chars.toString());
        }

    }
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str == null || str.length() == 0){
            return result;
        }
        char[] string = str.toCharArray();

        HashMap hashMap = new HashMap();
        return  result;
    }
}
