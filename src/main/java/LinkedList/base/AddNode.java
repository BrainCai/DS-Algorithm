package LinkedList.base;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import LinkedList.ListNode;


/**
 * 在已存在链表添加结点
 *
 * @author BrianCai
 * @version 2017年12月26日
 * @see AddNode
 * @since
 */
public class AddNode {

    /**
     * Description:添加单个结点
     * 
     * @param head
     * @param node
     * @return ListNode
     * @see
     */
    public void addOneNode(ListNode head, ListNode node) {

        if (head == null) {
            return;
        }
        head.next = node;
    }

    /**
     * Description:批量添加多个结点 head 添加一个临时引用(刷完题的直接感觉就是添加一个临时引用) 注意此处函数依然不需要返回值，即可实现
     * 
     * @param head
     * @param nodeList
     * @return ListNode
     * @see
     */
    public void addNNode_1(ListNode head, List<ListNode> nodeList) {

        if (head == null || nodeList == null || nodeList.size() <= 0) {
            return;
        }
        // 此处是关键处
        ListNode tmp = head;
        for (ListNode listNode : nodeList) {
            tmp.next = listNode;
            tmp = listNode;
        }

    }

    /**
     * Description: 意外发现，删除临时引用依然可以实现该算法。这个也很好解释，利用我们之前所述
     * 
     * @param head
     * @param nodeList
     *            void
     * @see
     */
    public void addNNode_2(ListNode head, List<ListNode> nodeList) {

        if (head == null || nodeList == null || nodeList.size() <= 0) {
            return;
        }
        for (ListNode listNode : nodeList) {
            head.next = listNode;
            head = listNode;
        }

    }

    @Test
    public void test_1() {
        ListNode node1 = new ListNode(2, null);
        ListNode head = new ListNode(1, null);
        addOneNode(head, node1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    @Test
    public void test_2() {
        ArrayList<ListNode> nodeList = new ArrayList<>();
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, null);
        ListNode node1 = new ListNode(1, null);
        ListNode head = new ListNode(0, null);
        nodeList.add(node1);
        nodeList.add(node2);
        nodeList.add(node3);
        addNNode_1(head, nodeList);
        while (head != null) {
            System.out.println("test_2: " + head.val);
            head = head.next;
        }
    }
}
