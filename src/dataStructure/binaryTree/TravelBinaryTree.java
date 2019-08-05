package dataStructure.binaryTree;


import swordToOffer.TreeNode;
import swordToOffer.Utils;

public class TravelBinaryTree {

    //在treeNode有左孩子的情况下，得到其前驱,即左孩子，一直往右走
    public TreeNode getPreNode(TreeNode treeNode){
        TreeNode result = treeNode.left;
        while (result.right!=null&&result.right!=treeNode){
            result = result.right;
        }
        return result;
    }

    /**
     * 不用辅助栈，不用递归，以O(1)空间复杂度，O(n)时间复杂度中序遍历二叉树
     * 时间复杂度证明，相当于每条边访问了两次
     * 思路：类似于线索二叉树，利用叶子的右孩子指向下一节点
     * @param root 根节点
     */
    public void travelInOrder(TreeNode root){
        //p是当前访问节点
        TreeNode p =root;
        while (p!=null) {
            if(p.left!=null){
                //p左孩子不为空,则找到p的前驱，将前驱的右孩子指向p
                TreeNode preNode = getPreNode(p);
                if(preNode.right==null){
                    preNode.right=p;
                    p=p.left;
                }else {
                    //前驱的右孩子是自己，说明该访问自己了
                    preNode.right=null;
                    System.out.println(p.val); //如果需要先序遍历，则将这行移动到上一个if中去
                    p=p.right;
                }
            }else {
                System.out.println(p.val);
                p=p.right;
            }
        }
    }

    /**
     * 从from节点到to节点调转
     * @param from
     * @param to
     */
    public void reverse(TreeNode from,TreeNode to){
        TreeNode p=from;
        TreeNode q=from.right;
        TreeNode r;
        while(p!=to){
            r=q.right;
            q.right=p;
            p=q;
            q=r;
        }
    }

    /**
     * 后序遍历，同样O(1)空间复杂度，O(n)时间复杂度
     * @param root
     */
    public void travelPostOrder(TreeNode root){
        TreeNode dump = new TreeNode(0);
        dump.left=root;
        TreeNode p = dump;
        while (p!=null){
            if(p.left!=null){
                TreeNode preNode=getPreNode(p);
                if(preNode.right==null){
                    preNode.right=p;
                    p=p.left;
                }else {
                    //preNode.right是p，打印p的左孩子到preNode的倒序
                    preNode.right=null;//复原
                    reverse(p.left,preNode);
                    TreeNode q=preNode;
                    while(q!=p.left){
                        System.out.println(q.val);
                        q=q.right;
                    }
                    System.out.println(q.val);
                    reverse(preNode,p.left);
                    p=p.right;
                }
            }else {
                p=p.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = Utils.makeTreeDefault();
        new TravelBinaryTree().travelPostOrder(root);
    }
}
