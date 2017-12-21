package LinkedList;

// 输入一个链表，反转链表后，输出链表的所有元素。
public class ReverseList_v1 {
    public ListNode reverseList(ListNode head) {
        // 检查head是否为null
        if (head == null) {
            return null;
        }
        ListNode firstNode = new ListNode(-1);
        // 添加头结点
        firstNode.next = head;// 由head.next = firstNode.next; 故firstnode.next不能为空
        if (head.next != null) {
            head = head.next;
        }
        else {
            return head;
        }
        firstNode.next.next = null;// 若无此语句，则会使前两个结点互指，且必须提前执行
        ListNode tmp;
        while (head != null) {

            tmp = head.next;
            head.next = firstNode.next;
            firstNode.next = head;
            head = tmp;
        }
        return firstNode.next;
    }

}
