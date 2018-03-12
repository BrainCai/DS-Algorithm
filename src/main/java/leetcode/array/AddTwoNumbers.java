package leetcode.array;

import org.junit.Test;

/**
 * leetcode第二道题：<br>
 * 解题关键是：<br>
 * 两个链表的问题，一定是一起处理，要么强制都不可为空，要么任一为空即可。<br>
 * 本解的一个亮点就是使用整除和模运算来获取进位和不进位的数。<br>
 * 联系：<br>
 * 此题是否与二进制，不使用运算符，求解两个数的和，似有些许联系，另外与两个链表的合并区别在什么地方<br>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) <br>
 * Output: 7 -> 0 -> 8<br>
 * 342 + 465 = 807.
 *
 * @author caiqiang
 * @version 2018年3月11日
 * @see AddTwoNumbers
 * @since
 */

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode c1 = l1;
		ListNode c2 = l2;
		ListNode sentinel = new ListNode(0);
		ListNode d = sentinel;
		int sum = 0;
		while (c1 != null || c2 != null) {
			sum /= 10;// 取得进位数
			if (c1 != null) {
				sum += c1.val;
				c1 = c1.next;
			}
			if (c2 != null) {
				sum += c2.val;
				c2 = c2.next;
			}
			d.next = new ListNode(sum % 10);// 取得个位
			d = d.next;
		}
		if (sum / 10 == 1)
			d.next = new ListNode(1);
		return sentinel.next;
	}

	@Test
	public void test() {
		// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
		// Output: 7 -> 0 -> 8
		// Explanation: 342 + 465 = 807.
		// ListNode node7 = new ListNode(7, null);
		ListNode node6 = new ListNode(9, null);
		ListNode node5 = new ListNode(9, node6);
		ListNode node4 = new ListNode(9, node5);
		// 1-7
		// -2-2-3-7
		ListNode node2 = new ListNode(1, null);
		// ListNode node1 = new ListNode(6, node2);
		// ListNode head = new ListNode(5, node1);

		// ListNode node = addTwoNumbers(head, node4);
		ListNode node = addTwoNumbers(node2, node4);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
