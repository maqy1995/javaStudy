package swordToOffer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Practice20 {
    // 数据栈
    Stack<Integer> dataStack = new Stack<>();
    //辅助栈，用于存储最小值的
    Stack<Integer> auxiliaryStack = new Stack<>();

    public void push(int node) {
        //如果栈中还没有元素则直接入栈
        if (auxiliaryStack.empty()) {
            dataStack.push(node);
            auxiliaryStack.push(node);
        } else {
            if (node < auxiliaryStack.peek()) {
                //新来的值是最小值，则将这个值压入辅助栈
                auxiliaryStack.push(node);
            } else {
                //新来的值比当前栈中的最小值大，则还是压入原来的最小值
                auxiliaryStack.push(auxiliaryStack.peek());
            }
            //将新数据压入数据栈中
            dataStack.push(node);
        }
    }

    public void pop() {
        if (dataStack.empty() || auxiliaryStack.empty()) {
            throw new RuntimeException("栈为空，不能出栈");
        }
        dataStack.pop();
        auxiliaryStack.pop();
    }

    public int top() {
        if (dataStack.empty() || auxiliaryStack.empty()) {
            throw new RuntimeException("栈为空，不能出栈");
        }
        return dataStack.peek();
    }

    public int min() {
        if (dataStack.empty() || auxiliaryStack.empty()) {
            throw new RuntimeException("栈为空，不能出栈");
        }
        return auxiliaryStack.peek();
    }

}
