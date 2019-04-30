package codePractice.leetCode;

import swordToOffer.Practice2;
/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 */
public class Practice5 {
    int left=0;
    int right=0;
    int maxLength=1;
    //得到以index字符为中心的最长回文子串
    public void getLengthByIndex(String s,int index){
        int i=index-1,j=index+1;
        //如果j所在字符和当前相同，要找到一个不同的
        while(j<s.length()&&s.charAt(j)==s.charAt(index)){
            j++;
        }
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        if(j-i-1>maxLength){
            maxLength=j-i-1;
            left=i+1;
            right=j-1;
        }
    }
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length()-1;i++){
            getLengthByIndex(s,i);
        }
        System.out.println(s.substring(left,right+1));
        return s.substring(left,right+1);
    }

    public static void main(String[] args) {
        Practice5 p = new Practice5();
        p.longestPalindrome("abcdbbfcba");
    }
}
