package swordToOffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Practice23 {
    // 思路：最后一个节点是根节点，通过根节点找到第一个比根节点大的数的位置，
    // 则由该位置分割出了左右子树，其中右子树一定都大于根节点，
    // 之后对左右子树递归判断.
    public boolean isBST(int[] sequence, int start, int end){
        boolean result = true;
        if(start < end){
            int i = start;
            while (i <= end) {
                //得到左右子树的分割点
                if(sequence[i] >= sequence[end]){
                    break;
                }
                i++;
            }
            int j = i;
            while (j < end){
                if(sequence[j] < sequence[end]){
                    result =false;
                    break;
                }
                j++;
            }
            if(result){
                result = isBST(sequence,start,i-1) && isBST(sequence,i,end-1);
            }
        }

        return result;

    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            //throw new RuntimeException("输入为空");
            return false;
        }
        return isBST(sequence,0,sequence.length-1);
    }
}
