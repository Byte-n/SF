package by.i;

import by.utls.ListNode;

import java.util.HashSet;

/** 面试题 02.07. 链表相交 */
public class Q160 {
    public static void main(String[] args) {
        ListNode some = ListNode.createByList(4, 1, 8, 4, 5);
        ListNode a = ListNode.createByList(4);
        a.next = some;
        ListNode b = ListNode.createByList(5, 0);
        b.next = some;
        getIntersectionNode2(a, b);
    }

    // 迭代
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 计算两个链表的长度
        int lenA = count(headA);
        int lenB = count(headB);

        // 分清楚 长和短的。
        ListNode longHead, shortHead;
        // 长短之间相差多少
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
        // 将长的，先向前移动 长度差 的步数，例如移动前
        // a： 1 -> 2 -> 3 -> 4 -> 5
        // b： 6 -> 4 -> 5
        while (c > 0) {
            longHead = longHead.next;
            c--;
        }
        // 移动后
        // a： 3 -> 4 -> 5
        // b： 6 -> 4 -> 5

        // 一起迭代判断，即可得到答案
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

    // 迭代更少的方案
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != null && curB != null) {
            curA = curA.next;
            curB = curB.next;
        }

        // 找出长的和短的
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

    // 双指针 更优雅
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

    // 使用set
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
