package codePractice;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class Solution {
    public boolean findPath(char[] matrix, boolean[] visited, char[] str,
                            int matrixIndex, int strIndex, int rows, int cols){
        boolean res = false;
        if(strIndex == str.length){
            return true;
        }
        if(matrixIndex < 0 || matrixIndex >= matrix.length || visited[matrixIndex]){
            return false;
        }
        //访问现在这个位置
        if(matrix[matrixIndex] == str[strIndex]){
            visited[matrixIndex] = true;
            //往上走
            res = findPath(matrix,visited,str,matrixIndex-cols,strIndex+1,rows,cols);
            if(!res){
                res = findPath(matrix,visited,str,matrixIndex+cols,strIndex+1,rows,cols);//下
            }
            if(!res){
                if(matrixIndex % cols != 0){
                    res = findPath(matrix,visited,str,matrixIndex-1,strIndex+1,rows,cols);//左
                }
            }
            if(!res){
                if((matrixIndex+1) % cols != 0){
                    res = findPath(matrix,visited,str,matrixIndex+1,strIndex+1,rows,cols);//右
                }
            }
            visited[matrixIndex] = false;//重置为false
        }
        return res;
    }
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[] visited = new boolean[matrix.length];
        boolean result = false;
        for(int k=0;k<matrix.length;k++){
            result = findPath(matrix,visited,str,k,0,rows,cols);
            if(result){
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = mxBean.dumpAllThreads(false,false);
        for(ThreadInfo threadInfo : threadInfos ){
            System.out.println(threadInfo.getThreadName());
        }

//        Solution solution = new Solution();
//        ArrayList arrayList = new ArrayList();
//        String input = "ABCESFCSADEE";
//        String need = "ABCCED";
//        char[] matrix = input.toCharArray();
//        char[] str = need.toCharArray();
//        System.out.println(solution.hasPath(matrix,3,4,str));
    }
}
