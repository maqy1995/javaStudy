package codePractice;

/**
 * 输入：
 * 2
 * 0abcdefgh1abcdefgh
 *
 * 输出：
 * hgfedcba abcdefgh
 */

import java.util.Scanner;

public class Huawei1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();
        char[] chars = line.toCharArray();
        int i=0;

        while(i<chars.length-1){
            StringBuilder s = new StringBuilder();
            if(chars[i]=='1'){
                for(int j=1;j<=8;j++){
                    s.append(chars[i+j]);
                }
                System.out.print(s);

            }else if(chars[i]=='0'){
                for(int j=1;j<=8;j++){
                    s.append(chars[i+j]);
                }
                s.reverse();
                System.out.print(s);

            }
            i=i+9;
            if(i<chars.length-1){
                System.out.print(" ");
            }
        }
    }
}
