package by.i;

import by.utls.TreeCreator;
import by.utls.TreeNode;

import java.util.ArrayDeque;

public abstract class Q111 {
    /**
     * 递归
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            // 返回当前 root 树的深度
            return 0;
        }
        int leftDepth = minDepth(root.left);           // 左
        int rightDepth = minDepth(root.right);         // 右
        // 中
        // // 当一个左子树为空，右不为空，这时并不是最低点
        // if (leftDepth == 0 && rightDepth != 0) {
        //     // 1 是 root 不为空，累计的高度
        //     return 1 + rightDepth;
        // }
        // // 当一个右子树为空，左不为空，这时并不是最低点
        // if (leftDepth != 0 && rightDepth == 0) {
        //     return 1 + leftDepth;
        // }

        // 上面简化为, 有
        if (leftDepth == 0 || rightDepth == 0) {
            return 1 + Math.max(leftDepth, rightDepth);
        }

        // 两个子树一样高 || 叶子节点
        return 1 + Math.min(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        minDepth1(
                TreeCreator
                        .create(1)
                        .leftSon(2, creator -> creator.left(4))
                        .rightSon(3, creator -> creator.right(5))
                        .build(TreeNode::new)
        );
    }

    public static int minDepth1(TreeNode root) {
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
            // 左右节点都为空的，即为 叶子节点
            if (pop.left == null && pop.right == null) {
                return count + 1;
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
