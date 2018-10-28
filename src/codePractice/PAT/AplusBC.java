package codePractice.PAT;

import java.util.Scanner;

public class AplusBC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num=Integer.parseInt(scan.nextLine());
        boolean b=false;
        for(int i=0;i<num;i++){
            String line = scan.nextLine();
            String[] split = line.split(" ");
            long A = Long.parseLong(split[0]);
            long B = Long.parseLong(split[1]);
            long C = Long.parseLong(split[2]);
//            int A = Integer.parseInt(split[0]);
//            int B = Integer.parseInt(split[1]);
//            int C = Integer.parseInt(split[2]);
            if((A+B)>C){
                b=true;
            }
            if(A>0&&B>0){
                if((A+B)<A){
                    b=true;
                }
            }
            if(A<0&&B<0){
                if((A+B)>A){
                    b=false;
                }
            }
            System.out.println("Case #"+(i+1)+": "+b);
        }
    }
}
