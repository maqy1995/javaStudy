package swordToOffer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 思路：交换左右子树即可
 */
public class Practice18 {
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode left = root.left;
        //交换左右子树
        root.left = root.right;
        root.right = left;
        Mirror(root.left);
        Mirror(root.right);
    }
}
