package LinkedList;


import org.junit.Test;


// 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
public class MergeList {
    public ListNode Merge(ListNode list1, ListNode list2) {

        ListNode firstNode = null;
        ListNode tmp = null;

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (firstNode == null) {
                    firstNode = tmp = list1;
                }
                else {
                    tmp.next = list1;
                    tmp = tmp.next;
                }
                list1 = list1.next;
            }
            else {
                if (firstNode == null) {
                    firstNode = tmp = list2;
                }
                else {
                    tmp.next = list2;
                    tmp = tmp.next;
                }
                list2 = list2.next;
            }

        }
        if (list1 == null) {
            tmp.next = list2;
        }
        else {
            tmp.next = list1;
        }

        return firstNode;

    }

    @Test
    public void test() {
        ListNode node6 = new ListNode(56, null);
        ListNode node5 = new ListNode(23, node6);
        ListNode node4 = new ListNode(18, node5);
        ListNode node3 = new ListNode(9, node4);
        ListNode node2 = new ListNode(8, node3);
        ListNode node1 = new ListNode(5, node2);
        ListNode head = new ListNode(1, node1);

        ListNode node7 = new ListNode(19, null);
        ListNode node8 = new ListNode(17, node7);
        ListNode node9 = new ListNode(16, node8);
        ListNode node10 = new ListNode(14, node9);
        ListNode node11 = new ListNode(12, node10);
        ListNode node12 = new ListNode(10, node11);
        ListNode head1 = new ListNode(0, node12);

        ListNode firstNode = Merge(head, head1);
        while (firstNode != null) {

            System.out.println(firstNode.val);
            firstNode = firstNode.next;
        }
    }
}
