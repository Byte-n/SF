package by.sel;

import by.utls.ListNode;

import java.util.HashSet;

/** 142. �������� II */
public class Q142 {
    // ˫ָ��
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            // ����ָ�벽��
            fast = fast.next.next;
            slow = slow.next;
            // δ����
            if (slow != fast) {
                continue;
            }
            // ��ָ���ͷ��,��ָ������������
            slow = head;
            while (slow != fast) {
                // ��������Ϊ1
                fast = fast.next;
                slow = slow.next;
            }
            // ���ؽ��
            return slow;
        }
        return null;
    }

    // ʹ�ü���
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
