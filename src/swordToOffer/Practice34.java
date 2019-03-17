package swordToOffer;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Practice34 {
    //思路：利用上一题的求二叉树的深度来求解。
    //在判断左右子树的基础上，来判断是否是平衡二叉树，但是这个有一个缺点，就是需要整棵树都遍历完
    //可以考虑改进方法，从底往上
    int num = 0;
    public boolean isBalance = true;
    public int getTreeNodeDepth1(TreeNode treeRoot){
        num++;
        if(treeRoot == null){
            return 0;
        }
        int left = getTreeNodeDepth1(treeRoot.left);
        int right = getTreeNodeDepth1(treeRoot.right);
        if(left - right > 1 || left - right < -1){
            isBalance = false;
        }
        return  left > right ? left + 1 : right + 1;
    }


    public boolean IsBalanced_Solution(TreeNode root) {
        getTreeNodeDepth1(root);
        System.out.println(num);
        return isBalance;
    }
    public int getTreeNodeDepth(TreeNode treeRoot){
        if(isBalance){
            num++;
            if(treeRoot == null){
                return 0;
            }
            int left = getTreeNodeDepth(treeRoot.left);
            if(isBalance){
                int right = getTreeNodeDepth(treeRoot.right);
                if(left - right > 1 || left - right < -1){
                    isBalance = false;
                }
                return left > right ? left + 1 : right + 1;
            }else{
                return -1;
            }
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Practice34 practice34 = new Practice34();
        TreeNode root = Utils.makeTreeDefault();
        practice34.IsBalanced_Solution1(root);
    }
    public boolean IsBalanced_Solution1(TreeNode root) {
        int t = getDepth(root);
        System.out.println(num);
        if(t == -1){
            return false;
        }else {
            return true;
        }
    }

    private int getDepth(TreeNode root) {
        num++;
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
