package LinkedList;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class ReverseList_v2 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = null;
        ListNode pNode = head;
        ListNode pPrev = null;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            if (pNext == null) newHead = pNode;
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return newHead;
    }

}