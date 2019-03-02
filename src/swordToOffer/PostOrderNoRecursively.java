package swordToOffer;

import java.util.Stack;

public class PostOrderNoRecursively {
    /**
     * 后序遍历是root->left,root->right,root的顺序遍历，则以root,root->right，root->left的顺序入栈
     * 对于节点p可以分情况讨论
     * 1. p如果是叶子节点，直接输出
     * 2. p如果有孩子，且孩子没有被访问过，则按照右孩子，左孩子的顺序依次入栈
     * 3. p如果有孩子，而且孩子都已经访问过，则访问p节点
     *
     * 可以通过一个last结点记录上一次访问的是哪个结点，以此判断结点的孩子是否都访问过
     * @param root
     */
    public void postOrderNoRecursively1(TreeNode root){
        //在外部判断根结点是否为null

        //辅助栈
        Stack<TreeNode> auxiliaryStack = new Stack<>();
        //将根结点放入栈中
        auxiliaryStack.push(root);
        TreeNode p = null;
        TreeNode last = null;
        while (!auxiliaryStack.empty() ){
            p = auxiliaryStack.peek();
            //此时应该访问p了
            if((p.right == null && last == p.left) || p.right == last){
                auxiliaryStack.pop();
                System.out.println(p.val);
                last = p;
            }else{
                if(p.right != null) {
                    auxiliaryStack.push(p.right);
                }
                if(p.left != null) {
                    auxiliaryStack.push(p.left);
                }
            }
        }
    }

    /**
     * 通过一种巧妙的方式，对每个结点都入栈两次，如果出栈一个元素p后，发现栈顶仍然是p，则说明该节点的孩子还没被访问过
     * @param root
     */
    public void postOrderNoRecursively2(TreeNode root) {
        //在外部判断根结点是否为null

        //辅助栈
        Stack<TreeNode> auxiliaryStack = new Stack<>();
        TreeNode p = null;
        auxiliaryStack.push(root);
        auxiliaryStack.push(root);
        while (!auxiliaryStack.empty()){
            p = auxiliaryStack.pop();
            if(p == auxiliaryStack.peek()){
                //说明孩子还没被访问
                if(p.right != null) {
                    auxiliaryStack.push(p.right);
                    auxiliaryStack.push(p.right);
                }
                if(p.left != null) {
                    auxiliaryStack.push(p.left);
                    auxiliaryStack.push(p.left);
                }
            }else {
                //此时孩子都已经访问过了，访问p
                System.out.println(p.val);
            }
        }
    }
}
