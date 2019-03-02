package swordToOffer;

public class Utils {
    //作用：根据数组，创建一颗二叉树，null值用#代替
    public static TreeNode makeTree(char[] order){
        if(order == null || order.length == 0){
            throw new RuntimeException("输入数组为null或空!");
        }

        TreeNode root = null;
        TreeNode[] treeNodes=new TreeNode[order.length];
        for(int i=0;i<order.length;i++){
            treeNodes[i]=new TreeNode(order[i]);
        }
        for(int i=0;i<order.length/2+1;i++){
            if(((i+1)*2-1)<order.length){
                if(treeNodes[((i+1)*2-1)].val != '#'){
                    treeNodes[i].left = treeNodes[((i+1)*2-1)];
                }
            }
            if(((i+1)*2)<order.length){
                if(treeNodes[((i+1)*2-1)].val != '#'){
                    treeNodes[i].right = treeNodes[((i+1)*2)];
                }
            }
        }
        return treeNodes[0];
    }

    /**
     *        10
     *     6     14
     *   4  8  12  16
     * @return
     */
    public static TreeNode makeTreeDefault(){
        char[] t = {10,6,14,4,8,12,16};
        return  makeTree(t);
    }
    public static void main(String[] args) {
        char[] a = new char[0];
        if(a.length == 0){
            System.out.println("yes");
        }
    }
}
