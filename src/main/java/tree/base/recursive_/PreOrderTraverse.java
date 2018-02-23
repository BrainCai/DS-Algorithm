package tree.base.recursive_;


import org.junit.Test;

import tree.TreeNode;


/**
 * 前序遍历
 *
 * @author BrianCai
 * @version 2018年1月25日
 * @see PreOrderTraverse
 * @since
 */
public class PreOrderTraverse {

    public void preOrderTraverse(TreeNode node) {

        if (node != null) {
            System.out.print(node.getVal() + " - ");
            preOrderTraverse(node.getLeft());
            preOrderTraverse(node.getRight());
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
        node1.setLeft(node2);
        node1.setRight(node5);
        node5.setLeft(node8);
        node5.setRight(node6);
        node2.setLeft(node4);
        preOrderTraverse(node1);
    }
}
