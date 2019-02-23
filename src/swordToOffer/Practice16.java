package swordToOffer;

/**
 * 输入一个整数数组，
 * 实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 要保证相对位置不变，似乎没有什么好的方法，只能类似于冒泡
 */
public class Practice16 {

    /**
     * 1.要想保证原有次序，则只能顺次移动或相邻交换。
     * 2.i从左向右遍历，找到第一个偶数。
     * 3.j从i+1开始向后找，直到找到第一个奇数。
     * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
     * 5.終止條件：j向後遍歷查找失敗。
     */
    public void reOrderArray2(int [] a) {
        if(a==null||a.length==0)
            return;
        int i = 0,j;
        while(i<a.length){
            while(i<a.length&&!isEven(a[i]))
                i++;
            j = i+1;
            while(j<a.length&&isEven(a[j]))
                j++;
            if(j<a.length){
                int tmp = a[j];
                for (int j2 = j-1; j2 >=i; j2--) {
                    a[j2+1] = a[j2];
                }
                a[i++] = tmp;
            }else{// 查找失敗
                break;
            }
        }
    }
    boolean isEven(int n){
        if((n & 1)==0)
            return true;
        return false;
    }

    public void reOrderArray(int [] array) {
        int num = 0;
        boolean hasOdd;//判断是否还有奇数，可以通过这个减少循环次数
        for (int i = 0; i < array.length;i++)
        {
            hasOdd = false;
            for (int j = array.length - 1; j>i;j--)
            {
                if (array[j] % 2 == 1 && array[j - 1]%2 == 0) //前偶后奇交换
                {
                    int t = array[j];
                    array[j] = array[j-1];
                    array[j-1] = t;
                    if(hasOdd == false){
                        hasOdd = true;
                    }
                }
                num++;
            }
            if(!hasOdd){
                break;
            }
        }
        //System.out.println("num:"+num);
    }

    public static void main(String[] args) {
        Practice16 practice13 = new Practice16();
        int[] a = {1,4,5,2,3,6,8,10};
        practice13.reOrderArray2(a);
        for(int i = 0;i < a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
