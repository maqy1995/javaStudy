package swordToOffer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Practice15 {
    //可以利用递归求解
    public ListNode MergeRecursively(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }else if(list2 == null){
            return list1;
        }
        ListNode mergeHead = null;
        if(list1.val < list2.val){
            mergeHead = list1;
            mergeHead.next = MergeRecursively(list1.next, list2);
        }else {
            mergeHead = list2;
            mergeHead.next = MergeRecursively(list1, list2.next);
        }
        return mergeHead;
    }
    public ListNode Merge(ListNode list1, ListNode list2) {
        //两个链表都是空
//        if (list1 == null && list2 == null) {
//            return null;
//        }
//        //其中一个链表为空
//        if (list1 == null) {
//            return list2;
//        } else if (list2 == null) {
//            return list1;
//        }
        //上述代码太臃肿了，简化如下：
        if(list1 == null) {
            return list2;
        }else if(list2 == null){
            return list1;
        }
        //两个链表都不为空
        ListNode firstList;
        ListNode secondList;
        //将第一个节点数值小的，赋值给firstList
        if (list1.val < list2.val) {
            firstList = list1;
            secondList = list2;
        } else {
            firstList = list2;
            secondList = list1;
        }
        ListNode result = firstList;
        while (firstList.next != null && secondList.next != null) {
            if (firstList.next.val <= secondList.val) {
                firstList = firstList.next;
            } else {
                ListNode firstListNext = firstList.next;
                firstList.next = secondList;
                firstList = firstListNext;
                while (secondList.next != null && secondList.next.val <= firstListNext.val) {
                    secondList = secondList.next;
                }
                ListNode secondListNext = secondList.next;
                secondList.next = firstList;
                secondList = secondListNext;
            }
        }
        //接下来处理最后两链表的最后一个节点
        if (firstList.next == null) {
            firstList.next = secondList;
        } else if (secondList.next == null) {
            //还剩list2的最后一个节点没有处理
            while (firstList.next != null && firstList.next.val <= secondList.val) {
                firstList = firstList.next;
            }
            ListNode firstListNext = firstList.next;
            firstList.next = secondList;
            secondList.next = firstListNext;
        }
//        if(firstList.next == null && secondList != null){
//            firstList.next = secondList;
//        } else if(secondList.next == null){
//            //还剩list2的最后一个节点没有处理
//            while (firstList.next != null && firstList.next.val <= secondList.val){
//                firstList=firstList.next;
//            }
//            ListNode firstListNext = firstList.next;
//            firstList.next = secondList;
//            secondList.next=firstListNext;
//        }
        return result;
    }
}
