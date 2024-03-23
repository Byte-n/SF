package by.i;

import by.utls.ListNode;

import java.util.HashSet;

/** ������ 02.07. �����ཻ */
public class Q160 {
    public static void main(String[] args) {
        ListNode some = ListNode.createByList(4, 1, 8, 4, 5);
        ListNode a = ListNode.createByList(4);
        a.next = some;
        ListNode b = ListNode.createByList(5, 0);
        b.next = some;
        getIntersectionNode2(a, b);
    }

    // ����
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // ������������ĳ���
        int lenA = count(headA);
        int lenB = count(headB);

        // ����� ���Ͷ̵ġ�
        ListNode longHead, shortHead;
        // ����֮��������
        int c;
        if (lenA > lenB) {
            longHead = headA;
            shortHead = headB;
            c = lenA - lenB;
        } else {
            longHead = headB;
            shortHead = headA;
            c = lenB - lenA;
        }
        // �����ģ�����ǰ�ƶ� ���Ȳ� �Ĳ����������ƶ�ǰ
        // a�� 1 -> 2 -> 3 -> 4 -> 5
        // b�� 6 -> 4 -> 5
        while (c > 0) {
            longHead = longHead.next;
            c--;
        }
        // �ƶ���
        // a�� 3 -> 4 -> 5
        // b�� 6 -> 4 -> 5

        // һ������жϣ����ɵõ���
        while (longHead != shortHead) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return longHead;
    }

    public static int count(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // �������ٵķ���
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != null && curB != null) {
            curA = curA.next;
            curB = curB.next;
        }

        // �ҳ����ĺͶ̵�
        ListNode longHead = headA, shortHead = headB, longCur = curA;
        if (curA == null) {
            longCur = curB;
            longHead = headB;
            shortHead = headA;
        }

        while ((longCur != null) || (longHead != shortHead)) {
            if (longCur != null) {
                longCur = longCur.next;
                longHead = longHead.next;
                continue;
            }
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return longHead;
    }

    // ˫ָ�� ������
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    // ʹ��set
    public static ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null || headB != null) {
            if (headA != null) {
                if (set.contains(headA)) {
                    return headA;
                }
                set.add(headA);
                headA = headA.next;
            }
            if (headB != null) {
                if (set.contains(headB)) {
                    return headB;
                }
                set.add(headB);
                headB = headB.next;
            }
        }
        return null;
    }
}
