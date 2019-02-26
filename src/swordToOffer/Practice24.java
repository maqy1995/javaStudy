package swordToOffer;

import java.util.*;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Practice24 {
    public void findPath(TreeNode treeNode, int target, int sum, ArrayList<ArrayList<Integer>> result, LinkedList<TreeNode> stack){
        if(treeNode != null){
            stack.add(treeNode);
            sum = sum + treeNode.val;
            if(treeNode.left == null && treeNode.right == null) {
                // 如果是叶子节点
                if(sum == target){
                    //添加一条路径
                    Iterator<TreeNode> iterator = stack.iterator();
                    ArrayList<Integer> arrayList = new ArrayList();
                    while (iterator.hasNext()){
                        arrayList.add(iterator.next().val);
                    }
                    result.add(arrayList);
                }
                TreeNode lastTreeNode = stack.removeLast();
                //sum = sum - lastTreeNode.val;
            }else {
                findPath(treeNode.left,target,sum,result,stack);
                findPath(treeNode.right,target,sum,result,stack);
                //stack.removeLast();
                TreeNode lastTreeNode = stack.removeLast();
                //sum = sum - lastTreeNode.val;
            }

        }
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        int sum = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        findPath(root,target,sum,result,stack);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return  o2.size()- o1.size();
            }
        });
        return result;
    }

}
