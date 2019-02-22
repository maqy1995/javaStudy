package swordToOffer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Practice13 {
    public ListNode FindKthToTail(ListNode head,int k) {
        //先进行合理性判断
        if(head == null){
            System.out.println("链表为空");
            return null;
        }
        if(k <= 0){
            if(k == 0){
                return null;
            }
            throw new RuntimeException("k为负数");
        }
        ListNode first = head;
        ListNode second = head;
        int t = 1;
        while (first.next != null){
            //first 先走k-1步，注意考虑链表中node个数不够的情况
            if(t < k){
                first = first.next;
                t++;
            }else {
                first = first.next;
                second = second.next;
            }
        }
        //判断是否够k个node
        if(t < k){
            System.out.println("链表中不足k个数");
            return null;
        }
        return second;
    }
}
