package LinkedList;


import org.junit.Test;


/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 
 * @author BrianCai
 */
public class FindFirstCommonNode_v1 {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        while (pHead1 != null) {
            ListNode tmp = pHead2;
            while (tmp != null) {
                if (pHead1.val == tmp.val && pHead1.next == tmp.next) {
                    System.out.println(pHead1.val);
                    return pHead1;
                }
                else {
                    tmp = tmp.next;
                } ;
            }
            pHead1 = pHead1.next;
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

    @Test
    public void test1() {
        ListNode node24 = new ListNode(4, null);
        ListNode node23 = new ListNode(3, node24);
        ListNode node22 = new ListNode(9, node23);
        ListNode node21 = new ListNode(8, node22);

        ListNode node14 = new ListNode(4, null);
        ListNode node13 = new ListNode(3, node14);
        ListNode node12 = new ListNode(2, node13);
        ListNode node11 = new ListNode(1, node12);

        System.out.println(node23 == node13);

        findFirstCommonNode(node11, node21);
    }

    @Test
    public void test3() {
        ListNode node24 = new ListNode(4, null);
        ListNode node23 = new ListNode(3, node24);
        ListNode node22 = new ListNode(9, node23);
        ListNode node21 = new ListNode(8, node22);

        ListNode node14 = new ListNode(4, null);
        ListNode node13 = node23;
        ListNode node12 = new ListNode(2, node13);
        ListNode node11 = new ListNode(1, node12);

        System.out.println(node23 == node13);

        findFirstCommonNode(node11, node21);
    }
}
