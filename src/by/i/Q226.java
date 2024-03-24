package by.i;

import by.utls.TreeNode;

import java.util.Stack;

/** 226. 翻转二叉树 */
public class Q226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            // 和前序遍历完全相同，就是这里执行交换
            swap(pop);
            // 前序遍历是，根节点 左子 右子
            // 先入 右 后入 左，左就在栈顶，
            // 当前轮是 根节点 下一轮就是 左
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }

        return root;
    }

    // 递归
    public TreeNode invertTree2(TreeNode root) {
        dieDai(root);
        return root;
    }

    public void dieDai(TreeNode root) {
        if (root == null) {
            return;
        }
        // 按 根节点 左子 右子 的顺序
        swap(root);
        // 迭代
        dieDai(root.left);
        dieDai(root.right);
    }

    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
