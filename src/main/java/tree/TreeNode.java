package tree;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TreeNode {
    int val = 0;

    TreeNode left = null;

    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
