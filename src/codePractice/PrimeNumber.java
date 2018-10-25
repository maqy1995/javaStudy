package codePractice;

import java.util.Scanner;

/**
 * 题目描述
 * 令Pi表示第i个素数。现任给两个正整数M <= N <= 10000，请输出PM到PN的所有素数。
 *
 * 输入描述:
 * 输入在一行中给出M和N，其间以空格分隔。
 *
 *
 * 输出描述:
 * 输出从PM到PN的所有素数，每10个数字占1行，其间以空格分隔，但行末不得有多余空格。
 *
 * 输入例子:
 * 5 27
 *
 * 输出例子:
 * 11 13 17 19 23 29 31 37 41 43
 * 47 53 59 61 67 71 73 79 83 89
 * 97 101 103
 */
public class PrimeNumber {
    public static void Eratosthenes(){
        //埃拉托斯特尼筛法，通过空间换时间，时间复制度为O(n*lglgn)，空间复杂度为O(n)
        int N=100000;
        boolean[] isPrime=new boolean[N+1];
        //初始化时全是素数
        for(int i=2;i<=N;i++){
            isPrime[i]=true;
        }
        for(int i=2;i<=Math.sqrt(N);i++){
            if(isPrime[i]==false){
                continue;
            }
            for(int j=i*i;j<=N;j+=i){
                isPrime[j]=false;
            }
        }
    }
    public static boolean isPrimeNumber(int x){
        for(int i=2;i<=x/2;i++){
            if(x%i==0){
                return  false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int m=0,n=0;
        Scanner scan = new Scanner(System.in);
        m=scan.nextInt();
        n=scan.nextInt();
        int num=0;
        int tag=0;
        for(int i=2;num<n;i++){
            if(isPrimeNumber(i)){
                num++;
                if(num>=m){
                    if(tag==0){
                        System.out.print(i);
                        tag++;
                    }else if(tag==9){
                        System.out.println(" "+i);
                        tag=0;
                    }else {
                        System.out.print(" "+i);
                        tag++;
                    }
                }
            }
        }

    }
}
