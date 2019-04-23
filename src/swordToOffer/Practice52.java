package swordToOffer;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class Practice52 {
    public int[] multiply(int[] A) {
        if(A==null||A.length<=1){
            return A;
        }
        int[] B=new int[A.length];
        int tmp=1;
        B[0]=1;
        for(int i=1;i<=B.length-1;i++){
            B[i]=B[i-1]*A[i-1];
        }
        for(int i=B.length-1;i>0;i--){
            tmp=tmp*A[i];
            B[i-1]=B[i-1]*tmp;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A={1,2,3,4,5};
        Practice52 practice52 = new Practice52();
        int[] B=practice52.multiply(A);
        for(int x:B){
            System.out.println(x);
        }
    }
}
