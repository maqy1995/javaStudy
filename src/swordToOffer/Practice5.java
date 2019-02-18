package swordToOffer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Practice5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //将node加入到队列中，是否需要判断队列满的情况呢？感觉java里不需要判断？
        //注意：为了保证队列顺序，stack2出栈，需要先判断stack2是否为空，不为空，则直接出栈，
        //如果为空，则要将stack1中的元素全部压入stack2中才能保证顺序，
        //所以当栈有大小限制时，可能无法使用所有空间，例如stack2中存在元素，然后stack1满了，还需要继续入栈，就入不了了。
        //正常应该是，入栈如果发现stack1满了，就去判断一下stack2是否为空，如果为空，就需要将stack1中的所有元素入栈stack2
        // ，从而腾出地方(前提stack2也要存的下这么多元素)
        stack1.push(node);
    }

    public int pop() {
        //先判断队列是否为空

        if(!stack2.empty()){
            //如果stack2不为空，则直接出栈即可
            return stack2.pop();
        }else if(!stack1.empty()){
            //stack2为空，但stack1不为空，则将所有stack1的元素都入栈stack2，然后对stack2出栈即可
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else {
            //stack1和stack2都为空，则说明队列为空，无法出队列
            System.out.println("队列为空，无法出队列！");
            throw new RuntimeException("Queue is empty!");
        }
    }
}
