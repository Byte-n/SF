package by.remove;

import by.utls.ListNode;

/** 19. ɾ������ĵ����� N ����� */
public class Q19 {
    public static void main(String[] args) {
        removeNthFromEnd(
                ListNode.createByList(1, 2, 3, 4, 5), 2
        );
        removeNthFromEnd(
                ListNode.createByList(1), 1
        );
        removeNthFromEnd(
                ListNode.createByList(1, 2), 2
        );
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int index = 0;
        int limit = n
                // ���絹���ڶ�λ��2��ѭ�����Σ������ߵ��� 0 ��1�������� 1 ��2
                - 1
                // ������ head ǰ������һ������ͷ�ڵ㡣fast �� slow ��Ĭ��ָ�� ta
                + 1;
        ListNode tmpHead = new ListNode(-1, head);
        ListNode fast = tmpHead, slow = tmpHead;
        while (fast != null) {
            // ע�����ﲻ�� index >= n
            // ���磺tmpHead -> 1 -> 2 -> 3 -> 4 -> 5, n = 2
            // >= ʱ slow tmpHead -> 1 -> fast 2 -> 3 -> 4 -> 5 -> null
            //       tmpHead -> 1 -> 2 -> 3 -> slow 4 -> 5 -> fast null

            // >  ʱ slow tmpHead -> 1 -> 2 -> fast 3 -> 4 -> 5 -> null
            //       tmpHead -> 1 -> 2 -> slow 3 -> 4 -> 5 -> fast null
            // ��Ϊ ɾ�� �ڵ� 4��������Ҫ��ȡ�� slow 3 �ڵ㡣
            if (index > limit) {
                slow = slow.next;
            } else {
                index++;
            }
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return tmpHead.next;
    }
}
