import java.util.LinkedList;

public class BinodeLcci1712 {
    public TreeNode convertBiNode(TreeNode root) {
        LinkedList<TreeNode> link = new LinkedList<TreeNode>();
        midOrder(root, link);
        TreeNode first = null;
        TreeNode tmp = null;
        for (TreeNode treeNode : link) {
            treeNode.left = null;
            treeNode.right = null;
            if (first == null) {
                first = treeNode;
                tmp = treeNode;
            } else {
                tmp.right = treeNode;
                tmp = treeNode;
            }
        }

        return first;
    }

    public static void midOrder(TreeNode root, LinkedList<TreeNode> link) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            midOrder(root.left, link);
        }
        link.add(root);
        if (root.right != null) {
            midOrder(root.right, link);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
