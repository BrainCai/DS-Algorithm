package LinkedList;

// ����һ��������ת�����������������Ԫ�ء�
public class ReverseList_v1 {
    public ListNode reverseList(ListNode head) {
        // ���head�Ƿ�Ϊnull
        if (head == null) {
            return null;
        }
        ListNode firstNode = new ListNode(-1);
        // ���ͷ���
        firstNode.next = head;// ��head.next = firstNode.next; ��firstnode.next����Ϊ��
        if (head.next != null) {
            head = head.next;
        }
        else {
            return head;
        }
        firstNode.next.next = null;// ���޴���䣬���ʹǰ������㻥ָ���ұ�����ǰִ��
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
