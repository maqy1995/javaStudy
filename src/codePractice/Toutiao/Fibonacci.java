package codePractice.Toutiao;

public class Fibonacci {
    public static int function(int n){
        int sum=0;
        if(n==1){
            return 1;
        }
        if(n<6){
            int i=n-1;
            while(i>0){
                sum+=function(i--);
            }
            sum++;
        }else {
            for(int i=6;i>0;i--){
                sum += function(n-i);
            }
        }
        return sum;
    }

    public static int function2(int n,int size){
        int[] aux = new int[size];
        aux[0]=1;
        for(int i=1;i<aux.length;i++){
            for(int j=i-1;j>=0;j--){
                aux[i]+=aux[j];
            }
            aux[i]=aux[i]+1;//前size个都需要+1,因为可以一步到位
        }
        if(n<size){
            return aux[n];
        }
        for(int i=size;i<n;i++){//注意数组是从0开始的
            int sum=0;
            for(int j=0;j<size;j++){
                sum+=aux[j];
            }
            for(int k=1;k<size;k++){
                //更新数组中的值
                aux[k-1]=aux[k];
            }
            aux[size-1]=sum;
        }
        return aux[size-1];
    }

    public static void main(String[] args) {
        System.out.println(function2(16,6));
        System.out.println(function(16));
    }
}
