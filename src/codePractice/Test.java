package codePractice;

import swordToOffer.TreeNode;
import swordToOffer.Utils;

import java.util.*;

public class Test {
    public static int maxDep = 0;
    public static void preview3(TreeNode node){
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(node);
        System.out.println(node.val);
        while(!linkedList.isEmpty()){
            int lastLen = linkedList.size();
            for(int i = 0; i < lastLen; i++){
                TreeNode p = linkedList.removeFirst();
                if(p.left != null){
                    linkedList.addLast(p.left);
                }
                if(p.right != null){
                    linkedList.addLast(p.right);
                }
            }
            if(!linkedList.isEmpty()){
                System.out.println(linkedList.getFirst().val);
            }
        }
    }
    public static void preview2(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        int dep = 0;
        while(node != null){
            stack.push(node);
            dep++;
            if(dep > maxDep){
                System.out.println(node.val);
                maxDep = dep;
            }
            node = node.left;
        }

        while(!stack.isEmpty()){
            TreeNode p = stack.pop();
            dep--;
            p = p.right;
            while(p != null){
                stack.push(p);
                if(dep > maxDep){
                    System.out.println(node.val);
                    maxDep = dep;
                }
                p = p.left;
            }
        }
    }
    public static void postVisit(TreeNode node){
        //非递归后续遍历
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = node;
        while(p != null){
            stack.push(p);
            p = p.left;
        }
        TreeNode lastVisit = null;
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            //右子树为空或者上次访问的节点是右孩子，才访问当前节点
            if(cur.right == null || lastVisit == cur.right){
                lastVisit = cur;
                System.out.println(cur.val);
            }else {
                //否则重新放回去，并将右孩子及其所有子节点都入栈
                stack.push(cur);
                TreeNode q = cur.right;
                while (q != null){
                    stack.push(q);
                    q = q.left;
                }
            }
        }
    }
    public static void main(String[] args) {

        TreeNode node = Utils.makeTreeDefault();
        postVisit(node);
    }
}
