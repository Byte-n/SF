package by.moni;

import by.utls.ListNode;

/** 24. �������������еĽڵ� */
public class Q24 {
    public static void main(String[] args) {
        ListNode byList = ListNode.createByList(1, 2, 3);
        ListNode node = swapPairs(byList);
        System.out.println(node);
    }

    // �ݹ�
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // ���� head Ϊ 1-> 2 -> 3 -> 4
        // ȡ����һ��
        ListNode next = head.next;
        // �ݴ� head 1 -> next 2 -> temp 3 -> 4 ��ĵ����нڵ�
        ListNode temp = next.next;
        // ��ʱ���Ϊ��
        // head 1 -> next 2 �� temp 3 -> 4

        // �� head 1 -> swapPairs(temp 3 -> 4) �Ľ��
        head.next = swapPairs(temp);
        // ��ʱ��Ϊ��
        // head 1 -> swapPairs(temp 3 -> 4)
        //              swapPairs(temp 3 -> 4) ���صĽ���� 4 -> 3
        // next 2
        // next 2 -> head 1 -> temp 4 -> 3
        next.next = head;
        return next;
    }

    // ����
    public static ListNode swapPairs2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode tempList = new ListNode();
        ListNode tempHead = tempList;

        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            ListNode tmp = next.next;
            cur.next = null;
            next.next = cur;
            tempHead.next = next;
            tempHead = cur;
            // ����
            cur = tmp;
        }

        if (cur != null) {
            tempHead.next = cur;
        }
        return tempList.next;
    }
}
