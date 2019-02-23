package swordToOffer;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Practice14 {
    public ListNode ReverseList(ListNode head) {
        //先判断head是否为空
        if(head == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = first.next;
        //如果链表中只有一个节点
        if(second == null) {
            return first;
        }
        //链表中的节点大于等于2
        //先把first.next置为空
        first.next = null;
        ListNode t;
        while(second != null) {
            t = second.next;
            second.next = first;
            first = second;
            second = t;
        }
        //结束后，first则是新的头节点
        return first;
    }
}
