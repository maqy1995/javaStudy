package swordToOffer;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * //思路：利用中序遍历
 */
public class Practice25 {
    TreeNode staticlastNode = null;
    //使用递归
    public void inOrderRecursively(TreeNode treeNode){

        if(treeNode.left !=null){
            inOrderRecursively(treeNode.left);
        }
        if(staticlastNode == null){
            //说明是到了头节点
            staticlastNode = treeNode;
        }else {
            treeNode.left=staticlastNode;
            staticlastNode.right=treeNode;
            staticlastNode=treeNode;
        }
        if(treeNode.right != null){
            inOrderRecursively(treeNode.right);
        }

    }
    //非递归的中序遍历，利用栈，出栈的时候访问(如果是先序则是入栈的时候访问)
    public TreeNode inOrder(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode head = null;
        TreeNode p = root;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        //stack.push(p);
        boolean isFirst = true;
        while (!stack.empty() || p!=null){
            //先将左孩子全部入栈
            while (p!=null){
                stack.push(p);
                p = p.left;
            }
            //出栈的时候访问
            p = stack.pop();
            if(isFirst){
                head = p;
                isFirst = false;
                pre = p;
            }else {
                pre.right=p;
                p.left=pre;
                pre=p;
            }
            //访问p
            System.out.println(p.val);
            p=p.right;
        }
        return head;
    }

    public static void main(String[] args) {
        Practice25 practice25 = new Practice25();
        TreeNode root = Utils.makeTreeDefault();
        TreeNode head =practice25.Convert(root);
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        TreeNode head = pRootOfTree;
        while (head.left!=null){
            head=head.left;
        }
        inOrderRecursively(pRootOfTree);
        return head;
    }

}
