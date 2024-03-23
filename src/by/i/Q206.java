package by.i;

import by.utls.ListNode;

/** 206. ��ת���� */
public class Q206 {
    public static void main(String[] args) {
        ListNode list = ListNode.createByList(1, 2, 3, 4, 5);
        System.out.println(list);
        ListNode node = reverseList(list);
        System.out.println(node);
    }

    // ���� �汾
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


    // �ݹ� 1
    // public static ListNode reverseList(ListNode head) {
    //     return reverse(null, head);
    // }
    //
    // private static ListNode reverse(ListNode prev, ListNode cur) {
    //     if (cur == null) {
    //         return prev;
    //     }
    //     // �ȱ�����һ���ڵ�
    //     ListNode temp = cur.next;
    //     cur.next = prev;// ��ת
    //     // ����prev��curλ��
    //     return reverse(cur, temp);
    // }

    // �ݹ� 2
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
    //  * ������ת ���� cur
    //  *
    //  * @param root root.next ��ָ���µ�ͷ�ڵ㣬Ҳ���� cur ��������һ��Ԫ��
    //  * @param cur  ����
    //  * @return ���������� cur ����һ��Ԫ�أ����û���򷵻�cur����ֹ������
    //  */
    // public static ListNode reverseList(ListNode root, ListNode cur) {
    //
    //     // cur -> next -> next ..
    //     // cur �� next -> next ...
    //     // �� cur �ڵ� �� next �ڵ�ֿ�
    //     ListNode next = cur.next;
    //     cur.next = null;
    //
    //     // ��һ���ڵ�Ϊ�գ���ʾ��������ĩβ��cur -> null
    //     if (next == null) {
    //         // root.next ָ�� ��ת���������ͷ��������֮�⣬��������
    //         root.next = cur;
    //         // ��ת����Ŀ�ʼ�����ﷵ�� cur��cur ��Ϊ��ת���������ͷ��
    //         return cur;
    //     }
    //     // ���ص� parent Ϊ ������ģ����һ���ڵ㡣
    //     ListNode parent = reverseList(root, next);
    //     // �� ��ǰ�ڵ㣬�������
    //     parent.next = cur;
    //     // ���ص�ǰ�ڵ㡣��Ϊ��һ����cur�ͱ�����һ���ڵ��ˡ�
    //     return cur;
    // }
}
