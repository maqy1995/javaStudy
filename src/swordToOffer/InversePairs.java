package swordToOffer;

public class InversePairs {
    public int InversePairs(int [] array) {
        //特殊情况
        if(array==null||array.length<=1){
            return 0;
        }
        int[] p = new int[array.length];
        for(int i=array.length-1;i>0;i--){
            if(array[i-1]>array[i]){
                p[i-1]=p[i]+1;
            }else if(array[i-1]==array[i]){
                p[i-1]=p[i];
            }else{
                for(int j=i;j<array.length;j++){
                    if(array[i-1]>array[j]){
                        p[i-1]=p[j]+1;
                    }else if(array[i-1]==array[j]){
                        p[i-1]=p[i];
                    }
                }
            }
        }
        int result=0;
        for(int i=0;i<p.length;i++){
            result=(result+p[i]);
        }
        return result%1000000007;
    }

    public static void main(String[] args) {
        InversePairs inversePairs = new InversePairs();
        int[] a={2,3,4,5,6,7,0,1};
        System.out.println(inversePairs.InversePairs(a));

    }
}
