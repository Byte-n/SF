package by.moni;

import java.util.Objects;
import java.util.Stack;

/** 150. 逆波兰表达式求值 */
public class Q150 {
    public static void main(String[] args) {
        evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
    }

    // 栈
    public static int evalRPN(String[] tokens) {
        Stack<Long> stack = new Stack<>();
        for (String s : tokens) {
            if (Objects.equals(s, "+")) {
                long b = stack.pop();
                long a = stack.pop();
                stack.push(a + b);
            } else if (Objects.equals(s, "-")) {
                long b = stack.pop();
                long a = stack.pop();
                stack.push(a - b);
            } else if (Objects.equals(s, "*")) {
                long b = stack.pop();
                long a = stack.pop();
                stack.push(a * b);
            } else if (Objects.equals(s, "/")) {
                long b = stack.pop();
                long a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Long.parseLong(s));
            }
        }
        return stack.pop().intValue();
    }

    // 递归
    public int evalRPN2(String[] tokens) {
        index = tokens.length - 1;
        return getPrefix(tokens);
    }

    int index;

    public int getPrefix(String[] tokens) {
        String token = tokens[index--];
        if (token.equals("+")) {
            int prefix1 = getPrefix(tokens);
            int prefix0 = getPrefix(tokens);
            return prefix0 + prefix1;
        } else if (token.equals("-")) {
            int prefix1 = getPrefix(tokens);
            int prefix0 = getPrefix(tokens);
            return prefix0 - prefix1;
        } else if (token.equals("*")) {
            int prefix1 = getPrefix(tokens);
            int prefix0 = getPrefix(tokens);
            return prefix0 * prefix1;
        } else if (token.equals("/")) {
            int prefix1 = getPrefix(tokens);
            int prefix0 = getPrefix(tokens);
            return prefix0 / prefix1;
        } else {
            return Integer.parseInt(token);
        }
    }
}
