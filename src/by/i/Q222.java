package by.i;

import by.utls.TreeNode;

import java.util.Stack;

public class Q222 {

    // 递归法 DFS
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNodes(root.left);
        if (leftCount == 0) {
            // 题目提供的 root 一定是 完全二叉树，如果 左节点为空，右节点一定为空
            return 1;
        }
        int rightCount = countNodes(root.right);
        return 1 + leftCount + rightCount;
    }

    // 栈 BFS
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        while (!stack.isEmpty()) {
            count++;
            TreeNode pop = stack.pop();
            if (pop.left == null) {
                // 题目提供的 root 一定是 完全二叉树，如果 左节点为空，右节点一定为空
                continue;
            }
            stack.add(pop.left);
            if (pop.right != null) {
                stack.add(pop.right);
            }
        }
        return count;
    }
}
