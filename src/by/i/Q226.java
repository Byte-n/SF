package by.i;

import by.utls.TreeNode;

import java.util.Stack;

/** 226. ��ת������ */
public class Q226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            // ��ǰ�������ȫ��ͬ����������ִ�н���
            swap(pop);
            // ǰ������ǣ����ڵ� ���� ����
            // ���� �� ���� �������ջ����
            // ��ǰ���� ���ڵ� ��һ�־��� ��
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }

        return root;
    }

    // �ݹ�
    public TreeNode invertTree2(TreeNode root) {
        dieDai(root);
        return root;
    }

    public void dieDai(TreeNode root) {
        if (root == null) {
            return;
        }
        // �� ���ڵ� ���� ���� ��˳��
        swap(root);
        // ����
        dieDai(root.left);
        dieDai(root.right);
    }

    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
