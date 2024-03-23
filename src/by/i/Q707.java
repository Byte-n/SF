package by.i;

/**
 * 707. 设计链表
 */
public class Q707 {
    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    class MyLinkedList {
        Node root = new Node(-1, null);

        public MyLinkedList() {

        }

        public int get(int index) {
            Node pre = getPreNode(index);
            if (pre == null || pre.next == null) {
                return -1;
            }
            return pre.next.val;
        }

        public void addAtHead(int val) {
            root.next = new Node(val, root.next);
        }

        public void addAtTail(int val) {
            Node cur = root;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(val);
        }

        public void addAtIndex(int index, int val) {
            Node pre = getPreNode(index);
            // 注意判空
            if (pre == null) {
                return;
            }
            pre.next = new Node(val, pre.next);
        }

        public void deleteAtIndex(int index) {
            Node pre = getPreNode(index);
            // 注意判空
            if (pre == null || pre.next == null) {
                return;
            }
            pre.next = pre.next.next;
        }

        /**
         * 获取 index 节点的删一个节点
         */
        private Node getPreNode(int index) {
            int count = 0;
            Node cur = root;
            while (count < index) {
                if (cur.next == null) {
                    return null;
                }
                cur = cur.next;
                count++;
            }
            return cur;
        }
    }
}
