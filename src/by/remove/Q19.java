package by.remove;

import by.utls.ListNode;

/** 19. 删除链表的倒数第 N 个结点 */
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
                // 例如倒数第二位：2，循环两次，索引走的是 0 ，1，而不是 1 ，2
                - 1
                // 下面在 head 前新增了一个虚拟头节点。fast 和 slow 都默认指向 ta
                + 1;
        ListNode tmpHead = new ListNode(-1, head);
        ListNode fast = tmpHead, slow = tmpHead;
        while (fast != null) {
            // 注意这里不是 index >= n
            // 例如：tmpHead -> 1 -> 2 -> 3 -> 4 -> 5, n = 2
            // >= 时 slow tmpHead -> 1 -> fast 2 -> 3 -> 4 -> 5 -> null
            //       tmpHead -> 1 -> 2 -> 3 -> slow 4 -> 5 -> fast null

            // >  时 slow tmpHead -> 1 -> 2 -> fast 3 -> 4 -> 5 -> null
            //       tmpHead -> 1 -> 2 -> slow 3 -> 4 -> 5 -> fast null
            // 因为 删除 节点 4，最终需要获取到 slow 3 节点。
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
