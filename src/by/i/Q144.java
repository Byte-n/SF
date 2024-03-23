package by.i;

import by.utls.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 144. 二叉树的前序遍历 */
public class Q144 {
    // 栈 迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
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

        return list;
    }


    // 递归
    public List<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dieDai(root, list);
        return list;
    }

    public void dieDai(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        // 按 根节点 左子 右子 的顺序
        list.add(root.val);
        // 迭代
        dieDai(root.left, list);
        dieDai(root.right, list);
    }
}
