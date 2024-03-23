package by.moni;


import java.util.ArrayDeque;
import java.util.Queue;
/** 225. �ö���ʵ��ջ */
public class Q225 {
    public static void main(String[] args) {
        // ["MyStack","push","push","top","pop","empty"]
        // [[],[1],[2],[],[],[]]
        // ["MyStack","push","push","pop","top"]
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        int pop = stack.pop();
        int top = stack.top();
        boolean empty = stack.empty();
    }
}

class MyStack {
    Queue<Integer> insert = new ArrayDeque<>();

    public MyStack() {

    }

    public void push(int x) {
        insert.add(x);
    }

    // �Ƴ�������ջ��Ԫ�ء�
    public int pop() {
        // ����һ����ʱ�Ķ��У���¼���г����е�
        Queue<Integer> temp = new ArrayDeque<>();
        // ���һ�������еģ��Ƚ��ȳ��� = ջ�����Ƚ������
        int last = -1;
        while (!insert.isEmpty()) {
            last = insert.poll();
            temp.add(last);
        }
        // ������ȥ��
        while (!temp.isEmpty()) {
            int tm = temp.poll();
            // ���Ϊ���ˣ����ʾ tm �����һ����ֱ�Ӳ����� = �Ƴ�
            // [����ǰ 1��2��3 ���к�]  --������ʱ����--> [����ǰ 3,2,1 ���к�]
            // �ƶ���ȥ��ʱ��[����ǰ 1��2 ���к�] ��3������
            if (temp.isEmpty()) {
                return last;
            }
            insert.add(tm);
        }
        return last;
    }

    public int top() {
        Queue<Integer> temp = new ArrayDeque<>();
        // ͬ pop
        int last = -1;
        while (!insert.isEmpty()) {
            last = insert.poll();
            temp.add(last);
        }
        // ȫ������ȥ��
        insert.addAll(temp);
        return last;
    }

    public boolean empty() {
        return insert.isEmpty();
    }

}
