package by.i;

import by.utls.TreeCreator;
import by.utls.TreeNode;

import java.util.ArrayDeque;
import java.util.Stack;

public abstract class Q104 {
    /**
     * �ݹ�
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            // ���ص�ǰ root �������
            return 0;
        }
        // �����������������ĵݹ� �����ۼ��߼�
        // root ������� = ���� 1 + �����е�������
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

        // ��һ������һ���ڵ�
        TreeNode last = root;
        int count = 0;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pollFirst();

            // ��Ϊ�յģ������
            if (pop.left != null) {
                stack.addLast(pop.left);
            }
            if (pop.right != null) {
                stack.addLast(pop.right);
            }

            // �����ǰ�����е����ϲ����һ��������ζ���ϲ��������ˣ����ҵ�ǰ���Ѿ�ȫ�������
            if (pop == last) {
                count++;
                // �������һ������ǰ�����һ��
                last = stack.peekLast();
            }
        }
        return count;
    }
}
