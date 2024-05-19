package by.i;

import by.utls.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), root);
        return result;
    }

    private void backtrack(List<String> result, List<String> curPath, TreeNode cur) {

        curPath.add(String.valueOf(cur.val));

        // 当前是叶子节点，则记录路径
        if (cur.left == null && cur.right == null) {
            result.add(toPath(curPath));
            // 回溯
            curPath.remove(curPath.size() - 1);
            return;
        }

        if (cur.left != null) {
            backtrack(result, curPath, cur.left);
        }

        if (cur.right != null) {
            backtrack(result, curPath, cur.right);
        }

        // 回溯
        curPath.remove(curPath.size() - 1);
    }

    private String toPath(List<String> curPath) {
        StringBuilder builder = new StringBuilder();
        for (String s : curPath) {
            builder.append(s).append("->");
        }
        return builder.substring(0, builder.length() - 2);
    }
}
