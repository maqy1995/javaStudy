package swordToOffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Practice6 {
    //思路：利用前半段和后半段都有序的特定，进行二分查找，减少每次搜索的空间，还要考虑特殊情况
    public int searchOrder(int[] array, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            //找到一个数比之前的小，则一定是最小值
            if (array[i] < array[i - 1]) {
                return i;
            }
        }
        //否则数都是一样大的
        return start;
    }

    public int minNumberInRotateArray(int[] array) {
        //判断是否合法
        if (array == null) {
            throw new RuntimeException("数组为空");
        }
        //长度为0返回0
        if (array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int mid = start;//mid初始化为start，因为如果没有被旋转过，则start位置的元素就是最小值
        //没有被旋转过的情况
//        if (array[start] < array[end]) {
//            return array[mid];
//        }
        while (array[start] >= array[end]) {
            //终止条件，说明到了交界处
            if ((end - start) == 1) {
                mid = end;
                break;
            }
            mid = (start + end) / 2;
            //考虑特殊情况，array[start]、array[end]、和array[mid]都相等时无法减少搜索空间，只能顺序查找。
            if (array[start] == array[end] && array[start] == array[mid]) {
                //进行顺序查找
                mid = searchOrder(array, start, end);
                break;
            }

            //根据情况调整搜索空间
            if (array[mid] >= array[start]) {
                start = mid;
            }else if (array[mid] <= array[end]) {
                end = mid;
            }
        }

        return array[mid];
    }
}
