package by.i;

import by.utls.TreeCreator;
import by.utls.TreeNode;

import java.util.*;

/**
 * 145. 二叉树的后序遍历
 */
public class Q145 {

    public static void main(String[] args) {
        postorderTraversal(
                TreeCreator
                        .create(3)
                        .left(9)
                        .rightSon(4, creator -> {
                            creator.left(5)
                                    .right(7);
                        })
                        .build(TreeNode::new)
        );
    }

    // 后序遍历 迭代
    public static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            // 左节点全部入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 栈顶节点
            root = stack.pop();
            // 没有 右子节点
            if (root.right == null
                    // 或者 右子节点 等于 上个出栈的节点
                    /*
                    例如 root = 3, left = 9, right = (root = 4, left = 5, right = 7)

                    [3,9 栈顶] 先入栈,3,9, root = null
                    [3 栈顶] 出栈 9, 9.right == null，prev = 9
                    [3 栈顶] 出栈 3， 3.right != null 入栈3, root = 3.right
                    [3,4,5 栈顶] 入栈4，以及 4.left, root = null
                    [3,4 栈顶] 出栈 5, 5.right == null, prev = 5
                    [3,4 栈顶] 出栈 4，4.right != null 入栈4, root = 4.right
                    [3,4, 7 栈顶] 入栈 7, root = null
                    [3,4 栈顶] 出栈 7, 7.right == null, prev = 7
                    [3, 栈顶] 出栈 4, 4.right == prev, prev = 4
                    [ 栈顶] 出栈 3, 3.right == prev, prev = 3

                    栈空，root 也空,递归终止
                     */
                    || root.right == prev
            ) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }

    // 取巧
    public List<Integer> postorderTraversal1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
            // 根节点 右子 左子
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        // 将 根节点 右子 左子 翻转为 左子 右子 根节点
        Collections.reverse(list);
        return list;
    }

    // 递归
    public List<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dieDai(root, list);
        return list;
    }

    public void dieDai(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        // 按 左子 右子 根节点
        dieDai(root.left, list);
        dieDai(root.right, list);
        list.add(root.val);
    }
}
