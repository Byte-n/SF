package by.i;

import by.utls.TreeCreator;
import by.utls.TreeNode;

import java.util.*;

/** 102. 二叉树的层序遍历 */
public class Q102 {
    public static void main(String[] args) {
        levelOrder(TreeCreator.create(3).leftSon(9, creator -> {
            creator.left(5).right(7);
        }).rightSon(4).build(TreeNode::new));
    }


    // 递归
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        // 递归
        diedai(root, 0, resList);
        return resList;
    }

    // 递归方法
    public static void diedai(TreeNode node, int deep, List<List<Integer>> resList) {
        if (node == null) {
            return;
        }
        // 层数 + 1
        deep++;
        // 每一层开始时，扩容一个数组
        if (resList.size() < deep) {
            List<Integer> list = new ArrayList<>();
            resList.add(list);
        }
        resList.get(deep - 1).add(node.val);

        diedai(node.left, deep, resList);
        diedai(node.right, deep, resList);
    }

    public static void diedai(TreeNode root, List<Integer> list) {
        list.add(root.val);

    }

    // 队列
    public static List<List<Integer>> levelOrder1(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        // [前 ... 后]
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        // 上一行 最后一个元素
        TreeNode last = root;
        // 上一波最后一个
        TreeNode prev = null;
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 从前面取第一个
            TreeNode pop = queue.poll();
            temp.add(pop.val);

            // 队列尾
            if (pop.left != null) {
                queue.add(pop.left);
                prev = pop.left;
            }
            // 队列尾
            if (pop.right != null) {
                queue.add(pop.right);
                prev = pop.right;
            }

            // 上一行已经结束，从开一行
            if (pop == last) {
                lists.add(temp);
                temp = new ArrayList<>();
                last = prev;
            }
        }
        return lists;
    }

}
