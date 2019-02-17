package swordToOffer;

import java.util.ArrayList;
/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Practice3 {
    //方法1，通过栈调用，而递归正好就是栈
    public void addIntegerToArray(ArrayList<Integer> arrayList, ListNode listNode){
        if(listNode.next != null){
            addIntegerToArray(arrayList, listNode.next);
        }
        arrayList.add(listNode.val);
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //先判断合法性
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(listNode == null){
            return result;
        }

        //递归添加数到ArrayList中
        addIntegerToArray(result, listNode);

        return result;
    }

    // 2. 方法2，将链表反转，然后按顺序读

    public ListNode reverseList(ListNode listNode){
        //先判断是空或者只有一个节点的情况
        if(listNode == null || listNode.next == null){
            return listNode;
        }
        ListNode p = listNode;
        ListNode q = listNode.next;
        ListNode t;
        p.next = null;
        while (q !=null){
            t = q .next;
            q.next = p;
            p = q;
            q = t;
        }
        return p;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        //先判断合法性
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(listNode == null){
            return result;
        }
        //反转链表
        ListNode newListNode = reverseList(listNode);
        //将新的链表的数按顺序加入到result中
        while(newListNode !=null){
            result.add(newListNode.val);
            newListNode = newListNode.next;
        }

        return result;
    }
}
