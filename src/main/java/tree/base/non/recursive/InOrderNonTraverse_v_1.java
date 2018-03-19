package tree.base.non.recursive;

import org.junit.Test;

// *
// * *
// * * * *
/**
 * 中序遍历非递归版
 *
 * @author caiqiang
 * @version 2018年2月27日
 * @see InOrderNonTraverse_v_1
 * @since
 */
public class InOrderNonTraverse_v_1 {

	TreeNode[] stack = new TreeNode[1000];

	int i = 0;

	public void inOrder(TreeNode root) {

		if (root == null) {
			return;
		}

		while (!isEmpty(stack) || root != null) {
			if (root != null) {
				push(root);
				root = root.left;
			} else {
				root = pop();
				if (root == null)
					break;
				System.out.println(root.val);
				root = root.right;
			}

		}
	}

	private void push(TreeNode root) {
		stack[i] = root;
		i++;
	}

	private TreeNode pop() {
		TreeNode root = null;
		if (i >= 1) {
			root = stack[i - 1];
			i--;
		}
		return root;
	}

	private boolean isEmpty(TreeNode[] stack) {
		return stack.length > 0 && stack != null ? false : true;
	}

	@Test
	public void test() {
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(3);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(11);
		TreeNode node6 = new TreeNode(12);
		TreeNode node8 = new TreeNode(34);
		node1.left = node2;
		node1.right = node5;
		node5.left = node8;
		node5.right = node6;
		node2.left = node4;
		inOrder(node1);
	}
}

class TreeNode {
	int val = 0;

	TreeNode left = null;

	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}