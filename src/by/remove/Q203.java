package by.remove;

import by.utls.ListNode;

/** 203. 移除链表元素 */
public class Q203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 添加一个临时的头节点，
        // tmpHead -> head -> next -> next ...
        // 方便用统一的方式，移除头节点。tmpHead -> next ...
        ListNode tmpHead = new ListNode(-1, head);
        // 两个指针
        ListNode cur = head, pre = tmpHead;
        while (cur != null) {
            if (cur.val == val) {
                // a-> b -> b -> c。 要删除 b
                // 改为 a -> b -> c
                pre.next = cur.next;
                // 改完之后，pre 还是保持在 a 的位置，因为 下一个有可能还是 b
            } else {
                // pre 下移异步。
                pre = cur;
            }
            // cur 始终移动
            cur = cur.next;
        }
        return tmpHead.next;
    }

    // 和上面一样的逻辑
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode tmpHead = new ListNode(-1, head);
        // 两个指针
        ListNode tmp = tmpHead;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                // 删除 next 节点
                tmp.next = tmp.next.next;
                // 进入下次循环，因为下一个节点 也可能是 val
                continue;
            }
            // 如果不是 则步进 到下一个
            tmp = tmp.next;
        }
        return tmpHead.next;
    }
    // 官方递归版本
    public ListNode removeElementsO(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElementsO(head.next, val);
        return head.val == val ? head.next : head;
    }
}
