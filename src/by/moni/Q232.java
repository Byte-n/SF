package by.moni;

import java.util.Stack;

/**  */
public class Q232 {
    public static void main(String[] args) {
        // ["MyQueue","push","push","peek","pop","empty"]
        // [[],[1],[2],[],[],[]]
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        int peek = myQueue.peek();
        int pop = myQueue.pop();
        boolean empty = myQueue.empty();
    }
}

class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>(); // 负责进栈
        stackOut = new Stack<>(); // 负责出栈
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumpstackIn();
        return stackOut.pop();
    }

    public int peek() {
        dumpstackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    // 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
    private void dumpstackIn() {
        if (!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}
