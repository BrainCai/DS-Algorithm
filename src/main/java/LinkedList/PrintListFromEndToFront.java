package LinkedList;


import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;


/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 
 * @author BrianCai
 */
public class PrintListFromEndToFront {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }

        return list;

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
        System.out.println("look what happend...." + printListFromTailToHead(head));
    }
}
