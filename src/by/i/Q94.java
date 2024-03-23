package by.i;

import by.utls.TreeCreator;
import by.utls.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 94. ��������������� */
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

    // ջ ����
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        // ��ǰ��ڵ�
        TreeNode cur = root.left;
        while (cur != null || !stack.isEmpty()) {
            // �������ڵ㣬��һֱ��ջ
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                // ��ǰ��ڵ� Ϊ�� = ��һ�ڵ���Ҷ�ӽڵ� �� ֻ�� �ҽڵ�
                TreeNode tmp = stack.pop();
                list.add(tmp.val);
                // �����ҽڵ�
                cur = tmp.right;
            }
        }
        return list;
    }

    // �ݹ�
    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dieDai(root, list);
        return list;
    }

    public void dieDai(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        // �� ���� ���ڵ� ���� ��˳��
        dieDai(root.left, list);
        list.add(root.val);
        dieDai(root.right, list);
    }
}
