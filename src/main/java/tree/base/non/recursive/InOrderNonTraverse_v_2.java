package tree.base.non.recursive;


import java.util.Stack;

import org.junit.Test;


// *
// * *
// * * * *
/**
 * 中序遍历非递归版
 *
 * @author caiqiang
 * @version 2018年2月27日
 * @see InOrderNonTraverse_v_2
 * @since
 */
public class InOrderNonTraverse_v_2 {

    TreeNode[] array = new TreeNode[1000];

    int resultIndex = 0;

    public void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }

        }
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
