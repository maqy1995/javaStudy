package swordToOffer;

public class SerializeTree {
    int index=0;
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();//在这里或者在外面都行
        if(root!=null){
            sb.append(root.val+",");
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));
        }else{
            sb.append("#,");
        }
        return sb.toString();
    }
    TreeNode deserialize(String[] ss,int index){
        if(index<ss.length){
            if(ss[index].equals("#")){
                return null;
            }else{
                TreeNode node = new TreeNode(Integer.valueOf(ss[index]));
                node.left = deserialize(ss,++index);
                node.right = deserialize(ss,++index);
                return node;
            }
        }else{
            return null;
        }
    }
    TreeNode Deserialize(String str) {
        String[] ss = str.split(",");
        TreeNode node = deserialize(ss,index);
        return node;
    }

    public static void main(String[] args) {
        SerializeTree serializeTree = new SerializeTree();
        System.out.println(serializeTree.Serialize(Utils.makeTreeDefault()));
//        StringBuilder sb = new StringBuilder();
//        sb.append(11+",");
//        System.out.println(sb.toString());
    }
}
