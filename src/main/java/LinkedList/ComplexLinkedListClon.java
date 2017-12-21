package LinkedList;


import org.junit.Test;


// 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
// 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
public class ComplexLinkedListClon {
    public RandomListNode clone(RandomListNode pHead) {

        if (pHead == null) {
            return null;
        }
        RandomListNode node = new RandomListNode(pHead.label);
        node.next = pHead.next;
        node.random = pHead.random;

        pHead = pHead.next;
        RandomListNode tmp3 = node;
        while (pHead != null) {
            RandomListNode node2 = new RandomListNode(pHead.label);
            node2.next = pHead.next;
            node2.random = pHead.random;
            tmp3.next = node2;
            tmp3 = node2;
            pHead = pHead.next;
        }
        return node;
    }

    @Test
    public void test() {
        RandomListNode node6 = new RandomListNode(5, null, null);
        RandomListNode node5 = new RandomListNode(4, node6, null);
        RandomListNode node4 = new RandomListNode(4, node5, null);
        RandomListNode node3 = new RandomListNode(3, node4, null);
        RandomListNode node2 = new RandomListNode(3, node3, node6);
        RandomListNode node1 = new RandomListNode(2, node2, null);
        RandomListNode head = new RandomListNode(1, node1, node5);
        System.out.println("���½����" + clone(head).label);
    }
}
