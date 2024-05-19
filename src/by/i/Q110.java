package by.i;

import by.utls.TreeNode;

public class Q110 {
    public boolean isBalanced(TreeNode root) {
        return computeHeight(root) != -1;
    }

    private int computeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 先计算两个子树的 高度
        int leftHeight = computeHeight(root.left);
        int rightHeight = computeHeight(root.right);
        // 再根据两个子树的高度，判断以当前 节点 为根节点的 树，是不是 平衡树
        if (leftHeight < 0 || rightHeight < 0) {
            return -1;
        } else if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
