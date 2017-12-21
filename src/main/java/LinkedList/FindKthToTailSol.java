package LinkedList;


import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


// 题目描述
// 输入一个链表，输出该链表中倒数第k个结点。
public class FindKthToTailSol {
    public ListNode FindKthToTail(ListNode head, int k) {

        Map<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        while (head != null) {
            map.put(index, head);
            index++ ;
            head = head.next;
        }
        if (k > index || k <= 0) {
            return null;
        }
        return map.get(index - k);
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
        System.out.println("look what happend...." + FindKthToTail(head, 8).val);
    }
}
