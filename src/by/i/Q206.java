package by.i;

import by.utls.ListNode;

/** 206. 反转链表 */
public class Q206 {
    public static void main(String[] args) {
        ListNode list = ListNode.createByList(1, 2, 3, 4, 5);
        System.out.println(list);
        ListNode node = reverseList(list);
        System.out.println(node);
    }

    // 迭代 版本
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null, next = head;
        while (next != null) {

            ListNode nextTmp = next.next;
            next.next = pre;
            pre = next;

            next = nextTmp;
        }
        return pre;
    }


    // 递归 1
    // public static ListNode reverseList(ListNode head) {
    //     return reverse(null, head);
    // }
    //
    // private static ListNode reverse(ListNode prev, ListNode cur) {
    //     if (cur == null) {
    //         return prev;
    //     }
    //     // 先保存下一个节点
    //     ListNode temp = cur.next;
    //     cur.next = prev;// 反转
    //     // 更新prev、cur位置
    //     return reverse(cur, temp);
    // }

    // 递归 2
    // public static ListNode reverseList(ListNode head) {
    //     if (head == null) {
    //         return null;
    //     }
    //     ListNode tmp = new ListNode(-1);
    //     reverseList(tmp, head);
    //     return tmp.next;
    // }
    //
    // /**
    //  * 迭代反转 链表 cur
    //  *
    //  * @param root root.next 会指向新的头节点，也就是 cur 链表的最后一个元素
    //  * @param cur  链表
    //  * @return 迭代，返回 cur 的下一个元素，如果没有则返回cur并终止迭代。
    //  */
    // public static ListNode reverseList(ListNode root, ListNode cur) {
    //
    //     // cur -> next -> next ..
    //     // cur 和 next -> next ...
    //     // 将 cur 节点 和 next 节点分开
    //     ListNode next = cur.next;
    //     cur.next = null;
    //
    //     // 下一个节点为空，表示到了链表末尾。cur -> null
    //     if (next == null) {
    //         // root.next 指向 反转后新链表的头部，除此之外，别无他用
    //         root.next = cur;
    //         // 反转链表的开始，这里返回 cur。cur 即为反转后新链表的头部
    //         return cur;
    //     }
    //     // 返回的 parent 为 新链表的，最后一个节点。
    //     ListNode parent = reverseList(root, next);
    //     // 将 当前节点，挂载最后。
    //     parent.next = cur;
    //     // 返回当前节点。因为上一步后，cur就变成最后一个节点了。
    //     return cur;
    // }
}
