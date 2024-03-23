package by.moni;

import by.utls.ListNode;

/** 24. 两两交换链表中的节点 */
public class Q24 {
    public static void main(String[] args) {
        ListNode byList = ListNode.createByList(1, 2, 3);
        ListNode node = swapPairs(byList);
        System.out.println(node);
    }

    // 递归
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 假设 head 为 1-> 2 -> 3 -> 4
        // 取出下一个
        ListNode next = head.next;
        // 暂存 head 1 -> next 2 -> temp 3 -> 4 后的的所有节点
        ListNode temp = next.next;
        // 此时拆分为了
        // head 1 -> next 2 和 temp 3 -> 4

        // 将 head 1 -> swapPairs(temp 3 -> 4) 的结果
        head.next = swapPairs(temp);
        // 此时变为了
        // head 1 -> swapPairs(temp 3 -> 4)
        //              swapPairs(temp 3 -> 4) 返回的结果是 4 -> 3
        // next 2
        // next 2 -> head 1 -> temp 4 -> 3
        next.next = head;
        return next;
    }

    // 迭代
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
            // 步进
            cur = tmp;
        }

        if (cur != null) {
            tempHead.next = cur;
        }
        return tempList.next;
    }
}
