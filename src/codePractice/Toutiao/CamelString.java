package codePractice.Toutiao;

import java.util.Random;
import java.util.Stack;

public class CamelString {
    public static String removeCamelString(String input){
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < chars.length; i++){
            if(stack.size() < 2){
                stack.push(chars[i]);
            }else {
                char right = chars[i];
                char mid = stack.pop();
                char left = stack.pop();
                if(left != mid && left == right){
                    //这两个要删除
                    stack.push(mid);
                }else {
                    stack.push(left);
                    stack.push(mid);
                    stack.push(right);
                }
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcbdadf";
        System.out.println(removeCamelString(s));
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            System.out.println(Math.random());
        }
    }
}
