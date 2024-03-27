package by.i;

import by.utls.TreeCreator;
import by.utls.TreeNode;

import java.util.ArrayDeque;

public abstract class Q111 {
    /**
     * �ݹ�
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            // ���ص�ǰ root �������
            return 0;
        }
        int leftDepth = minDepth(root.left);           // ��
        int rightDepth = minDepth(root.right);         // ��
        // ��
        // // ��һ��������Ϊ�գ��Ҳ�Ϊ�գ���ʱ��������͵�
        // if (leftDepth == 0 && rightDepth != 0) {
        //     // 1 �� root ��Ϊ�գ��ۼƵĸ߶�
        //     return 1 + rightDepth;
        // }
        // // ��һ��������Ϊ�գ���Ϊ�գ���ʱ��������͵�
        // if (leftDepth != 0 && rightDepth == 0) {
        //     return 1 + leftDepth;
        // }

        // �����Ϊ, ��
        if (leftDepth == 0 || rightDepth == 0) {
            return 1 + Math.max(leftDepth, rightDepth);
        }

        // ��������һ���� || Ҷ�ӽڵ�
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
            // ���ҽڵ㶼Ϊ�յģ���Ϊ Ҷ�ӽڵ�
            if (pop.left == null && pop.right == null) {
                return count + 1;
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
