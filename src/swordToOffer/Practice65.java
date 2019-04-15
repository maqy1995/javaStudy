package swordToOffer;

import java.util.Stack;

public class Practice65 {
    //i,j处在矩阵中的位置为 cols*i+j
    public boolean findPath(char[] matrix,int rows,int cols,char[] str,int i,int j,Stack<Character> stack,boolean[] visited){
        if(i>=rows||i<0||j>=cols||j<0){
            return false;
        }
        //当前在矩阵中的位置为i,j
        //如果已经访问过，则返回false
        if(visited[cols*i+j]){
            return false;
        }
        //需要判断现在位置的字符 是不是和对应的路径字符相等
        if(matrix[cols*i+j]==str[stack.size()]){
            stack.push(matrix[cols*i+j]);//入栈
            visited[cols*i+j]=true;
            //相等，判断是否已经找完
            if(stack.size()==str.length){
                return true;
            }
            //没有找完，则从上下左右找
            boolean result=findPath(matrix,rows,cols,str,i-1,j,stack,visited)||findPath(matrix,rows,cols,str,i+1,j,stack,visited)||findPath(matrix,rows,cols,str,i,j-1,stack,visited)||findPath(matrix,rows,cols,str,i,j+1,stack,visited);
            if(result == true){
                return true;
            }else{
                //此节点不通
                stack.pop();
                visited[cols*i+j]=false;
                return false;
            }
        }
        //如果不等，则返回false
        return false;
    }
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[] visited=new boolean[matrix.length];
        boolean result = false;
        //从每个矩阵中的点开始寻找。
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //stack存储已经找到的字符
                Stack<Character> stack=new Stack();
                if(findPath(matrix,rows,cols,str,i,j,stack,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
