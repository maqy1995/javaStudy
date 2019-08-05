package swordToOffer;

import java.util.ArrayList;

public class StreamMid {
    //通过构建两个堆来实现，左边为大顶堆，右边为小顶堆
    //如何保证左右两个堆的数相同，奇数的时候加入左边堆，偶数的时候加入右边堆
    //如果遇上需要插入左边时，数比右边的最小数大（堆顶），则右边的堆顶插入左边，该数插入到右边的堆中
    //如果遇上需要插入右边时，数比左边的最大值小（堆顶），则左边的堆顶插入右边，该数插入到左边的堆中
    //现在问题是，如何使用Java实现最大堆和最小堆
    class MaxHeap{
        ArrayList<Integer> heap = new ArrayList<Integer>();
        public void swap(ArrayList<Integer> heap,int i,int j){
            int t = heap.get(i);
            heap.set(i,heap.get(j));
            heap.set(j,t);
        }
        public void insert(int num){
            heap.add(num);
            int n = heap.size()-1;
            if(n>0){
                //堆中已经有元素了
                int parent = (n-1)/2;//父节点的下标
                while(parent>=0 && heap.get(parent)<heap.get(n)){
                    swap(heap,n,parent);
                    n=parent;
                    parent=(n-1)/2;
                }
            }
        }
        //插入堆顶一个数之后，进行调整
        public void modifyHeapFromHead(int index){
            int left=2*index+1;
            if(left<heap.size()){
                int right=left+1;
                if(right>=heap.size()){
                    //没有右孩子
                    if(heap.get(index)<heap.get(left)){
                        swap(heap,index,left);
                    }
                }else{
                    //左右孩子都有
                    if(heap.get(left)>heap.get(right)){
                        if(heap.get(index)<heap.get(left)){
                            swap(heap,index,left);
                            modifyHeapFromHead(left);
                        }
                    }else{
                        if(heap.get(index)<heap.get(right)){
                            swap(heap,index,right);
                            modifyHeapFromHead(right);
                        }
                    }
                }
            }
        }
        public int getMax(){
            return heap.get(0);
        }
    }
    class MinHeap{
        ArrayList<Integer> heap = new ArrayList<Integer>();
        public void swap(ArrayList<Integer> heap,int i,int j){
            int t = heap.get(i);
            heap.set(i,heap.get(j));
            heap.set(j,t);
        }
        public void insert(int num){
            heap.add(num);
            int n = heap.size()-1;
            if(n>0){
                //堆中已经有元素了
                int parent = (n-1)/2;//父节点的下标
                while(parent>=0 && heap.get(parent)>heap.get(n)){
                    swap(heap,n,parent);
                    n=parent;
                    parent=(n-1)/2;
                }
            }
        }
        //插入堆顶一个数之后，进行调整
        public void modifyHeapFromHead(int index){
            int left=2*index+1;
            if(left<heap.size()){
                int right=left+1;
                if(right>=heap.size()){
                    //没有右孩子
                    if(heap.get(index)>heap.get(left)){
                        swap(heap,index,left);
                    }
                }else{
                    //左右孩子都有
                    if(heap.get(left)>heap.get(right)){
                        if(heap.get(index)>heap.get(left)){
                            swap(heap,index,left);
                            modifyHeapFromHead(left);
                        }
                    }else{
                        if(heap.get(index)>heap.get(right)){
                            swap(heap,index,right);
                            modifyHeapFromHead(right);
                        }
                    }
                }
            }
        }
        public int getMin(){
            return heap.get(0);
        }
    }
    int curNum=0;
    MaxHeap maxHeap = new MaxHeap();
    MinHeap minHeap = new MinHeap();

    public void Insert(Integer num) {
        if(curNum%2==0){
            //应该插入到最大堆中
            if(maxHeap.heap.isEmpty()){
                maxHeap.insert(num);
            }else {
                //如果遇上需要插入左边时，数比右边的最小数大（堆顶），则右边的堆顶插入左边，该数插入到右边的堆中
                int a = minHeap.getMin();
                if(num>a){
                    maxHeap.insert(a);
                    minHeap.heap.set(0,num);
                    minHeap.modifyHeapFromHead(0);
                }else {
                    maxHeap.insert(num);
                }
            }
        }else {
            //应该插入到右边的最小堆中
            if(minHeap.heap.isEmpty()){
                //注意一种特殊情况,第二个数来的时候比第一个数小
                if(num<maxHeap.getMax()){
                    minHeap.insert(maxHeap.getMax());
                    maxHeap.heap.set(0,num);
                }else{
                    minHeap.insert(num);
                }
            }else {
                //如果遇上需要插入右边时，数比左边的最大值小（堆顶），则左边的堆顶插入右边，该数插入到左边的堆中
                int a = maxHeap.getMax();
                if(num<a){
                    minHeap.insert(a);
                    maxHeap.heap.set(0,num);
                    maxHeap.modifyHeapFromHead(0);
                }else {
                    minHeap.insert(num);
                }
            }
        }
        curNum++;
    }

    public Double GetMedian() {
        double result;
        if(curNum%2==0){
            result = (maxHeap.getMax() + minHeap.getMin())/2.0;
        }else {
            //奇数
            result =  (double)maxHeap.getMax();
        }
        return result;
    }


}
