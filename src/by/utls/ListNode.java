package by.utls;

import java.util.WeakHashMap;

/** 206. 反转链表 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        WeakHashMap<ListNode, Integer> map = new WeakHashMap<>();
        StringBuilder builder = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            if (map.containsKey(cur)) {
                builder.append(" -循环> ").append(cur.val);

                return builder.toString();
            }
            if (!map.isEmpty()) {
                builder.append(" -> ");
            }
            map.put(cur, cur.val);
            builder.append(cur.val);
            cur = cur.next;
        }
        builder.append(" -> null");
        return builder.toString();
    }

    public static ListNode createByList(int... args) {
        ListNode node = new ListNode();
        ListNode cur = node;
        for (int arg : args) {
            cur.next = new ListNode(arg);
            cur = cur.next;
        }
        return node.next;
    }
}
