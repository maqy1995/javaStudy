package codePractice;

import java.util.Scanner;

/**
 * 题目描述
 * 给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
 *
 * A1 = 能被5整除的数字中所有偶数的和；
 * A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
 * A3 = 被5除后余2的数字的个数；
 * A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
 * A5 = 被5除后余4的数字中最大数字。
 *
 * 输入描述:
 * 每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N，随后给出N个不超过1000的待分类的正整数。数字间以空格分隔。
 *
 *
 * 输出描述:
 * 对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
 * 若其中某一类数字不存在，则在相应位置输出“N”。
 *
 * 输入例子:
 * 13 1 2 3 4 5 6 7 8 9 10 20 16 18
 *
 * 输出例子:
 * 30 11 2 9.7 9
 */
public class DigitalClassification {

    public static void main(String[] args) {
        int A1=0;
        int A2=0;
        int flagA2=1;
        int A3=0;
        double A4=0;
        int A4Num=0;
        int A5=0;
        int A5Max=0;
        //判断有没有符合的数，以此来决定是否输出N
        boolean tag1=false;
        boolean tag2=false;
        boolean tag3=false;
        boolean tag4=false;
        boolean tag5=false;

        Scanner scan =new Scanner(System.in);
        //得到总的数目
        int num =scan.nextInt();
        int tmp=0;
        for(int i=0;i<num;i++){
            tmp=scan.nextInt();
            if((tmp%5)==0&&(tmp%2)==0){
                A1=A1+tmp;
                tag1=true;
            }
            if((tmp%5)==1){
                A2=A2+tmp*flagA2;
                flagA2=flagA2*(-1);
                tag2=true;
            }
            if((tmp%5)==2){
                A3++;
                tag3=true;
            }
            if((tmp%5)==3){
                A4=A4+tmp;
                A4Num++;
                tag4=true;
            }
            if((tmp%5)==4){
                if(tmp>A5Max){
                    A5Max=tmp;
                    tag5=true;
                }
            }
        }
        String output="";
        if(tag1){
            output = output+A1;
        }else {
            output =output+"N";
        }

        if(tag2){
            output = output+" "+A2;
        }else {
            output =output+" "+"N";
        }
        if(tag3){
            output = output+" "+A3;
        }else {
            output =output+" "+"N";
        }

        if(tag4){
            A4=A4/A4Num;
            output = output+" "+A4;
            //output = output+" "+String.format("%.1f", A4);
        }else {
            output =output+" "+"N";
        }

        if(tag5){
            output = output+" "+A5Max;
        }else {
            output =output+" "+"N";
        }

        System.out.println(output);
    }
}
