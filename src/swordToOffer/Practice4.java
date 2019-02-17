package swordToOffer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 *
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Practice4 {
    //考虑使用递归来完成左右子树的构建
    public TreeNode buildBinaryTree(int [] pre, int [] in,int prei, int prej, int ini, int inj){
        //递归终止条件？
        if(prei <= prej && ini <= inj){
            int key = pre[prei];
            TreeNode treeNode = new TreeNode(key);
            int i = ini;
            //i 是在中序中的位置
            for(;i <= inj;i++){
                //找到在in中的位置
                if(in[i] == key){
                    break;
                }
            }
            if(i > inj){
                System.out.println("输入的数据有误，中序中找不到前序的数！");
            }
            //进行递归处理
            treeNode.left = buildBinaryTree(pre,in,prei+1,prei+i-ini,ini,i-1);
            treeNode.right = buildBinaryTree(pre,in,prei+i-ini+1,prej,i+1,inj);

            return treeNode;
        }else {
            return null;
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length){
            return null;
        }
        TreeNode result = buildBinaryTree(pre,in,0,pre.length-1,0,in.length-1);
        return result;
    }
}
