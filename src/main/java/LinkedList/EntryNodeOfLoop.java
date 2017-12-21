package LinkedList;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


// 一个链表中包含环，请找出该链表的环的入口结点。
public class EntryNodeOfLoop {
    public ListNode entryNodeOfLoop(ListNode pHead) {
        // 错误原因是：当出现重复元素时，不能作为环
        // List<Integer> list = new ArrayList<>();
        List<ListNode> list = new ArrayList<>();
        while (pHead != null) {
            if (list.contains(pHead)) {
                return pHead;
            }
            else {
                list.add(pHead);
                pHead = pHead.next;
            }
        }
        return null;

    }

    @Test
    public void test() {
        ListNode node6 = new ListNode(5, null);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);
        entryNodeOfLoop(head);
    }
}
