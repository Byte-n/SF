package by.sel;

import by.utls.ListNode;

import java.util.HashSet;

/** 142. 环形链表 II */
public class Q142 {
    // 双指针
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            // 快慢指针步进
            fast = fast.next.next;
            slow = slow.next;
            // 未相遇
            if (slow != fast) {
                continue;
            }
            // 慢指针从头走,快指针从相遇点继续
            slow = head;
            while (slow != fast) {
                // 步进都改为1
                fast = fast.next;
                slow = slow.next;
            }
            // 返回结果
            return slow;
        }
        return null;
    }

    // 使用集合
    public ListNode detectCycle2(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
