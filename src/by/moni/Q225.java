package by.moni;


import java.util.ArrayDeque;
import java.util.Queue;
/** 225. 用队列实现栈 */
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

    // 移除并返回栈顶元素。
    public int pop() {
        // 创建一个临时的队列，记录所有出队列的
        Queue<Integer> temp = new ArrayDeque<>();
        // 最后一个出队列的（先进先出） = 栈顶（先进后出）
        int last = -1;
        while (!insert.isEmpty()) {
            last = insert.poll();
            temp.add(last);
        }
        // 再塞回去。
        while (!temp.isEmpty()) {
            int tm = temp.poll();
            // 如果为空了，则表示 tm 是最后一个，直接不塞入 = 移除
            // [队列前 1，2，3 队列后]  --移入临时队列--> [队列前 3,2,1 队列后]
            // 移动回去的时候，[队列前 1，2 队列后] （3丢弃）
            if (temp.isEmpty()) {
                return last;
            }
            insert.add(tm);
        }
        return last;
    }

    public int top() {
        Queue<Integer> temp = new ArrayDeque<>();
        // 同 pop
        int last = -1;
        while (!insert.isEmpty()) {
            last = insert.poll();
            temp.add(last);
        }
        // 全部塞回去。
        insert.addAll(temp);
        return last;
    }

    public boolean empty() {
        return insert.isEmpty();
    }

}
