package by.i;

import by.utls.TreeCreator;
import by.utls.TreeNode;

import java.util.ArrayDeque;
import java.util.Stack;

public abstract class Q104 {
    /**
     * 递归
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            // 返回当前 root 树的深度
            return 0;
        }
        // 后序遍历，符合这里的递归 计数累计逻辑
        // root 树的深度 = 自身 1 + 子树中的最大深度
        int leftDepth = maxDepth1(root.left);
        int rightDepth = maxDepth1(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        maxDepth(
                TreeCreator
                        .create(1)
                        .leftSon(2, creator -> creator.left(4))
                        .rightSon(3, creator -> creator.right(5))
                        .build(TreeNode::new)
        );
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        // 上一层的最后一个节点
        TreeNode last = root;
        int count = 0;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pollFirst();

            // 不为空的，入队列
            if (pop.left != null) {
                stack.addLast(pop.left);
            }
            if (pop.right != null) {
                stack.addLast(pop.right);
            }

            // 如果当前出队列的是上层最后一个，则意味着上层遍历完成了，并且当前层已经全入队列了
            if (pop == last) {
                count++;
                // 队列最后一个即当前层最后一个
                last = stack.peekLast();
            }
        }
        return count;
    }
}
