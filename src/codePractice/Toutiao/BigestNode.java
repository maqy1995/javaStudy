package codePractice.Toutiao;

import java.util.Arrays;
import java.util.Scanner;

class Node implements Comparable{
    int x;
    int y;
    public Node(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Object o) {
        Node t = (Node)o;
        if(this.y==t.y){
            return t.x - this.x;
        }
        return t.y - this.y;
    }
}

public class BigestNode {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        Node[] input=new Node[n];
        for(int i=0;i<n;i++){
            int x =scan.nextInt();
            int y =scan.nextInt();
            input[i] =new Node(x,y);
        }
        Arrays.sort(input);
        int threshold=input[0].x;
        System.out.println(input[0].x+" "+input[0].y);
        for(int i=1;i<n;i++){
            if(input[i].x>threshold){
                System.out.println(input[i].x+" "+input[i].y);
                threshold=input[i].x;
            }
        }
    }
}
