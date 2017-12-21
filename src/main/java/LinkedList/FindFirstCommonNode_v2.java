package LinkedList;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 
 * @author BrianCai
 */
public class FindFirstCommonNode_v2 {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        List<ListNode> list = new ArrayList<>();
        while (pHead1 != null) {
            list.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (list.contains(pHead2)) {
                System.out.println(pHead2.val);
                return pHead2;
            }
            pHead2 = pHead2.next;
        }

        return null;
    }

    @Test
    public void test() {
        ListNode node7 = new ListNode(7, null);
        ListNode node6 = new ListNode(3, node7);
        ListNode node5 = new ListNode(2, node6);
        ListNode node4 = new ListNode(-2, node5);

        ListNode node1 = new ListNode(7, node5);
        ListNode head = new ListNode(1, node1);

        findFirstCommonNode(head, node4);
    }
}
