package by.i;

import by.utls.TreeNode;

import java.util.Stack;

public class Q222 {

    // �ݹ鷨 DFS
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNodes(root.left);
        if (leftCount == 0) {
            // ��Ŀ�ṩ�� root һ���� ��ȫ����������� ��ڵ�Ϊ�գ��ҽڵ�һ��Ϊ��
            return 1;
        }
        int rightCount = countNodes(root.right);
        return 1 + leftCount + rightCount;
    }

    // ջ BFS
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        while (!stack.isEmpty()) {
            count++;
            TreeNode pop = stack.pop();
            if (pop.left == null) {
                // ��Ŀ�ṩ�� root һ���� ��ȫ����������� ��ڵ�Ϊ�գ��ҽڵ�һ��Ϊ��
                continue;
            }
            stack.add(pop.left);
            if (pop.right != null) {
                stack.add(pop.right);
            }
        }
        return count;
    }
}
