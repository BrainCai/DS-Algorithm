package LinkedList.base;


import org.junit.Test;

import LinkedList.ListNode;


/**
 * 链表操作中的最为基本：遍历
 *
 * @author BrianCai
 * @version 2017年12月22日
 * @see Traverse
 * @since
 */
public class Traverse {

    /**
     * Description:遍历+链表的单引用pHead
     * 
     * @param pHead
     *            void
     * @see
     */
    public void traverse_1(ListNode pHead) {
        while (pHead != null) {
            System.out.print(pHead.val + " - ");
            pHead = pHead.next;
        }
        System.out.println(" look what happened about pHead... " + pHead);
        // 输出结果：1 - 2 - 3 - 3 - 4 - 4 - 5 - look what happened about pHead... null
    }

    // 问题提出：我想在遍历之后，还能访问到整个链表怎么完成？
    // 如下程序：

    /**
     * Description: 基本的遍历+双引用
     * 
     * @param pHead
     *            void
     * @see
     */
    public void traverse_2(ListNode pHead) {
        // 对引用备份
        ListNode pHeadClone = pHead;

        while (pHead != null) {
            System.out.print(pHead.val + " - ");
            pHead = pHead.next;
        }
        System.out.println(" look what happened about pHead... " + pHead);
        System.out.println(" look what happened about pHeadClone... " + pHeadClone);
        // 输出：
        // 1 - 2 - 3 - 3 - 4 - 4 - 5 - look what happened about pHead... null
        // look what happened about pHeadClone... LinkedList.ListNode@482f8f11
        // 结论：我们对引用备份之后，我们可以通过pHeadClone来继续操作原链表。我通过debug已验证。
        // 思考这样一个问题：
        // 对于链表： 1 - 2 - 3 - 3 - 4 - 4 - 5 pHead与pHeadClone 同时指向了1，在循环赋值时，只是不断的修改pHead移动到下个结点。
        // 上面这句是废话，因为这是书上说的。

        // 虽然pHead变量不断的更新，但是在实际的 物理内存中，该链表的连接关系及值都没有改变。

        // 思维误区（或者没有明确）：会认为pHead经过while更新之后，pHead==null 那么这个链表不存在了（这是错误的）
        // 如果链表不存在，那么第二个while循环无法执行
    }

    /**
     * Description: 增加一个for循环来验证上面的结论。
     * 
     * @param pHead
     *            void
     * @see
     */
    public void traverse_3(ListNode pHead) {
        // 备份个引用
        ListNode pHeadClone = pHead;

        while (pHead != null) {
            System.out.print(pHead.val + " - ");
            pHead = pHead.next;
        }
        System.out.println(" look what happened about pHead... " + pHead);
        System.out.println(" look what happened about pHeadClone... " + pHeadClone);

        while (pHeadClone != null) {
            System.out.print(pHeadClone.val + " - ");
            pHeadClone = pHeadClone.next;
        }
        System.out.println(" look what happened about pHeadClone... " + pHeadClone);
        // 输出：
        // 1 - 2 - 3 - 3 - 4 - 4 - 5 - look what happened about pHead... null
        // look what happened about pHeadClone... LinkedList.ListNode@49c2faae
        // 1 - 2 - 3 - 3 - 4 - 4 - 5 - look what happened about pHeadClone... null
        // 实验验证了结论。
    }

    @Test
    public void test_1() {
        ListNode node6 = new ListNode(5, null);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);
        traverse_1(head);
    }

    @Test
    public void test_2() {
        ListNode node6 = new ListNode(5, null);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);
        traverse_2(head);
    }

    @Test
    public void test_3() {
        ListNode node6 = new ListNode(5, null);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);
        traverse_3(head);
    }
    // 最后的总结：
    // 我们其实就在验证，pHead=pHead.next,到底对链表做了什么，修改了什么？
    // 结论是：只是在修改pHead这个引用，而没有修改链表的链接方式和值。
    // 这个总结对于没有刷题之前，感觉是废话，因为代码就是只对pHead进行了修改，那么在刷题之后的理解更加深刻。
    // 这是对刷题过程中，心中充满着疑惑，为什么这么写，为什么不能那样写，把这条语句删除不行吗？
    // 等等的疑惑，我都以最为基础的东西开始，一步步演化到解决复杂的问题。以追求最后的以不变应万变（理想状态）。

}
