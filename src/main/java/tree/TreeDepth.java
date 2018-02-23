package tree;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * @author BrianCai
 * @version 2017年12月27日
 * @see TreeDepth
 * @since
 */
public class TreeDepth {
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int m = treeDepth(root.left);
        int n = treeDepth(root.right);
        if (m > n) {
            return m + 1;
        }
        else {
            return n + 1;
        }
    }
}
