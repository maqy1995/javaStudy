package codePractice;

import java.util.Stack;

/**
 * 使用单调栈来求解数组中每个元素，左右两边比它大的边界所在位置
 */
public class MonotonicStack {
    public static void printBoundary(int[] input){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<input.length;i++){
            while(!stack.isEmpty() && input[stack.peek()] > input[i]){
                //说明栈中的元素遇到了界
                //index为当前元素
                int index = stack.pop();
                int right = i-1;
                int left = 0; // 如果栈为空的话，left就是0
                if(!stack.isEmpty()){
                    //栈不为空，则left为栈顶元素 + 1
                    // 注意，这里如果有相同元素怎么办呢？   如果是求区间，可以通过最左侧的包含进去
                    left = stack.peek() + 1;
                }
                System.out.println("index:"+index+":["+left+","+right+"]");
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            int right = input.length-1;
            int left = 0; // 如果栈为空的话，left就是0
            if(!stack.isEmpty()){
                //栈不为空，则left为栈顶元素 + 1
                // 注意，这里如果有相同元素怎么办呢？   如果是求区间，可以通过最左侧的包含进去
                left = stack.peek() + 1;
            }
            System.out.println("index:"+index+":["+left+","+right+"]");
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,1,4,7};
        printBoundary(arr);
    }
}
