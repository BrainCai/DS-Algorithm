package LinkedList;

/**
 * ����һ��������ת�����������������Ԫ�ء�
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