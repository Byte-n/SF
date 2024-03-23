package by.remove;

import by.utls.ListNode;

/** 203. �Ƴ�����Ԫ�� */
public class Q203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // ���һ����ʱ��ͷ�ڵ㣬
        // tmpHead -> head -> next -> next ...
        // ������ͳһ�ķ�ʽ���Ƴ�ͷ�ڵ㡣tmpHead -> next ...
        ListNode tmpHead = new ListNode(-1, head);
        // ����ָ��
        ListNode cur = head, pre = tmpHead;
        while (cur != null) {
            if (cur.val == val) {
                // a-> b -> b -> c�� Ҫɾ�� b
                // ��Ϊ a -> b -> c
                pre.next = cur.next;
                // ����֮��pre ���Ǳ����� a ��λ�ã���Ϊ ��һ���п��ܻ��� b
            } else {
                // pre �����첽��
                pre = cur;
            }
            // cur ʼ���ƶ�
            cur = cur.next;
        }
        return tmpHead.next;
    }

    // ������һ�����߼�
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode tmpHead = new ListNode(-1, head);
        // ����ָ��
        ListNode tmp = tmpHead;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                // ɾ�� next �ڵ�
                tmp.next = tmp.next.next;
                // �����´�ѭ������Ϊ��һ���ڵ� Ҳ������ val
                continue;
            }
            // ������� �򲽽� ����һ��
            tmp = tmp.next;
        }
        return tmpHead.next;
    }
    // �ٷ��ݹ�汾
    public ListNode removeElementsO(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElementsO(head.next, val);
        return head.val == val ? head.next : head;
    }
}
