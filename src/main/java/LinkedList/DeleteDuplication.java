package LinkedList;


import org.junit.Test;


/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留， 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        // 创建一个头结点
        ListNode firstNode = new ListNode(-1);
        // 将pHead结点赋值给头结点的下一个结点first.next
        firstNode.next = pHead;
        // 创建一个last结点,此处考察的关键点是对last进行修改，first结点是否也跟着修改
        ListNode lastNode = firstNode;
        // 外层循环控制条件，当pHead!=null&&pHead.next!=null
        while (pHead != null && pHead.next != null) {
            // 判断当前结点Val与其下个结点的Val是否相等
            if (pHead.val == pHead.next.val) {
                int dupNodeVal = pHead.val;
                while (pHead != null && pHead.val == dupNodeVal) {
                    pHead = pHead.next;
                }
                lastNode.next = pHead;
            }
            else {
                lastNode = pHead;
                pHead = pHead.next;
            }
        }
        return firstNode.next;
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
        deleteDuplication(head);
    }
}
