package swordToOffer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 思路：先遍历tree1，找到和root2相同的节点，然后通过一个递归来判断是否相等
 */
public class Practice17 {
    public boolean isSame(TreeNode treeNode1,TreeNode treeNode2){
        //如果都为空返回true，如果一方为空一方不为空，则返回false
        if(treeNode1 == null || treeNode2 == null){
            if(treeNode1 == null && treeNode2 == null){
                return true;
            }else {
                return false;
            }
        }
        if(treeNode1.val != treeNode2.val){
            return false;
        }
        //进行递归判断，左右子树都是就相等
        return isSame(treeNode1.left,treeNode2.left)&&isSame(treeNode1.right,treeNode2.right);
    }

    public boolean preOrder(TreeNode treeNode,TreeNode root2){
        //遍历树1的每个node，进行判断
        boolean result = false;
        if(treeNode != null){
            if(treeNode.val == root2.val){
                //如果找到了相同的
                result = isSame(treeNode,root2);
            }
            if(result == false){
                result= (preOrder(treeNode.left,root2) || preOrder(treeNode.right,root2));
            }
        }
        return result;
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //如果根节点有一方为空则返回false
        if(root2 == null){
            return false;
        }
        if(root1 == null){
            return false;
        }
        return preOrder(root1,root2);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        TreeNode left1 = new TreeNode(8);
        TreeNode right1 = new TreeNode(7);
        TreeNode left2 = new TreeNode(9);
        TreeNode right2 = new TreeNode(2);
        root1.left = left1; root1.right = right1;
        left1.left =left2;
        left1.right = right2;

        TreeNode left23 = new TreeNode(4);
        TreeNode right23 = new TreeNode(7);
        right2.left = left23;
        right2.right= right23;

        TreeNode root2 = new TreeNode(8);
        TreeNode left11 = new TreeNode(9);
        TreeNode right11 = new TreeNode(2);
        root2.left = left11;
        root2.right = right11;

        Practice17 practice17 = new Practice17();
        System.out.println(practice17.HasSubtree(root1,root2));
    }
}
