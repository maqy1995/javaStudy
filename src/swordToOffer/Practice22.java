package swordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 相当于二叉树的层次遍历，使用一个队列，将左右孩子加入队列，出队列的时候进行输出
 */
public class Practice22 {
    public void levelSearch(LinkedList<TreeNode> queue,ArrayList result){
        while (!queue.isEmpty()){
            //队列非空
            TreeNode treeNode = queue.poll();
            result.add(treeNode.val);
            if(treeNode.left != null){
                queue.offer(treeNode.left);
            }
            if(treeNode.right != null){
                queue.offer(treeNode.right);
            }
        }
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> auxiliaryQueue = new LinkedList<>();

        //根节点为空，则直接返回
        if(root == null){
            return result;
        }
        auxiliaryQueue.add(root);
        levelSearch(auxiliaryQueue,result);
        return result;
    }
}
