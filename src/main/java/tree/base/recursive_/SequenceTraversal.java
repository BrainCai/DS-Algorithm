package tree.base.recursive_;


import java.util.ArrayList;

import org.junit.Test;

import com.alibaba.fastjson.JSON;


/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * @author BrianCai
 * @version 2018年2月21日
 * @see SequenceTraversal
 * @since
 */
class TreeNode {
    int val = 0;

    TreeNode left = null;

    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}


public class SequenceTraversal {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> nodeListArray = new ArrayList<>();

        if (pRoot == null) {
            return nodeListArray;
        }
        ArrayList<Integer> nodeValList = new ArrayList<>();
        ArrayList<TreeNode> nodeList = new ArrayList<>();

        int n = 1;

        nodeValList.add(pRoot.val);
        nodeList.add(pRoot);
        nodeListArray.add(nodeValList);
        addChildNodeList(nodeList, nodeListArray, n);
        System.out.println(JSON.toJSONString(nodeListArray));
        return nodeListArray;
    }

    private void addChildNodeList(ArrayList<TreeNode> pRootList,
                                  ArrayList<ArrayList<Integer>> nodeListArray, int n) {

        if (pRootList.isEmpty()) {
            return;
        }

        ArrayList<TreeNode> nodeList = null;
        while (!pRootList.isEmpty()) {
            ArrayList<TreeNode> tmpNodeList = new ArrayList<>();

            ArrayList<Integer> nodeValList = new ArrayList<>();
            for (TreeNode pRoot : pRootList) {

                addLeft(tmpNodeList, nodeValList, pRoot);
                addRight(tmpNodeList, nodeValList, pRoot);
            }
            if (!nodeValList.isEmpty() && nodeValList != null) {
                nodeListArray.add(nodeValList);
            }
            nodeList = tmpNodeList;
            pRootList.clear();
        }
        n++ ;
        addChildNodeList(nodeList, nodeListArray, n);

    }

    private void addRight(ArrayList<TreeNode> tmpNodeList, ArrayList<Integer> nodeValList,
                          TreeNode pRoot) {
        if (pRoot.right != null) {
            nodeValList.add(pRoot.right.val);
            tmpNodeList.add(pRoot.right);
        }
    }

    private void addLeft(ArrayList<TreeNode> tmpNodeList, ArrayList<Integer> nodeValList,
                         TreeNode pRoot) {
        if (pRoot.left != null) {
            nodeValList.add(pRoot.left.val);
            tmpNodeList.add(pRoot.left);
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
        Print(node1);
    }
}
