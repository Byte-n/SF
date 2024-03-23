package by.utls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreePrinter {
    TreeNode root;
    PrintText text;

    public TreePrinter(TreeNode root, PrintText text) {
        this.root = root;
        this.text = text;
    }

    private static final String BASE_EMPTY_LINK = "\t";

    private static final String BASE_LINE_LINK = "____";

    private static final String V_LINE = "|";

    private final Map<TreeNode, CooAndLen> nodesCoo = new HashMap<>();

    static class CooAndLen {
        private final int x;// x坐标
        private final int length;// 数字长度

        public CooAndLen(int x, int length) {
            this.x = x;
            this.length = length;
        }
    }

    void calculateCoordinate() {
        List<TreeNode> nodes = new ArrayList<>();
        midOrder(root, nodes);
        if (nodes.isEmpty()) return;
        int offset = 0;
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode node = nodes.get(i);
            int len = numberLength(node);
            nodesCoo.put(node, new CooAndLen(i + offset, len));
            offset += len;
        }
    }

    void midOrder(TreeNode cur, List<TreeNode> list) {
        if (cur == null) return;
        midOrder(cur.left, list);
        list.add(cur);
        midOrder(cur.right, list);
    }

    String getNodeText(TreeNode node) {
        return text.text(node);
    }

    int numberLength(TreeNode node) {
        if (node == null) return 0;
//		int count = 1, data = node.toPrintString();
//		while ((data /= 10) > 0) {
//			count++;
//		}
        int count = this.getNodeText(node).length();
        return count / 4;
    }

    public String print() {
        calculateCoordinate();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        return printRow(nodes);
    }


    String printRow(List<TreeNode> nodes) {
        if (nodes.size() == 0) return "";
        List<TreeNode> children = new ArrayList<>(nodes.size() * 2);
        StringBuilder VLineInNumHead = new StringBuilder();
        StringBuilder dataLine = new StringBuilder();
        StringBuilder linkSonLine = new StringBuilder();
        TreeNode prev = null;
        TreeNode lastRight = null;
        for (TreeNode node : nodes) {
            String VLineEmpty = getLinkLine(nodeDistance(node, prev, 0), BASE_EMPTY_LINK);
            String numberEmpty = getLinkLine(nodeDistance(node, prev, prevLength(prev)), BASE_EMPTY_LINK);
            VLineInNumHead.append(VLineEmpty).append(V_LINE);
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (node.red)
                dataLine.append(numberEmpty).append("\033[91;1m").append(this.getNodeText(node)).append("\033[0m");
            else
                dataLine.append(numberEmpty).append(this.getNodeText(node));
            if (left == null && right == null) {
                prev = node;
                continue;
            }
            String linkSon = linkSonLine(node, children);
            String sonLineEmpty = getLinkLine(nodeDistance(leftNode(node), lastRight, 0), BASE_EMPTY_LINK);
            linkSonLine.append(sonLineEmpty).append(linkSon);
            prev = node;
            lastRight = lastRight(prev);
        }
//		System.out.println(VLineInNumHead + "\n" + dataLine + "\n" + linkSonLine);
        return VLineInNumHead + "\n" + dataLine + "\n" + linkSonLine + "\n" + printRow(children);
    }

    String linkSonLine(TreeNode cur, List<TreeNode> children) {
        TreeNode left = cur.left;
        TreeNode right = cur.right;
        String leftLinkSonLine = "";
        String rightLinkSonLine = "";
        if (left != null) {
            children.add(left);
            leftLinkSonLine = getLinkLine(nodeDistance(cur, left, 0), BASE_LINE_LINK);
        }
        if (right != null) {
            children.add(right);
            rightLinkSonLine = getLinkLine(nodeDistance(right, cur, 0), BASE_LINE_LINK);
        }
        return leftLinkSonLine + V_LINE + rightLinkSonLine;

    }

    int prevLength(TreeNode node) {
        return node == null ? 0 : nodesCoo.get(node).length;
    }

    TreeNode lastRight(TreeNode prev) {
        if (prev == null)
            return null;
        else
            return prev.right == null ? prev : prev.right;
    }

    TreeNode leftNode(TreeNode node) {
        return node.left != null ? node.left : node;
    }


    int nodeIndex(TreeNode node) {
        return node == null ? 0 : nodesCoo.get(node).x;
    }

    int nodeDistance(TreeNode cur, TreeNode prev, int prevNumLen) {
        return nodeIndex(cur) - nodeIndex(prev) - prevNumLen;
    }


    String getLinkLine(int dis, String linkStr) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < dis; i++) {
            str.append(linkStr);
        }
        return str.toString();
    }

    public interface PrintText {
        String text(TreeNode node);
    }
}
