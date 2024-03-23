package by.i;

import by.utls.TreeCreator;
import by.utls.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 94. 二叉树的中序遍历 */
public class Q94 {
    public static void main(String[] args) {
        TreeNode build = TreeCreator.create(1)
                .rightSon(2,
                        root -> root.left(3)
                )
                .build(TreeNode::new);
        List<Integer> integers = inorderTraversal(build);
        System.out.println(integers);
    }

    // 栈 迭代
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        // 当前左节点
        TreeNode cur = root.left;
        while (cur != null || !stack.isEmpty()) {
            // 如果有左节点，就一直入栈
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                // 当前左节点 为空 = 上一节点是叶子节点 或 只有 右节点
                TreeNode tmp = stack.pop();
                list.add(tmp.val);
                // 处理右节点
                cur = tmp.right;
            }
        }
        return list;
    }

    // 递归
    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dieDai(root, list);
        return list;
    }

    public void dieDai(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        // 按 左子 根节点 右子 的顺序
        dieDai(root.left, list);
        list.add(root.val);
        dieDai(root.right, list);
    }
}
