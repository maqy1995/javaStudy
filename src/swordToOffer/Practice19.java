package swordToOffer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Practice19 {
    public void printOuter(int[][] matrix, int starti, int endi, int startj, int endj, ArrayList<Integer> arrayList){
        if(starti > endi || startj > endj) {
            return;
        }
        //输出第一行
        for(int j = startj; j <= endj; j++){
            arrayList.add(matrix[starti][j]);
        }
        //输出最后一列
        for(int i = starti + 1; i <= endi ; i++){
            arrayList.add(matrix[i][endj]);
        }
        //输出最后一行,如果只有一行则不输出
        if(starti < endi){
            for(int j = endj -1; j >= startj ; j--){
                arrayList.add(matrix[endi][j]);
            }
        }
        //输出第一列，注意这里[0][0]已经输出过了，如果只有一列也不输出
        if(startj < endj){
            for(int i = endi - 1; i > starti ; i--){
                arrayList.add(matrix[i][startj]);
            }
        }
        printOuter(matrix,starti+1,endi-1,startj+1,endj-1,arrayList);
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if(matrix == null){
            return result;
        }
        printOuter(matrix,0,matrix.length-1,0,matrix[0].length-1,result);
        return result;
    }
}
