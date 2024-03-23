package by.i;

import by.utls.TreeCreator;
import by.utls.TreeNode;

import java.util.*;

/**
 * 145. �������ĺ������
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

    // ������� ����
    public static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            // ��ڵ�ȫ����ջ
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // ջ���ڵ�
            root = stack.pop();
            // û�� ���ӽڵ�
            if (root.right == null
                    // ���� ���ӽڵ� ���� �ϸ���ջ�Ľڵ�
                    /*
                    ���� root = 3, left = 9, right = (root = 4, left = 5, right = 7)

                    [3,9 ջ��] ����ջ,3,9, root = null
                    [3 ջ��] ��ջ 9, 9.right == null��prev = 9
                    [3 ջ��] ��ջ 3�� 3.right != null ��ջ3, root = 3.right
                    [3,4,5 ջ��] ��ջ4���Լ� 4.left, root = null
                    [3,4 ջ��] ��ջ 5, 5.right == null, prev = 5
                    [3,4 ջ��] ��ջ 4��4.right != null ��ջ4, root = 4.right
                    [3,4, 7 ջ��] ��ջ 7, root = null
                    [3,4 ջ��] ��ջ 7, 7.right == null, prev = 7
                    [3, ջ��] ��ջ 4, 4.right == prev, prev = 4
                    [ ջ��] ��ջ 3, 3.right == prev, prev = 3

                    ջ�գ�root Ҳ��,�ݹ���ֹ
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

    // ȡ��
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
            // ���ڵ� ���� ����
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        // �� ���ڵ� ���� ���� ��תΪ ���� ���� ���ڵ�
        Collections.reverse(list);
        return list;
    }

    // �ݹ�
    public List<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dieDai(root, list);
        return list;
    }

    public void dieDai(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        // �� ���� ���� ���ڵ�
        dieDai(root.left, list);
        dieDai(root.right, list);
        list.add(root.val);
    }
}
