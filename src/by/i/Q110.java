package by.i;

import by.utls.TreeNode;

public class Q110 {
    public boolean isBalanced(TreeNode root) {
        return computeHeight(root) != -1;
    }

    private int computeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // �ȼ������������� �߶�
        int leftHeight = computeHeight(root.left);
        int rightHeight = computeHeight(root.right);
        // �ٸ������������ĸ߶ȣ��ж��Ե�ǰ �ڵ� Ϊ���ڵ�� �����ǲ��� ƽ����
        if (leftHeight < 0 || rightHeight < 0) {
            return -1;
        } else if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
