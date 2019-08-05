package codePractice;

public class NumberOfOne {
    public int numberOf1(int n){
        int sum=0;
        while(n!=0){
            if((n%10)==1){
                sum++;
            }
            n=n/10;
        }
        return sum;
    }
    public int getNumberOfOne(int start,int end){
        int sum=0;
        for(int i=start;i<=end;i++){
            sum = sum + numberOf1(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int start=1346,end=21345;
        NumberOfOne numberOfOne = new NumberOfOne();
        System.out.println(numberOfOne.getNumberOfOne(start, end));
    }
}
