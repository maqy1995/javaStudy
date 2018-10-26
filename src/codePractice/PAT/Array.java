package codePractice.PAT;

class Solution {
    public boolean Find(int target, int [][] array) {
        int wid = array[0].length;
        int hei = array.length;
        int i= hei-1;
        int j = 0;
        while(i>=0&&j<wid){
            if(target<array[i][j]){
                //说明该行都不可能存在这个数了
                i--;
//                if(i<0){
//                    return false;
//                }
            }
            if(target == array[i][j]){
                return true;
            }else{
                j++;
            }

        }
        return false;
    }
}

public class Array {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        Solution s=new Solution();
        int[][] x={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(s.Find(5,x));
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
