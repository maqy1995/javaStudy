package swordToOffer;

/**
 * 8皇后问题
 * 思路：先初始化一个8长度的数组，初始化数组为num[0,1,2,3,4,5,6,7]，数组下标表示每行，里面的数表示每列。
 * 例如num[0]=0,则表示第1行第1列放置了一个皇后。
 * 因为皇后不能是同一行和同一列，所以对该数组求全排列，就得到了所有可能的皇后位置判断。
 * 之后判断是否在一个对角上，判断标准为 i-j = num[i] - num[j] 或 j-i = num[i] - num[j]
 */
public class EightQueen {

    int allNum = 0;
    public void swap(int[] num, int i, int j){
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }

    public boolean isSatisfied(int[] num){
        for(int i = 0;i<num.length-1;i++){
            for(int j = i+1;j<num.length;j++){
                if(((i-j) == (num[i]-num[j])) || ((j-i) == (num[i]-num[j]))){
                    return false;
                }
            }
        }
        return true;
    }

    public void permutation(int[] num,int index){
        if(index == num.length-1){
            //找到一个全排列了
            if(isSatisfied(num)){
                allNum++;
            }
        }else {
            for(int i = index;i<num.length;i++){
                swap(num,index,i);
                permutation(num,index+1);
                swap(num,index,i); //交换回来
            }
        }
    }
    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        int[] num = {0,1,2,3,4,5,6,7};
        eightQueen.permutation(num,0);
        System.out.println(eightQueen.allNum);
    }
}
