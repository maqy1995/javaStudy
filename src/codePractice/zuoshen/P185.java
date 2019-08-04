package codePractice.zuoshen;

/**
 * 给定一个矩阵m，从左上角开始每次只能向右或者向下走，最后达到右下角的位置，
 * 路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和
 */
public class P185 {
    public static int getMinPath(int[][] input){
        int[][] aux = new int[input.length][input[0].length];
        aux[0][0] = input[0][0];
        for(int i = 0; i < aux.length; i++){
            for(int j = 0; j < aux[0].length; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                int tmp1 = Integer.MAX_VALUE, tmp2 = Integer.MAX_VALUE;
                if(i - 1 >= 0){
                    tmp1 = aux[i-1][j] + input[i][j];
                }
                if(j - 1 >= 0){
                    tmp2 = aux[i][j-1] + input[i][j];
                }
                aux[i][j] = Math.min(tmp1, tmp2);
            }
        }
        return aux[input.length - 1][input[0].length - 1];
    }
    public static void main(String[] args) {
        int[][] input = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        System.out.println(getMinPath(input));
    }
}
